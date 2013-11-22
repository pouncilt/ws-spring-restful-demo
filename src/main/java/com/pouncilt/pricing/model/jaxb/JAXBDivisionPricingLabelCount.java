package com.pouncilt.pricing.model.jaxb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pouncilt.pricing.commons.LabelCountTree;
import com.pouncilt.pricing.model.jaxb.adapters.JAXBRegionPricingLabelCountMapAdapter;

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
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties({"count", "children", "locationType"})
@XmlType(propOrder = {"locationNumber", "regionPricingLabelCountMap"})
public class JAXBDivisionPricingLabelCount implements LabelCountTree {
    private Integer locationNumber = 0;
    private Map<String, JAXBRegionPricingLabelCount> regionPricingLabelCountMap = new Hashtable<String, JAXBRegionPricingLabelCount>();


    public JAXBDivisionPricingLabelCount() {
    }

    public JAXBDivisionPricingLabelCount(Integer locationNumber, Map<String, JAXBRegionPricingLabelCount> regionPricingLabelCountMap) {
        this.locationNumber = locationNumber;
        this.regionPricingLabelCountMap = regionPricingLabelCountMap;
    }

    @XmlJavaTypeAdapter(JAXBRegionPricingLabelCountMapAdapter.class)
    @XmlElement(namespace = "http://www.pouncilt.com/pricing/pricinglabels/model", name = "regionPricingLabelCounts")
    public Map<String, JAXBRegionPricingLabelCount> getRegionPricingLabelCountMap() {
        return regionPricingLabelCountMap;
    }

    public void setRegionPricingLabelCountMap(Map<String, JAXBRegionPricingLabelCount> regionPricingLabelCountMap) {
        this.regionPricingLabelCountMap = regionPricingLabelCountMap;
    }

    @Override
    public Integer getCount() {
        Integer count = 0;
        for (LabelCountTree labelCountTree : regionPricingLabelCountMap.values()) {
            count += labelCountTree.getCount();
        }
        return count;
    }

    @Override
    public String getLocationType() {
        return "Division";
    }

    @Override
    @XmlElement(namespace = "http://www.pouncilt.com/pricing/pricinglabels/model")
    public Integer getLocationNumber() {
        return this.locationNumber;
    }

    public void setLocationNumber(Integer locationNumber) {
        this.locationNumber = locationNumber;
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>(regionPricingLabelCountMap.values());
    }
}
