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
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class CorporatePricingLabelCount extends BasePricingLabelCount implements LabelCountTree{
    private Map<String, DivisionPricingLabelCount> divisionPricingLabelCounts = new Hashtable<String, DivisionPricingLabelCount>();


    public CorporatePricingLabelCount() {
        super();
    }

    public CorporatePricingLabelCount(Integer locationNumber, Map<String, DivisionPricingLabelCount> divisionPricingLabelCounts) {
        super(locationNumber);
        this.divisionPricingLabelCounts = divisionPricingLabelCounts;
    }

    public Map<String, DivisionPricingLabelCount> getDivisionPricingLabelCounts() {
        return divisionPricingLabelCounts;
    }

    public void setDivisionPricingLabelCounts(Map<String, DivisionPricingLabelCount> divisionPricingLabelCounts) {
        this.divisionPricingLabelCounts = divisionPricingLabelCounts;
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
        for(LabelCountTree labelCountTree: divisionPricingLabelCounts.values()) {
            count += labelCountTree.getCount();
        }
        return count;
    }

    @Override
    public String getLocationType() {
        return "Corporate";
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>(divisionPricingLabelCounts.values());
    }
}
