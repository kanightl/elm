package com.neuedu.elm.service;

import com.neuedu.elm.entity.Orders;

import java.util.List;

public interface OrdersService {
    public int createOrders(String userId,Integer businessId,Integer daId);
    public Orders getOrdersById(Integer orderId);
    public List<Orders> listOrdersByUserId(String userId);
}
