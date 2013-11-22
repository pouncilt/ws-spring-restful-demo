package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBDistrictPricingLabelCount;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/6/13
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class JAXBDistrictPricingLabelCountMapAdapter extends XmlAdapter<JAXBDistrictPricingLabelCountMapAdapter.DistrictPricingLabelCountAdaptedMap, Map<String, JAXBDistrictPricingLabelCount>> {

    public static class DistrictPricingLabelCountAdaptedMap {

        public List<DistrictPricingLabelCountItem> entry = new ArrayList<DistrictPricingLabelCountItem>();

    }

    public static class DistrictPricingLabelCountItem {

        public String key;

        public JAXBDistrictPricingLabelCount value;

    }

    @Override
    public Map<String, JAXBDistrictPricingLabelCount> unmarshal(DistrictPricingLabelCountAdaptedMap adaptedMap) throws Exception {
        Map<String, JAXBDistrictPricingLabelCount> map = new HashMap<String, JAXBDistrictPricingLabelCount>();
        for (DistrictPricingLabelCountItem entry : adaptedMap.entry) {
            map.put(entry.key, entry.value);
        }
        return map;
    }

    @Override
    public DistrictPricingLabelCountAdaptedMap marshal(Map<String, JAXBDistrictPricingLabelCount> map) throws Exception {
        DistrictPricingLabelCountAdaptedMap adaptedMap = new DistrictPricingLabelCountAdaptedMap();
        for (Map.Entry<String, JAXBDistrictPricingLabelCount> mapEntry : map.entrySet()) {
            DistrictPricingLabelCountItem entry = new DistrictPricingLabelCountItem();
            entry.key = mapEntry.getKey();
            entry.value = mapEntry.getValue();
            adaptedMap.entry.add(entry);
        }
        return adaptedMap;
    }

}
