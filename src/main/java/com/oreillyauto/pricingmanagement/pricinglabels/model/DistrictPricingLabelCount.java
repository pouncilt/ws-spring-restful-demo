package com.oreillyauto.pricingmanagement.pricinglabels.model;

import com.oreillyauto.pricingmanagement.commons.LabelCountTree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/3/13
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistrictPricingLabelCount extends BasePricingLabelCount implements LabelCountTree {
    private Map<String, StorePricingLabelCount> storePricingLabelCounts = new Hashtable<String, StorePricingLabelCount>();

    public DistrictPricingLabelCount() {
        super();
    }

    public DistrictPricingLabelCount(Integer locationNumber, Map<String, StorePricingLabelCount> storePricingLabelCountMap) {
        super(locationNumber);
        this.storePricingLabelCounts = storePricingLabelCountMap;
    }

    public Map<String, StorePricingLabelCount> getStorePricingLabelCounts() {
        return storePricingLabelCounts;
    }

    public void setStorePricingLabelCountMap(Map<String, StorePricingLabelCount> storePricingLabelCounts) {
        this.storePricingLabelCounts = storePricingLabelCounts;
    }

    /*@Override
    public void setLocationNumber(Integer locationNumber) {
        super.locationNumber = locationNumber;
    }

    @Override
    public Integer getLocationNumber() {
        return super.locationNumber;
    }*/

    @Override
    public Integer getCount() {
        Integer count = 0;
        for(LabelCountTree labelCountTree: storePricingLabelCounts.values()) {
            count += labelCountTree.getCount();
        }
        return count;
    }

    @Override
    public String getLocationType() {
        return "District";
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>(storePricingLabelCounts.values());
    }
}
