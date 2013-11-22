package com.oreillyauto.pricingmanagement.commons;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 10/28/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface LabelCountTree {
    public Integer getCount();
    public String getLocationType();
    public Integer getLocationNumber();
    public List<LabelCountTree> getChildren();
}
