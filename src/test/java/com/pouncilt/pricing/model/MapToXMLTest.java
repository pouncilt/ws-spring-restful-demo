package com.pouncilt.pricing.model;

import com.pouncilt.pricing.model.CorporatePricingLabelCount;
import com.pouncilt.pricing.model.jaxb.JAXBCorporatePricingLabelCount;
import com.pouncilt.pricing.model.jaxb.adapters.JAXBPricingLabelCountTestFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/5/13
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/jaxb2-marshaller-context.xml"})
public class MapToXMLTest {
    @Autowired
    @Qualifier("marshaller")
    Jaxb2Marshaller marshaller;

    @Autowired
    @Qualifier("jaxb2Marshaller")
    Jaxb2Marshaller jaxb2Marshaller;

    @Test
    public void testMarshallingMapToXML() throws Exception {
        String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><corporatePricingLabelCount xmlns=\"http://www.pouncilt.com/pricing/pricinglabels/model\"><locationNumber>111</locationNumber><divisionPricingLabelCounts><entry><key>division-location-number-222</key><value><locationNumber>222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-33333</key><value><locationNumber>33333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-44444</key><value><locationNumber>44444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-99991</key><value><locationNumber>99991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-99999</key><value><locationNumber>99999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry><entry><key>region-location-number-333</key><value><locationNumber>333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-444</key><value><locationNumber>444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-991</key><value><locationNumber>991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-999</key><value><locationNumber>999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry><entry><key>division-location-number-2222</key><value><locationNumber>2222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-3333</key><value><locationNumber>3333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-4444</key><value><locationNumber>4444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-9991</key><value><locationNumber>9991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-9999</key><value><locationNumber>9999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry></divisionPricingLabelCounts></corporatePricingLabelCount>";
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(JAXBPricingLabelCountTestFactory.getInstance().createJAXBCorporatePricingLabelCount(), new StreamResult(sw));

        assertEquals(expectedXML, sw.toString());
    }

    @Test
    public void testUnmarshallingXMLToMap() throws Exception{
        String actualXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><corporatePricingLabelCount xmlns=\"http://www.pouncilt.com/pricing/pricinglabels/model\"><locationNumber>111</locationNumber><divisionPricingLabelCounts><entry><key>division-location-number-222</key><value><locationNumber>222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-33333</key><value><locationNumber>33333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-44444</key><value><locationNumber>44444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-99991</key><value><locationNumber>99991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-99999</key><value><locationNumber>99999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry><entry><key>region-location-number-333</key><value><locationNumber>333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-444</key><value><locationNumber>444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-991</key><value><locationNumber>991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-999</key><value><locationNumber>999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry><entry><key>division-location-number-2222</key><value><locationNumber>2222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-3333</key><value><locationNumber>3333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-4444</key><value><locationNumber>4444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-9991</key><value><locationNumber>9991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-9999</key><value><locationNumber>9999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry></divisionPricingLabelCounts></corporatePricingLabelCount>";
        StringReader reader = new StringReader(actualXML);
        JAXBCorporatePricingLabelCount corporatePricingLabelCount = (JAXBCorporatePricingLabelCount) marshaller.unmarshal(new StreamSource(reader));

        assertEquals(111, corporatePricingLabelCount.getLocationNumber().intValue());
        assertEquals(2, corporatePricingLabelCount.getDivisionPricingLabelCountMap().size());
        assertEquals(2, corporatePricingLabelCount.getChildren().size());
        assertEquals(60, corporatePricingLabelCount.getCount().intValue());
    }

    @Test
    public void testMarshallingJaxbIntroductionMappingsToXML() throws Exception {
        String expectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><corporatePricingLabelCount xmlns=\"http://www.pouncilt.com/pricing/pricinglabels/model\"><locationNumber>111</locationNumber><divisionPricingLabelCounts><entry><key>division-location-number-222</key><value><locationNumber>222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-333</key><value><locationNumber>333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-444</key><value><locationNumber>444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-0</key><value><locationNumber>0</locationNumber><labelCount>5</labelCount></value></entry><entry><key>store-location-number-1</key><value><locationNumber>1</locationNumber><labelCount>15</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry></divisionPricingLabelCounts></corporatePricingLabelCount>";
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();
        jaxb2Marshaller.marshal(JAXBPricingLabelCountTestFactory.getInstance().createCorporatePricingLabelCount(), new StreamResult(sw));

        assertEquals(expectedXML, sw.toString());
    }

    @Test
    public void testUnmarshallingXMLToJaxbIntroductionMappings() throws Exception{
        String actualXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><corporatePricingLabelCount xmlns=\"http://www.pouncilt.com/pricing/pricinglabels/model\"><locationNumber>111</locationNumber><divisionPricingLabelCounts><entry><key>division-location-number-222</key><value><locationNumber>222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-33333</key><value><locationNumber>33333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-44444</key><value><locationNumber>44444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-99991</key><value><locationNumber>99991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-99999</key><value><locationNumber>99999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry><entry><key>region-location-number-333</key><value><locationNumber>333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-444</key><value><locationNumber>444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-991</key><value><locationNumber>991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-999</key><value><locationNumber>999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry><entry><key>division-location-number-2222</key><value><locationNumber>2222</locationNumber><regionPricingLabelCounts><entry><key>region-location-number-3333</key><value><locationNumber>3333</locationNumber><districtPricingLabelCounts><entry><key>district-location-number-4444</key><value><locationNumber>4444</locationNumber><storePricingLabelCounts><entry><key>store-location-number-9991</key><value><locationNumber>9991</locationNumber><labelCount>15</labelCount></value></entry><entry><key>store-location-number-9999</key><value><locationNumber>9999</locationNumber><labelCount>5</labelCount></value></entry></storePricingLabelCounts></value></entry></districtPricingLabelCounts></value></entry></regionPricingLabelCounts></value></entry></divisionPricingLabelCounts></corporatePricingLabelCount>";
        StringReader reader = new StringReader(actualXML);
        CorporatePricingLabelCount corporatePricingLabelCount = (CorporatePricingLabelCount) jaxb2Marshaller.unmarshal(new StreamSource(reader));

        assertEquals(111, corporatePricingLabelCount.getLocationNumber().intValue());
        assertEquals(2, corporatePricingLabelCount.getDivisionPricingLabelCounts().size());
        assertEquals(2, corporatePricingLabelCount.getChildren().size());
        assertEquals(60, corporatePricingLabelCount.getCount().intValue());
    }
}
