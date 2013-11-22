package com.pouncilt.pricing.model;

import com.pouncilt.pricing.commons.LabelCountTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/3/13
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class StorePricingLabelCount extends BasePricingLabelCount implements LabelCountTree {
    private Integer labelCount = 0;

    public StorePricingLabelCount() {
        super();
    }

    public StorePricingLabelCount(Integer locationNumber, Integer labelCount) {
        super(locationNumber);
        this.labelCount = labelCount;
    }

    public Integer getLabelCount() {
        return labelCount;
    }

    public void setLabelCount(Integer labelCount) {
        this.labelCount = labelCount;
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
        return getLabelCount();
    }

    @Override
    public String getLocationType() {
        return "Store";
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>();
    }
}
