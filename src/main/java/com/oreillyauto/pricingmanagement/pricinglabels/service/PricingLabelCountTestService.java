package com.oreillyauto.pricingmanagement.pricinglabels.service;

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBCorporatePricingLabelCount;
import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters.JAXBPricingLabelCountTestFactory;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/7/13
 * Time: 8:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class PricingLabelCountTestService implements PricingLabelCountService {
    @Override
    public JAXBCorporatePricingLabelCount getTodaysPricingLabelCounts() {
        return JAXBPricingLabelCountTestFactory.getInstance().createJAXBCorporatePricingLabelCount();
    }
}
