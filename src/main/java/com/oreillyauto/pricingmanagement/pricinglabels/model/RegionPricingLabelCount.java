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
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegionPricingLabelCount extends BasePricingLabelCount implements LabelCountTree {
    private Map<String, DistrictPricingLabelCount> districtPricingLabelCounts = new Hashtable<String, DistrictPricingLabelCount>();

    public RegionPricingLabelCount() {
        super();
    }

    public RegionPricingLabelCount(Integer locationNumber, Map<String, DistrictPricingLabelCount> districtPricingLabelCounts) {
        super(locationNumber);
        this.districtPricingLabelCounts = districtPricingLabelCounts;
    }

    public Map<String, DistrictPricingLabelCount> getDistrictPricingLabelCounts() {
        return districtPricingLabelCounts;
    }

    public void setDistrictPricingLabelCountMap(Map<String, DistrictPricingLabelCount> districtPricingLabelCounts) {
        this.districtPricingLabelCounts = districtPricingLabelCounts;
    }

    @Override
    public Integer getCount() {
        Integer count = 0;
        for (LabelCountTree labelCountTree : districtPricingLabelCounts.values()) {
            count += labelCountTree.getCount();
        }
        return count;
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
    public String getLocationType() {
        return "Regional";
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>(districtPricingLabelCounts.values());
    }
}
