package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;



import com.oreillyauto.pricingmanagement.pricinglabels.model.StorePricingLabelCount;

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
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class StorePricingLabelCountMapAdapter extends XmlAdapter<StorePricingLabelCountMapAdapter.StorePricingLabelCountAdaptedMap, Map<String, StorePricingLabelCount>> {

    public static class StorePricingLabelCountAdaptedMap {

        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public List<StorePricingLabelCountItem> entry = new ArrayList<StorePricingLabelCountItem>();

    }

    public static class StorePricingLabelCountItem {

        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public String key;

        @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
        public StorePricingLabelCount value;

    }

    @Override
    public Map<String, StorePricingLabelCount> unmarshal(StorePricingLabelCountAdaptedMap adaptedMap) throws Exception {
        Map<String, StorePricingLabelCount> map = new HashMap<String, StorePricingLabelCount>();
        for(StorePricingLabelCountItem item : adaptedMap.entry) {
            map.put(item.key, item.value);
        }
        return map;
    }

    @Override
    public StorePricingLabelCountAdaptedMap marshal(Map<String, StorePricingLabelCount> map) throws Exception {
        StorePricingLabelCountAdaptedMap adaptedMap = new StorePricingLabelCountAdaptedMap();
        for(Map.Entry<String, StorePricingLabelCount> mapEntry : map.entrySet()) {
            StorePricingLabelCountItem item = new StorePricingLabelCountItem();
            item.key = mapEntry.getKey();
            item.value = mapEntry.getValue();
            adaptedMap.entry.add(item);
        }
        return adaptedMap;
    }

}