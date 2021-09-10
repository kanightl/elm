package com.neuedu.elm.service;

import com.neuedu.elm.entity.Orders;

import java.util.List;

public interface OrdersService {
    public int saveOrders(Orders o) ;
    public Orders getOrdersById(Integer orderId) ;
    public List<Orders> listOrdersById(String userId) ;
}
