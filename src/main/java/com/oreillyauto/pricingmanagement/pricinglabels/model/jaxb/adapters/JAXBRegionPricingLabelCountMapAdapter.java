package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBRegionPricingLabelCount;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/6/13
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */

public class JAXBRegionPricingLabelCountMapAdapter extends XmlAdapter<JAXBRegionPricingLabelCountMapAdapter.RegionPricingLabelCountAdaptedMap, Map<String, JAXBRegionPricingLabelCount>> {

        public static class RegionPricingLabelCountAdaptedMap {

            public List<JAXBRegionPricingLabelCountItem> entry = new ArrayList<JAXBRegionPricingLabelCountItem>();

        }

        public static class JAXBRegionPricingLabelCountItem {

            public String key;

            public JAXBRegionPricingLabelCount value;

        }

        @Override
        public Map<String, JAXBRegionPricingLabelCount> unmarshal(RegionPricingLabelCountAdaptedMap adaptedMap) throws Exception {
            Map<String, JAXBRegionPricingLabelCount> map = new HashMap<String, JAXBRegionPricingLabelCount>();
            for(JAXBRegionPricingLabelCountItem entry : adaptedMap.entry) {
                map.put(entry.key, entry.value);
            }
            return map;
        }

        @Override
        public RegionPricingLabelCountAdaptedMap marshal(Map<String, JAXBRegionPricingLabelCount> map) throws Exception {
            RegionPricingLabelCountAdaptedMap adaptedMap = new RegionPricingLabelCountAdaptedMap();
            for(Map.Entry<String, JAXBRegionPricingLabelCount> mapEntry : map.entrySet()) {
                JAXBRegionPricingLabelCountItem entry = new JAXBRegionPricingLabelCountItem();
                entry.key = mapEntry.getKey();
                entry.value = mapEntry.getValue();
                adaptedMap.entry.add(entry);
            }
            return adaptedMap;
        }

    }