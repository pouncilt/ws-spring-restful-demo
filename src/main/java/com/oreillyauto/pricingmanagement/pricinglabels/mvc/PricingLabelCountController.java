package com.oreillyauto.pricingmanagement.pricinglabels.mvc;

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBCorporatePricingLabelCount;
import com.oreillyauto.pricingmanagement.pricinglabels.service.PricingLabelCountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/7/13
 * Time: 7:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
/*@RequestMapping("/pricing-label-counts")*/
public class PricingLabelCountController {
    private PricingLabelCountService pricingLabelCountService;

    @Inject
    public PricingLabelCountController(PricingLabelCountService pricingLabelCountService) {
        this.pricingLabelCountService = pricingLabelCountService;
    }

    @RequestMapping(value = "/pricingLabelCount", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json"})
    public
    @ResponseBody
    JAXBCorporatePricingLabelCount getPricingLabelCounts() {
        return pricingLabelCountService.getTodaysPricingLabelCounts();
    }

    @RequestMapping(value = "/corporate", method = RequestMethod.GET)
    public ModelAndView getCorporatePricingLabelCount() {
        JAXBCorporatePricingLabelCount pricingLabelCount = pricingLabelCountService.getTodaysPricingLabelCounts();
        return new ModelAndView("pricingLabelCount", "object", pricingLabelCount);
    }
}