package com.neuedu.elm.service;

import com.neuedu.elm.dao.BusinessDao;
import com.neuedu.elm.dao.BusinessDaoImpl;
import com.neuedu.elm.entity.Business;
import com.neuedu.elm.util.DBUtil;
import sun.security.pkcs11.Secmod;

import java.util.ArrayList;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private BusinessDao dao=new BusinessDaoImpl();

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        List<Business> list=new ArrayList<>();
        try {
            DBUtil.getConnection();
            list=dao.listBusinessByOrderTypeId(orderTypeId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        Business b=null;
        try {
            b=dao.getBusinessById(businessId);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return b;
    }

    @Override
    public List<Business> listBusinessByName(String businessName) {
        List<Business> list=new ArrayList<>();
        try {
            DBUtil.getConnection();
            list=dao.listBusinessByName(businessName);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
}
