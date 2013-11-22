package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/5/13
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBDivisionPricingLabelCount;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JAXBDivisionPricingLabelCountMapAdapter extends XmlAdapter<JAXBDivisionPricingLabelCountMapAdapter.DivisionPricingLabelCountAdaptedMap, Map<String, JAXBDivisionPricingLabelCount>> {

    public static class DivisionPricingLabelCountAdaptedMap {

        public List<DivisionPricingLabelCountItem> entry = new ArrayList<DivisionPricingLabelCountItem>();

    }

    public static class DivisionPricingLabelCountItem {

        public String key;

        public JAXBDivisionPricingLabelCount value;

    }

    @Override
    public Map<String, JAXBDivisionPricingLabelCount> unmarshal(DivisionPricingLabelCountAdaptedMap adaptedMap) throws Exception {
        Map<String, JAXBDivisionPricingLabelCount> map = new HashMap<String, JAXBDivisionPricingLabelCount>();
        for (DivisionPricingLabelCountItem item : adaptedMap.entry) {
            map.put(item.key, item.value);
        }
        return map;
    }

    @Override
    public DivisionPricingLabelCountAdaptedMap marshal(Map<String, JAXBDivisionPricingLabelCount> map) throws Exception {
        DivisionPricingLabelCountAdaptedMap adaptedMap = new DivisionPricingLabelCountAdaptedMap();
        for (Map.Entry<String, JAXBDivisionPricingLabelCount> mapEntry : map.entrySet()) {
            DivisionPricingLabelCountItem item = new DivisionPricingLabelCountItem();
            item.key = mapEntry.getKey();
            item.value = mapEntry.getValue();
            adaptedMap.entry.add(item);
        }
        return adaptedMap;
    }

}