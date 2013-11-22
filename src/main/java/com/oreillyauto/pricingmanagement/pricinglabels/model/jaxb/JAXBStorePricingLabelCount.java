package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oreillyauto.pricingmanagement.commons.LabelCountTree;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/5/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties({"count", "children", "locationType"})
@XmlType(propOrder = {"locationNumber", "labelCount"})
public class JAXBStorePricingLabelCount implements LabelCountTree {
    private Integer locationNumber = 0;
    private Integer labelCount = 0;


    public JAXBStorePricingLabelCount() {

    }

    public JAXBStorePricingLabelCount(Integer locationNumber, Integer labelCount) {
        this.locationNumber = locationNumber;
        this.labelCount = labelCount;
    }

    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
    public Integer getLabelCount() {
        return labelCount;
    }

    public void setLabelCount(Integer labelCount) {
        this.labelCount = labelCount;
    }

    @Override
    @XmlElement(namespace = "http://www.oreillyauto.com/pricingmanagement/pricinglabels/model")
    public Integer getLocationNumber() {
        return this.locationNumber;
    }

    public void setLocationNumber(Integer locationNumber) {
        this.locationNumber = locationNumber;
    }

    @Override
    public Integer getCount() {
        return getLabelCount();
    }

    @Override
    public String getLocationType() {
        return "Store";
    }

    @Override
    public List<LabelCountTree> getChildren() {
        return new ArrayList<LabelCountTree>();
    }
}
