package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import com.oreillyauto.pricingmanagement.pricinglabels.model.DivisionPricingLabelCount;
import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBDivisionPricingLabelCount;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/18/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class DivisionPricingLabelCountMapAdapter extends XmlAdapter<DivisionPricingLabelCountMapAdapter.DivisionPricingLabelCountAdaptedMap, Map<String, DivisionPricingLabelCount>> {

    public static class DivisionPricingLabelCountAdaptedMap {
        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public List<DivisionPricingLabelCountItem> entry = new ArrayList<DivisionPricingLabelCountItem>();
    }

    public static class DivisionPricingLabelCountItem {
        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public String key;
        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public DivisionPricingLabelCount value;

    }

    @Override
    public Map<String, DivisionPricingLabelCount> unmarshal(DivisionPricingLabelCountAdaptedMap adaptedMap) throws Exception {
        Map<String, DivisionPricingLabelCount> map = new HashMap<String, DivisionPricingLabelCount>();
        for(DivisionPricingLabelCountItem entry : adaptedMap.entry) {
            map.put(entry.key, entry.value);
        }
        return map;
    }

    @Override
    public DivisionPricingLabelCountAdaptedMap marshal(Map<String, DivisionPricingLabelCount> map) throws Exception {
        DivisionPricingLabelCountAdaptedMap adaptedMap = new DivisionPricingLabelCountAdaptedMap();
        for(Map.Entry<String, DivisionPricingLabelCount> mapEntry : map.entrySet()) {
            DivisionPricingLabelCountItem entry = new DivisionPricingLabelCountItem();
            entry.key = mapEntry.getKey();
            entry.value = mapEntry.getValue();
            adaptedMap.entry.add(entry);
        }
        return adaptedMap;
    }

}