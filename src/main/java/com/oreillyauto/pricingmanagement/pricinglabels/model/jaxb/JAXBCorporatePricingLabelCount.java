package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oreillyauto.pricingmanagement.commons.LabelCountTree;
import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters.JAXBDivisionPricingLabelCountMapAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/5/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties({"count","children", "locationType"})
@XmlRootElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model", name = "corporatePricingLabelCount")
@XmlType (propOrder={"locationNumber","divisionPricingLabelCountMap"})
public class JAXBCorporatePricingLabelCount implements LabelCountTree {
    private Integer locationNumber = 0;
    private Map<String, JAXBDivisionPricingLabelCount> divisionPricingLabelCountMap = new Hashtable<String, JAXBDivisionPricingLabelCount>();


    public JAXBCorporatePricingLabelCount() {}

    public JAXBCorporatePricingLabelCount(Integer locationNumber, Map<String, JAXBDivisionPricingLabelCount> divisionPricingLabelCountMap) {
        this.locationNumber = locationNumber;
        this.divisionPricingLabelCountMap = divisionPricingLabelCountMap;
    }

    public void setLocationNumber(Integer locationNumber) {
        this.locationNumber = locationNumber;
    }

    @Override
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
    public Integer getLocationNumber() {
        return this.locationNumber;
    }

    @XmlJavaTypeAdapter(JAXBDivisionPricingLabelCountMapAdapter.class)
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model", name="divisionPricingLabelCounts")
    public Map<String, JAXBDivisionPricingLabelCount> getDivisionPricingLabelCountMap() {
        return divisionPricingLabelCountMap;
    }

    public void setDivisionPricingLabelCountMap(Map<String, JAXBDivisionPricingLabelCount> divisionPricingLabelCountMap) {
        this.divisionPricingLabelCountMap = divisionPricingLabelCountMap;
    }

    @Override
    public Integer getCount() {
        Integer count = 0;
        for(LabelCountTree labelCountTree: divisionPricingLabelCountMap.values()) {
            count += labelCountTree.getCount();
        }
        return count;
    }

    @Override
    public String getLocationType() {
        return "Corporate";
    }

    @Override
    public List<LabelCountTree> getChildren() {
        System.out.println("About to get children.  division.size:" + divisionPricingLabelCountMap.values().size());
        return new ArrayList<LabelCountTree>(divisionPricingLabelCountMap.values());
    }
}
