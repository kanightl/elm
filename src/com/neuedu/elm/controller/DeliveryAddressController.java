package com.neuedu.elm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.elm.entity.DeliveryAddress;
import com.neuedu.elm.service.DeliveryAddressService;
import com.neuedu.elm.service.DeliveryAddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressController {
    private DeliveryAddressService service=new DeliveryAddressServiceImpl();

    //http://localhost:8890/elm/DeliveryAddressController/listDeliveryAddressByUserId?userId=tom01
    public Object listDeliveryAddressByUserId(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        String userId=req.getParameter("userId");
        List<DeliveryAddress> list=service.listDeliveryAddressByUserId(userId);
        return list;
    }

    //http://localhost:8890/elm/DeliveryAddressController/saveDeliveryAddress?contactName=张三&contactSex=1&contactTel=123456789&address=大连&userId=tom01
    public Object saveDeliveryAddress(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        DeliveryAddress d = new DeliveryAddress();
        d.setContactName(req.getParameter("contactName"));
        d.setContactSex(Integer.valueOf(req.getParameter("contactSex")));
        d.setContactTel(req.getParameter("contactTel"));
        d.setAddress(req.getParameter("address"));
        d.setUserId(req.getParameter("userId"));
        int i=service.saveDeliveryAddress(d);
        return i;
    }
    // http://localhost:8890/elm/DeliveryAddressController/removeDeliveryAddress?daId=1
    public Object removeDeliveryAddress(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        String daId = req.getParameter("daId");
        int i=service.removeDeliveryAddress( Integer.valueOf(daId));
        return i;
    }
    // http://localhost:8890/elm/DeliveryAddressController/getDeliveryAddressById?daId=1
    public Object getDeliveryAddressById(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        String daId = req.getParameter("daId");
        DeliveryAddress d=service.getDeliveryAddressById( Integer.valueOf(daId));
        return d;
    }

    //http://localhost:8890/elm/DeliveryAddressController/updateDeliveryAddress?daId=1&contactName=张三&contactSex=1&contactTel=123456789&address=大连东软&userId=tom01
    public Object updateDeliveryAddress(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        DeliveryAddress d = new DeliveryAddress();
        d.setDaId(Integer.valueOf(req.getParameter("daId")));
        d.setContactName(req.getParameter("contactName"));
        d.setContactSex(Integer.valueOf(req.getParameter("contactSex")));
        d.setContactTel(req.getParameter("contactTel"));
        d.setAddress(req.getParameter("address"));
        d.setUserId(req.getParameter("userId"));
        int i = service.updateDeliveryAddress(d);
        return i;
    }

}
