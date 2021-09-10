package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Business;

import java.util.List;

public interface BusinessDao {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) throws Exception ;
    public Business getBusinessById(Integer businessId) throws Exception;
    public List<Business> listBusinessByName(String businessName) throws Exception;
}
