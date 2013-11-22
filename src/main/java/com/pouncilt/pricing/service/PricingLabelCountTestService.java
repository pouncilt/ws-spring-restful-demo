package com.pouncilt.pricing.service;

import com.pouncilt.pricing.model.jaxb.JAXBCorporatePricingLabelCount;
import com.pouncilt.pricing.model.jaxb.adapters.JAXBPricingLabelCountTestFactory;

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
