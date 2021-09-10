package com.neuedu.elm.controller;

import com.neuedu.elm.entity.Orders;
import com.neuedu.elm.service.OrdersService;
import com.neuedu.elm.service.OrdersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrdersController {

    private OrdersService service = new OrdersServiceImpl();

   // http://localhost:8890/elm/OrdersController/createOrders?userId=tom01&businessId=1&daId=1
    public Object createOrders(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String userId = req.getParameter("userId");
        Integer businessId = Integer.valueOf(req.getParameter("businessId"));
        Integer daId = Integer.valueOf(req.getParameter("daId"));

        int orderId = service.createOrders(userId, businessId, daId);
        return orderId;
    }

    // http://localhost:8890/elm/OrdersController/getOrdersById?orderId=5
    public Object getOrdersById(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        OrdersService service = new OrdersServiceImpl();
        Orders orders = service.getOrdersById(orderId);
        return orders;
    }

    // http://localhost:8890/elm/OrdersController/listOrdersByUserId?userId=tom01
    public Object listOrdersByUserId(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        String userId = req.getParameter("userId");
        OrdersService service = new OrdersServiceImpl();
        List<Orders> list = service.listOrdersByUserId(userId);
        return list;
    }
}
