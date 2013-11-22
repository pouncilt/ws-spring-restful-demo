package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import com.oreillyauto.pricingmanagement.pricinglabels.model.DivisionPricingLabelCount;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/19/13
 * Time: 5:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class DivisionPricingLabelCountItem {
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
    public String key;
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
    public DivisionPricingLabelCount value;
}
