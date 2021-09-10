package com.neuedu.elm.dao;

import com.neuedu.elm.entity.OrderDetailet;

import java.util.List;

public interface OrderDetailetDao {
    public int saveOrderDetailetBatch(List<OrderDetailet> list) throws Exception;
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) throws Exception;
}

