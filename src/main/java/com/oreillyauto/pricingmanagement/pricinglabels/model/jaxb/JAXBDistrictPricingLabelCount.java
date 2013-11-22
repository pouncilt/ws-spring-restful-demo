package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oreillyauto.pricingmanagement.commons.LabelCountTree;
import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters.JAXBStorePricingLabelCountMapAdapter;

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
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties({"count","children", "locationType"})
@XmlType(propOrder={"locationNumber","storePricingLabelCountMap"})
public class JAXBDistrictPricingLabelCount implements LabelCountTree {
    private Integer locationNumber = 0;
    private Map<String, JAXBStorePricingLabelCount> storePricingLabelCountMap = new Hashtable<String, JAXBStorePricingLabelCount>();


    public JAXBDistrictPricingLabelCount() {

    }

    public JAXBDistrictPricingLabelCount(Integer locationNumber, Map<String, JAXBStorePricingLabelCount> storePricingLabelCountMap) {
        this.locationNumber = locationNumber;
        this.storePricingLabelCountMap = storePricingLabelCountMap;
    }

    @XmlJavaTypeAdapter(JAXBStorePricingLabelCountMapAdapter.class)
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model", name="storePricingLabelCounts")
    public Map<String, JAXBStorePricingLabelCount> getStorePricingLabelCountMap() {
        return storePricingLabelCountMap;
    }

    public void setStorePricingLabelCountMap(Map<String, JAXBStorePricingLabelCount> storePricingLabelCountMap) {
        this.storePricingLabelCountMap = storePricingLabelCountMap;
    }

    @Override
    public Integer getCount() {
        Integer count = 0;
        for(LabelCountTree labelCountTree: storePricingLabelCountMap.values()) {
            count += labelCountTree.getCount();
        }
        return count;
    }

    @Override
    public String getLocationType() {
        return "District";
    }

    public void setLocationNumber(Integer locationNumber) {
        this.locationNumber = locationNumber;
    }

    @Override
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
    public Integer getLocationNumber() {
        return this.locationNumber;
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>(storePricingLabelCountMap.values());
    }
}
