package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Orders;

import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    @Override
    public int saveOrders(Orders orders) throws Exception {
        return 0;
    }

    @Override
    public Orders getOrdersById(Integer orderId) throws Exception {
        return null;
    }

    @Override
    public List<Orders> listOrdersById(String userId) throws Exception {
        return null;
    }
}
