package com.oreillyauto.pricingmanagement.pricinglabels.model;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/12/13
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlSeeAlso({CorporatePricingLabelCount.class, DivisionPricingLabelCount.class, RegionPricingLabelCount.class, DistrictPricingLabelCount.class, StorePricingLabelCount.class})
public abstract class BasePricingLabelCount {
    private Integer locationNumber = 0;

    public BasePricingLabelCount() {

    }

    public BasePricingLabelCount(Integer locationNumber) {
        this.locationNumber = locationNumber;
    }

    public void setLocationNumber(Integer locationNumber) {
        this.locationNumber = locationNumber;
    }

    public Integer getLocationNumber() {
        return locationNumber;
    }
}
