package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Orders;

import java.util.List;

public interface OrdersDao {
    public int saveOrders(Orders o) throws Exception;
    public Orders getOrdersById(Integer orderId) throws Exception;
    public List<Orders> listOrdersById(String userId) throws Exception;
}

