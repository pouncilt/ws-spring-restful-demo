package com.pouncilt.pricing.service;

import com.pouncilt.pricing.model.jaxb.JAXBCorporatePricingLabelCount;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/7/13
 * Time: 7:52 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PricingLabelCountService {
    public JAXBCorporatePricingLabelCount getTodaysPricingLabelCounts();
}
