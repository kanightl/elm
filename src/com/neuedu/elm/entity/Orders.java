package com.neuedu.elm.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private Integer orderId;
    private String userId;
    private Integer businessId;
    private String orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState;
    private Business business = new Business();
    private List<OrderDetailet> odList = new ArrayList<>();

    public Orders() {
    }

    public Orders(Integer orderId, String userId, Integer businessId, String orderDate, Double orderTotal, Integer daId, Integer orderState, Business business, List<OrderDetailet> odList) {
        this.orderId = orderId;
        this.userId = userId;
        this.businessId = businessId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.daId = daId;
        this.orderState = orderState;
        this.business = business;
        this.odList = odList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<OrderDetailet> getOdList() {
        return odList;
    }

    public void setOdList(List<OrderDetailet> odList) {
        this.odList = odList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId='" + userId + '\'' +
                ", businessId=" + businessId +
                ", orderDate='" + orderDate + '\'' +
                ", orderTotal=" + orderTotal +
                ", daId=" + daId +
                ", orderState=" + orderState +
                ", business=" + business +
                ", odList=" + odList +
                '}';
    }
}
