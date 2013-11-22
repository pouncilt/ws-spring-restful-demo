package com.oreillyauto.pricingmanagement.pricinglabels.web.client;

import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters.JAXBPricingLabelCountTestFactory;
import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.JAXBCorporatePricingLabelCount;
import com.oreillyauto.pricingmanagement.pricinglabels.service.PricingLabelCountRestfulClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/8/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-context.xml"})
public class IntegrationRestfulClientTest {
    @Autowired(required=true)
    PricingLabelCountRestfulClient restfulClient;


    public PricingLabelCountRestfulClient getPricingLabelCountRestfulClient() {
        return this.restfulClient;
    }

    public void setPricingLabelCountRestfulClient(PricingLabelCountRestfulClient restfulClient) {
        this.restfulClient = restfulClient;
    }

    @Test
    public void testRestfulClientRequestingXMLPayload() {
        JAXBCorporatePricingLabelCount pricingLabelCount = getPricingLabelCountRestfulClient().retrievePricingLabelCountsXMLRequest();
        assertPricingLabelCount(pricingLabelCount);
    }

    @Test
    public void testRestfulClientRequestingJSONPayload() {
        JAXBCorporatePricingLabelCount pricingLabelCount = getPricingLabelCountRestfulClient().retrievePricingLabelCountsJSONRequest();
        assertPricingLabelCount(pricingLabelCount);
    }

    private void assertPricingLabelCount(JAXBCorporatePricingLabelCount pricingLabelCount) {
        String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><corporatePricingLabelCount xmlns=\"http://www.oreillyauto.com/pricingmanagement/pricinglabels/model\"><locationNumber>111</locationNumber><divisionPricingLabelCounts><entry><key>division-location-number-222</key><value><locationNumber>222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-33333</key><value><locationNumber>33333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-44444</key><value><locationNumber>44444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-99991</key><value><locationNumber>99991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-99999</key><value><locationNumber>99999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry><entry><key>region-location-number-333</key><value><locationNumber>333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-444</key><value><locationNumber>444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-991</key><value><locationNumber>991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-999</key><value><locationNumber>999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry><entry><key>division-location-number-2222</key><value><locationNumber>2222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-3333</key><value><locationNumber>3333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-4444</key><value><locationNumber>4444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-9991</key><value><locationNumber>9991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-9999</key><value><locationNumber>9999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry></divisionPricingLabelCounts></corporatePricingLabelCount>";
        try {
            JAXBContext jc = JAXBContext.newInstance(JAXBCorporatePricingLabelCount.class);

            Marshaller marshaller = jc.createMarshaller();
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            marshaller.marshal(JAXBPricingLabelCountTestFactory.getInstance().createJAXBCorporatePricingLabelCount(), sw);

            assertEquals(expectedXML, sw.toString());
        } catch (JAXBException jaxbe) {
            fail(jaxbe.getMessage());
        }
    }

}
