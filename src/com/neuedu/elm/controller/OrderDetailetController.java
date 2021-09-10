package com.neuedu.elm.controller;

import com.neuedu.elm.entity.OrderDetailet;
import com.neuedu.elm.service.OrderDetailetService;
import com.neuedu.elm.service.OrderDetailetServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderDetailetController {
    private OrderDetailetService service = new OrderDetailetServiceImpl();

    public Object listOrderDetailetByOrderId(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        List<OrderDetailet> list = service.listOrderDetailetByOrderId(orderId);
        return list;
    }

}
