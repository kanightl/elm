package com.neuedu.elm.service;

import com.neuedu.elm.dao.OrdersDao;
import com.neuedu.elm.dao.OrdersDaoImpl;
import com.neuedu.elm.entity.Orders;
import com.neuedu.elm.util.DBUtil;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    private OrdersDao dao=new OrdersDaoImpl();

    @Override
    public int saveOrders(Orders o) {
        return 0;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {

        Orders o = null;
        try {
            DBUtil.getConnection();
            o = dao.getOrdersById(orderId);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return o;
    }

    @Override
    public List<Orders> listOrdersById(String userId) {

        return null;
    }
}
