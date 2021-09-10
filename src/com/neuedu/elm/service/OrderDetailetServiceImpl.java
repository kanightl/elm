package com.neuedu.elm.service;

import com.neuedu.elm.dao.OrderDetailetDao;
import com.neuedu.elm.dao.OrderDetailetDaoImpl;
import com.neuedu.elm.entity.OrderDetailet;
import com.neuedu.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailetServiceImpl implements OrderDetailetService {
    private OrderDetailetDao dao = new OrderDetailetDaoImpl();
    @Override
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) {
        List<OrderDetailet> list = new ArrayList<>();

        try {
            DBUtil.getConnection();
            list = dao.listOrderDetailetByOrderId(orderId);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}
