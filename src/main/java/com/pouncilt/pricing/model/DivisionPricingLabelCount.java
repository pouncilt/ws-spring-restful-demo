package com.pouncilt.pricing.model;

import com.pouncilt.pricing.commons.LabelCountTree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/3/13
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DivisionPricingLabelCount extends BasePricingLabelCount implements LabelCountTree {
    private Map<String, RegionPricingLabelCount> regionPricingLabelCounts = new Hashtable<String, RegionPricingLabelCount>();

    public DivisionPricingLabelCount() {
        super();
    }

    public DivisionPricingLabelCount(Integer locationNumber, Map<String, RegionPricingLabelCount> regionPricingLabelCounts) {
        super(locationNumber);
        this.regionPricingLabelCounts = regionPricingLabelCounts;
    }

    public Map<String, RegionPricingLabelCount> getRegionPricingLabelCounts() {
        return regionPricingLabelCounts;
    }

    public void setRegionPricingLabelCounts(Map<String, RegionPricingLabelCount> regionPricingLabelCounts) {
        this.regionPricingLabelCounts = regionPricingLabelCounts;
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
        for (LabelCountTree labelCountTree : regionPricingLabelCounts.values()) {
            count += labelCountTree.getCount();
        }
        return count;
    }

    @Override
    public String getLocationType() {
        return "Division";
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>(regionPricingLabelCounts.values());
    }
}
