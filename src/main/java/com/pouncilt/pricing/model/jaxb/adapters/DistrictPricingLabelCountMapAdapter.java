package com.pouncilt.pricing.model.jaxb.adapters;

import com.pouncilt.pricing.model.DistrictPricingLabelCount;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/18/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistrictPricingLabelCountMapAdapter extends XmlAdapter<DistrictPricingLabelCountMapAdapter.DistrictPricingLabelCountAdaptedMap, Map<String, DistrictPricingLabelCount>> {

    public static class DistrictPricingLabelCountAdaptedMap {
        //@XmlElement(namespace = "http://www.pouncilt.com/pricing/pricinglabels/model")
        public List<DistrictPricingLabelCountItem> entry = new ArrayList<DistrictPricingLabelCountItem>();

    }

    public static class DistrictPricingLabelCountItem {
        //@XmlElement(namespace = "http://www.pouncilt.com/pricing/pricinglabels/model")
        public String key;
        //@XmlElement(namespace = "http://www.pouncilt.com/pricing/pricinglabels/model")
        public DistrictPricingLabelCount value;

    }

    @Override
    public Map<String, DistrictPricingLabelCount> unmarshal(DistrictPricingLabelCountAdaptedMap adaptedMap) throws Exception {
        Map<String, DistrictPricingLabelCount> map = new HashMap<String, DistrictPricingLabelCount>();
        for (DistrictPricingLabelCountItem entry : adaptedMap.entry) {
            map.put(entry.key, entry.value);
        }
        return map;
    }

    @Override
    public DistrictPricingLabelCountAdaptedMap marshal(Map<String, DistrictPricingLabelCount> map) throws Exception {
        DistrictPricingLabelCountAdaptedMap adaptedMap = new DistrictPricingLabelCountAdaptedMap();
        for (Map.Entry<String, DistrictPricingLabelCount> mapEntry : map.entrySet()) {
            DistrictPricingLabelCountItem entry = new DistrictPricingLabelCountItem();
            entry.key = mapEntry.getKey();
            entry.value = mapEntry.getValue();
            adaptedMap.entry.add(entry);
        }
        return adaptedMap;
    }

}
