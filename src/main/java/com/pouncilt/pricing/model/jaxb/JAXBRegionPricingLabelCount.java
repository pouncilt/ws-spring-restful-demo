package com.pouncilt.pricing.model.jaxb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pouncilt.pricing.commons.LabelCountTree;
import com.pouncilt.pricing.model.jaxb.adapters.JAXBDistrictPricingLabelCountMapAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/5/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties({"count", "children", "locationType"})
@XmlType(propOrder = {"locationNumber", "districtPricingLabelCountMap"})
public class JAXBRegionPricingLabelCount implements LabelCountTree {
    private Integer locationNumber = 0;
    private Map<String, JAXBDistrictPricingLabelCount> districtPricingLabelCountMap = new Hashtable<String, JAXBDistrictPricingLabelCount>();


    public JAXBRegionPricingLabelCount() {

    }

    public JAXBRegionPricingLabelCount(Integer locationNumber, Map<String, JAXBDistrictPricingLabelCount> districtPricingLabelCountMap) {
        this.locationNumber = locationNumber;
        this.districtPricingLabelCountMap = districtPricingLabelCountMap;
    }

    @XmlJavaTypeAdapter(JAXBDistrictPricingLabelCountMapAdapter.class)
    @XmlElement(namespace = "http://www.pouncilt.com/pricing/pricinglabels/model", name = "districtPricingLabelCounts")
    public Map<String, JAXBDistrictPricingLabelCount> getDistrictPricingLabelCountMap() {
        return districtPricingLabelCountMap;
    }

    public void setDistrictPricingLabelCountMap(Map<String, JAXBDistrictPricingLabelCount> districtPricingLabelMap) {
        this.districtPricingLabelCountMap = districtPricingLabelMap;
    }

    @Override
    public Integer getCount() {
        Integer count = 0;
        for (LabelCountTree labelCountTree : districtPricingLabelCountMap.values()) {
            count += labelCountTree.getCount();
        }
        return count;
    }

    @Override
    public String getLocationType() {
        return "Regional";
    }

    public void setLocationNumber(Integer locationNumber) {
        this.locationNumber = locationNumber;
    }

    @Override
    @XmlElement(namespace = "http://www.pouncilt.com/pricing/pricinglabels/model")
    public Integer getLocationNumber() {
        return this.locationNumber;
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>(districtPricingLabelCountMap.values());
    }
}
