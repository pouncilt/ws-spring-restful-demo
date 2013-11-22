package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import com.oreillyauto.pricingmanagement.pricinglabels.model.RegionPricingLabelCount;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/18/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegionPricingLabelCountMapAdapter extends XmlAdapter<RegionPricingLabelCountMapAdapter.RegionPricingLabelCountAdaptedMap, Map<String, RegionPricingLabelCount>> {

    public static class RegionPricingLabelCountAdaptedMap {

        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public List<RegionPricingLabelCountItem> entry = new ArrayList<RegionPricingLabelCountItem>();

    }

    public static class RegionPricingLabelCountItem {

        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public String key;

        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public RegionPricingLabelCount value;

    }

    @Override
    public Map<String, RegionPricingLabelCount> unmarshal(RegionPricingLabelCountAdaptedMap adaptedMap) throws Exception {
        Map<String, RegionPricingLabelCount> map = new HashMap<String, RegionPricingLabelCount>();
        for(RegionPricingLabelCountItem entry : adaptedMap.entry) {
            map.put(entry.key, entry.value);
        }
        return map;
    }

    @Override
    public RegionPricingLabelCountAdaptedMap marshal(Map<String, RegionPricingLabelCount> map) throws Exception {
        RegionPricingLabelCountAdaptedMap adaptedMap = new RegionPricingLabelCountAdaptedMap();
        for(Map.Entry<String, RegionPricingLabelCount> mapEntry : map.entrySet()) {
            RegionPricingLabelCountItem entry = new RegionPricingLabelCountItem();
            entry.key = mapEntry.getKey();
            entry.value = mapEntry.getValue();
            adaptedMap.entry.add(entry);
        }
        return adaptedMap;
    }

}