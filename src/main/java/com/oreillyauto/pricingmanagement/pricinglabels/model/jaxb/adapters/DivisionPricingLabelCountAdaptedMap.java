package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/19/13
 * Time: 5:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class DivisionPricingLabelCountAdaptedMap {
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
    public List<DivisionPricingLabelCountItem> entry = new ArrayList<DivisionPricingLabelCountItem>();
}
