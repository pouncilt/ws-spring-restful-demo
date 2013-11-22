package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBStorePricingLabelCount;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/6/13
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class JAXBStorePricingLabelCountMapAdapter extends XmlAdapter<JAXBStorePricingLabelCountMapAdapter.StorePricingLabelCountAdaptedMap, Map<String, JAXBStorePricingLabelCount>> {

    public static class StorePricingLabelCountAdaptedMap {

        public List<StorePricingLabelCountItem> entry = new ArrayList<StorePricingLabelCountItem>();

    }

    public static class StorePricingLabelCountItem {

        public String key;

        public JAXBStorePricingLabelCount value;

    }

    @Override
    public Map<String, JAXBStorePricingLabelCount> unmarshal(StorePricingLabelCountAdaptedMap adaptedMap) throws Exception {
        Map<String, JAXBStorePricingLabelCount> map = new HashMap<String, JAXBStorePricingLabelCount>();
        for (StorePricingLabelCountItem item : adaptedMap.entry) {
            map.put(item.key, item.value);
        }
        return map;
    }

    @Override
    public StorePricingLabelCountAdaptedMap marshal(Map<String, JAXBStorePricingLabelCount> map) throws Exception {
        StorePricingLabelCountAdaptedMap adaptedMap = new StorePricingLabelCountAdaptedMap();
        for (Map.Entry<String, JAXBStorePricingLabelCount> mapEntry : map.entrySet()) {
            StorePricingLabelCountItem item = new StorePricingLabelCountItem();
            item.key = mapEntry.getKey();
            item.value = mapEntry.getValue();
            adaptedMap.entry.add(item);
        }
        return adaptedMap;
    }

}
