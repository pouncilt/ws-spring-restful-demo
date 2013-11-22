package com.oreillyauto.pricingmanagement.pricinglabels.service;

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBCorporatePricingLabelCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/8/13
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class PricingLabelCountRestfulClient {
    @Autowired(required=true)
    private RestTemplate restTemplate;

    public JAXBCorporatePricingLabelCount retrievePricingLabelCountsXMLRequest() {
        return getRestTemplate().getForObject("http://localhost:8080/ws-spring-restful-demo/service/pricingLabelCount",
                JAXBCorporatePricingLabelCount.class/*, urlVariables*/);
    }

    public JAXBCorporatePricingLabelCount retrievePricingLabelCountsJSONRequest() {
        MultiValueMap<String, String> requestHeaders = new LinkedMultiValueMap<String, String>();
        requestHeaders.set("Accept", "application/json");
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        HttpEntity<JAXBCorporatePricingLabelCount> response = getRestTemplate().exchange("http://localhost:8080/ws-spring-restful-demo/service/pricingLabelCount",
                HttpMethod.GET, requestEntity, JAXBCorporatePricingLabelCount.class);

        String responseHeader = response.getHeaders().getFirst("Accept");
        JAXBCorporatePricingLabelCount body = response.getBody();

        return body;
    }

    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
