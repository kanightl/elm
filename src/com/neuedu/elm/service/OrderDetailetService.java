package com.neuedu.elm.service;

import com.neuedu.elm.entity.OrderDetailet;

import java.util.List;

public interface OrderDetailetService {
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId);

}
