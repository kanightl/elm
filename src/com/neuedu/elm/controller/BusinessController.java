package com.neuedu.elm.controller;

import com.neuedu.elm.entity.Business;
import com.neuedu.elm.service.BusinessService;
import com.neuedu.elm.service.BusinessServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BusinessController {
    private BusinessService service=new BusinessServiceImpl();

    //http://localhost:8890/elm/BusinessController/listBusinessByOrderTypeId?orderTypeId=1
    public Object listBusinessByOrderTypeId(HttpServletRequest req, HttpServletResponse resp) throws  Exception {
        Integer orderTypeId = Integer.valueOf(req.getParameter("orderTypeId")) ;
        List<Business> list=service.listBusinessByOrderTypeId(orderTypeId);
        return list;
    }

    //http://localhost:8890/elm/BusinessController/getBusinessById?businessId=1
    public Object getBusinessById(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Integer businessId=Integer.valueOf(req.getParameter("businessId"));
        Business b=service.getBusinessById(businessId);
        return b;
    }

    //http://localhost:8890/elm/BusinessController/listBusinessByName?businessName=米
    public Object listBusinessByName(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String businessName=req.getParameter("businessName");
        List<Business> list =service.listBusinessByName(businessName);
        return list;
    }
}
