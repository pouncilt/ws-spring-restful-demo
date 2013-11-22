package com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.adapters;

import com.oreillyauto.pricingmanagement.pricinglabels.model.*;
import com.oreillyauto.pricingmanagement.pricinglabels.model.jaxb.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pouncilt
 * Date: 11/7/13
 * Time: 8:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class JAXBPricingLabelCountTestFactory {
    private volatile static JAXBPricingLabelCountTestFactory instance;

    private JAXBPricingLabelCountTestFactory() {

    }

    public static JAXBPricingLabelCountTestFactory getInstance() {
        if (instance == null) {
            synchronized (JAXBPricingLabelCountTestFactory.class) {
                if (instance == null) {
                    instance = new JAXBPricingLabelCountTestFactory();
                }
            }
        }

        return instance;
    }

    public JAXBCorporatePricingLabelCount createJAXBCorporatePricingLabelCount() {
        JAXBDistrictPricingLabelCount districtPricingLabelCount1 = new JAXBDistrictPricingLabelCount(444, createJAXBStorePricingLabelCountMap1());
        JAXBDistrictPricingLabelCount districtPricingLabelCount2 = new JAXBDistrictPricingLabelCount(4444, createJAXBStorePricingLabelCountMap2());
        JAXBDistrictPricingLabelCount districtPricingLabelCount3 = new JAXBDistrictPricingLabelCount(44444, createJAXBStorePricingLabelCountMap3());
        JAXBRegionPricingLabelCount regionPricingLabelCount1 = new JAXBRegionPricingLabelCount(333, createJAXBDistrictPricingLabelCountMap(districtPricingLabelCount1));
        JAXBRegionPricingLabelCount regionPricingLabelCount2 = new JAXBRegionPricingLabelCount(3333, createJAXBDistrictPricingLabelCountMap(districtPricingLabelCount2));
        JAXBRegionPricingLabelCount regionPricingLabelCount3 = new JAXBRegionPricingLabelCount(33333, createJAXBDistrictPricingLabelCountMap(districtPricingLabelCount3));
        List<JAXBRegionPricingLabelCount> regionPricingLabelCountList1 = new ArrayList<JAXBRegionPricingLabelCount>();
        regionPricingLabelCountList1.add(regionPricingLabelCount1);
        regionPricingLabelCountList1.add(regionPricingLabelCount3);

        List<JAXBRegionPricingLabelCount> regionPricingLabelCountList2 = new ArrayList<JAXBRegionPricingLabelCount>();
        regionPricingLabelCountList2.add(regionPricingLabelCount2);


        JAXBDivisionPricingLabelCount divisionPricingLabelCount1 = new JAXBDivisionPricingLabelCount(222, createJAXBRegionPricingLabelCountMap(regionPricingLabelCountList1));
        JAXBDivisionPricingLabelCount divisionPricingLabelCount2 = new JAXBDivisionPricingLabelCount(2222, createJAXBRegionPricingLabelCountMap(regionPricingLabelCountList2));
        List<JAXBDivisionPricingLabelCount> divisionPricingLabelCountList = new ArrayList<JAXBDivisionPricingLabelCount>();
        divisionPricingLabelCountList.add(divisionPricingLabelCount1);
        divisionPricingLabelCountList.add(divisionPricingLabelCount2);
        JAXBCorporatePricingLabelCount corporatePricingLabelCount = new JAXBCorporatePricingLabelCount(111, createJAXBDivisionPricingLabelCountMap(divisionPricingLabelCountList));
        return corporatePricingLabelCount;
    }

    public void populateModel(JAXBCorporatePricingLabelCount model, JAXBCorporatePricingLabelCount pricingLabelCount) {
        model.setLocationNumber(pricingLabelCount.getLocationNumber());
        model.setDivisionPricingLabelCountMap(pricingLabelCount.getDivisionPricingLabelCountMap());
    }

    private Map<String, JAXBDistrictPricingLabelCount> createJAXBDistrictPricingLabelCountMap(JAXBDistrictPricingLabelCount districtPricingLabelCount) {
        Map<String, JAXBDistrictPricingLabelCount> districtPricingLabelCountMap = new HashMap<String, JAXBDistrictPricingLabelCount>();
        districtPricingLabelCountMap.put("district-location-number-" + districtPricingLabelCount.getLocationNumber().toString(), districtPricingLabelCount);
        return districtPricingLabelCountMap;
    }

    private Map<String, JAXBDivisionPricingLabelCount> createJAXBDivisionPricingLabelCountMap(JAXBDivisionPricingLabelCount divisionPricingLabelCount) {
        Map<String, JAXBDivisionPricingLabelCount> divisionPricingLabelCountMap = new HashMap<String, JAXBDivisionPricingLabelCount>();
        divisionPricingLabelCountMap.put("division-location-number-" + divisionPricingLabelCount.getLocationNumber(), divisionPricingLabelCount);
        divisionPricingLabelCountMap.put("division-location-number-" + divisionPricingLabelCount.getLocationNumber(), divisionPricingLabelCount);
        return divisionPricingLabelCountMap;
    }

    private Map<String, JAXBDivisionPricingLabelCount> createJAXBDivisionPricingLabelCountMap(List<JAXBDivisionPricingLabelCount> divisionPricingLabelCountList) {
        Map<String, JAXBDivisionPricingLabelCount> divisionPricingLabelCountMap = new HashMap<String, JAXBDivisionPricingLabelCount>();

        for (JAXBDivisionPricingLabelCount divisionPricingLabelCount : divisionPricingLabelCountList) {
            divisionPricingLabelCountMap.put("division-location-number-" + divisionPricingLabelCount.getLocationNumber(), divisionPricingLabelCount);
        }

        return divisionPricingLabelCountMap;
    }

    private Map<String, JAXBRegionPricingLabelCount> createJAXBRegionPricingLabelCountMap(JAXBRegionPricingLabelCount regionPricingLabelCount) {
        Map<String, JAXBRegionPricingLabelCount> regionPricingLabelCountMap = new HashMap<String, JAXBRegionPricingLabelCount>();
        regionPricingLabelCountMap.put("region-location-number-" + regionPricingLabelCount.getLocationNumber(), regionPricingLabelCount);
        return regionPricingLabelCountMap;
    }

    private Map<String, JAXBRegionPricingLabelCount> createJAXBRegionPricingLabelCountMap(List<JAXBRegionPricingLabelCount> regionPricingLabelCountlist) {
        Map<String, JAXBRegionPricingLabelCount> regionPricingLabelCountMap = new HashMap<String, JAXBRegionPricingLabelCount>();

        for (JAXBRegionPricingLabelCount regionPricingLabelCount : regionPricingLabelCountlist) {
            regionPricingLabelCountMap.put("region-location-number-" + regionPricingLabelCount.getLocationNumber(), regionPricingLabelCount);
        }
        return regionPricingLabelCountMap;
    }

    private Map<String, JAXBStorePricingLabelCount> createJAXBStorePricingLabelCountMap1() {
        JAXBStorePricingLabelCount storeLabelCount1 = createJAXBStoreLabel(999, 5);
        JAXBStorePricingLabelCount storeLabelCount2 = createJAXBStoreLabel(991, 15);
        Map<String, JAXBStorePricingLabelCount> storeLabelCountMap = new HashMap<String, JAXBStorePricingLabelCount>();
        storeLabelCountMap.put("store-location-number-" + storeLabelCount1.getLocationNumber().toString(), storeLabelCount1);
        storeLabelCountMap.put("store-location-number-" + storeLabelCount2.getLocationNumber().toString(), storeLabelCount2);
        return storeLabelCountMap;
    }

    private Map<String, JAXBStorePricingLabelCount> createJAXBStorePricingLabelCountMap2() {
        JAXBStorePricingLabelCount storeLabelCount1 = createJAXBStoreLabel(9999, 5);
        JAXBStorePricingLabelCount storeLabelCount2 = createJAXBStoreLabel(9991, 15);
        Map<String, JAXBStorePricingLabelCount> storeLabelCountMap = new HashMap<String, JAXBStorePricingLabelCount>();
        storeLabelCountMap.put("store-location-number-" + storeLabelCount1.getLocationNumber().toString(), storeLabelCount1);
        storeLabelCountMap.put("store-location-number-" + storeLabelCount2.getLocationNumber().toString(), storeLabelCount2);
        return storeLabelCountMap;
    }

    private Map<String, JAXBStorePricingLabelCount> createJAXBStorePricingLabelCountMap3() {
        JAXBStorePricingLabelCount storeLabelCount1 = createJAXBStoreLabel(99999, 5);
        JAXBStorePricingLabelCount storeLabelCount2 = createJAXBStoreLabel(99991, 15);
        Map<String, JAXBStorePricingLabelCount> storeLabelCountMap = new HashMap<String, JAXBStorePricingLabelCount>();
        storeLabelCountMap.put("store-location-number-" + storeLabelCount1.getLocationNumber().toString(), storeLabelCount1);
        storeLabelCountMap.put("store-location-number-" + storeLabelCount2.getLocationNumber().toString(), storeLabelCount2);
        return storeLabelCountMap;
    }

    private JAXBStorePricingLabelCount createJAXBStoreLabel(int locationNumber, int labelCount) {
        return new JAXBStorePricingLabelCount(locationNumber, labelCount);
    }

    public CorporatePricingLabelCount createCorporatePricingLabelCount() {
        DistrictPricingLabelCount districtPricingLabelCount = new DistrictPricingLabelCount(444, createStorePricingLabelCount());
        RegionPricingLabelCount regionPricingLabelCount = new RegionPricingLabelCount(333, createDistrictPricingLabelCount(districtPricingLabelCount));
        DivisionPricingLabelCount divisionPricingLabelCount = new DivisionPricingLabelCount(222, createRegionPricingLabelCount(regionPricingLabelCount));
        CorporatePricingLabelCount corporatePricingLabelCount = new CorporatePricingLabelCount(111, createDivisionPricingLabelCount(divisionPricingLabelCount));
        return corporatePricingLabelCount;
    }

    private Map<String, StorePricingLabelCount> createStorePricingLabelCount() {
        StorePricingLabelCount storeLabelCount1 = createStoreLabel(000, 5);
        StorePricingLabelCount storeLabelCount2 = createStoreLabel(001, 15);
        Map<String, StorePricingLabelCount> storeLabelCountMap = new HashMap<String, StorePricingLabelCount>();
        storeLabelCountMap.put("store-location-number-" + storeLabelCount1.getLocationNumber().toString(), storeLabelCount1);
        storeLabelCountMap.put("store-location-number-" + storeLabelCount2.getLocationNumber().toString(), storeLabelCount2);
        return storeLabelCountMap;
    }

    private StorePricingLabelCount createStoreLabel(int locationNumber, int labelCount) {
        return new StorePricingLabelCount(locationNumber, labelCount);
    }

    private Map<String, DivisionPricingLabelCount> createDivisionPricingLabelCount(DivisionPricingLabelCount divisionPricingLabelCount) {
        Map<String, DivisionPricingLabelCount> divisionPricingLabelCountMap = new HashMap<String, DivisionPricingLabelCount>();
        divisionPricingLabelCountMap.put("division-location-number-" + divisionPricingLabelCount.getLocationNumber(), divisionPricingLabelCount);
        return divisionPricingLabelCountMap;
    }

    private Map<String, RegionPricingLabelCount> createRegionPricingLabelCount(RegionPricingLabelCount regionPricingLabelCount) {
        Map<String, RegionPricingLabelCount> regionPricingLabelCountMap = new HashMap<String, RegionPricingLabelCount>();
        regionPricingLabelCountMap.put("region-location-number-" + regionPricingLabelCount.getLocationNumber(), regionPricingLabelCount);
        return regionPricingLabelCountMap;
    }

    private Map<String, DistrictPricingLabelCount> createDistrictPricingLabelCount(DistrictPricingLabelCount districtPricingLabelCount) {
        Map<String, DistrictPricingLabelCount> districtPricingLabelCountMap = new HashMap<String, DistrictPricingLabelCount>();
        districtPricingLabelCountMap.put("district-location-number-" + districtPricingLabelCount.getLocationNumber().toString(), districtPricingLabelCount);
        return districtPricingLabelCountMap;
    }
}
