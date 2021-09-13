package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Business;
import com.neuedu.elm.entity.Orders;
import com.neuedu.elm.util.CommonUtil;
import com.neuedu.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public int saveOrders(Orders o) throws Exception {
        int i = 0;
        String sql = "insert into elm_orders values(null,?,?,?,?,?,0)";
        try {
            conn = DBUtil.getConnection();
            //设置返回自增长列值
            st = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, o.getUserId());
            st.setInt(2, o.getBusinessId());
            st.setString(3, CommonUtil.getCurrentDate());
            st.setDouble(4, o.getOrderTotal());
            st.setInt(5, o.getDaId());
            st.executeUpdate();
            //获取自增长列值
            rs = st.getGeneratedKeys();
            if(rs.next()){
                i = rs.getInt(1);
            }
        } finally {
            DBUtil.close(st,rs);
        }
        return i;

    }

    @Override
    public Orders getOrdersById(Integer orderId) throws Exception {
        Orders o = null;
        StringBuffer sql = new StringBuffer();
        sql.append(" select o.*, ");
        sql.append("        b.business_id bbusiness_id, ");
        sql.append("        b.business_name bbusiness_name, ");
        sql.append("        b.delivery_price bdelivery_price ");
        sql.append(" from elm_orders o left join elm_business b on o.business_id=b.business_id ");
        sql.append(" where o.order_id=? ");
        try {
            conn = DBUtil.getConnection();
            //设置返回自增长列值
            st = conn.prepareStatement(sql.toString());
            st.setInt(1, orderId);
            rs = st.executeQuery();
            if(rs.next()){
                o = new Orders();
                o.setOrderId(rs.getInt("order_id"));
                o.setUserId(rs.getString("user_id"));
                o.setBusinessId(rs.getInt("business_id"));
                o.setOrderDate(rs.getString("order_date"));
                o.setOrderTotal(rs.getDouble("order_total"));
                o.setOrderState(rs.getInt("order_state"));
                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusiness_id"));
                business.setBusinessName(rs.getString("bbusiness_name"));
                business.setDeliveryPrice(rs.getDouble("bdelivery_price"));
                o.setBusiness(business);
            }
        } finally {
            DBUtil.close(st,rs);
        }
        return o;

    }

    @Override
    public List<Orders> listOrdersById(String userId) throws Exception {
        List<Orders> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer();
        sql.append(" select o.*, ");
        sql.append("        b.business_id bbusinessId, ");
        sql.append("        b.business_name bbusinessName, ");
        sql.append("        b.delivery_price bdeliveryPrice ");
        sql.append(" from elm_orders o left join elm_business b on o.business_id=b.business_id ");
        sql.append(" where o.user_id=?");
        try {
            conn = DBUtil.getConnection();
            //设置返回自增长列值
            st = conn.prepareStatement(sql.toString());
            st.setString(1, userId);
            rs = st.executeQuery();
            while(rs.next()){
                Orders o = new Orders();
                o.setOrderId(rs.getInt("order_id"));
                o.setUserId(rs.getString("user_id"));
                o.setBusinessId(rs.getInt("business_id"));
                o.setOrderDate(rs.getString("order_date"));
                o.setOrderTotal(rs.getDouble("order_total"));
                o.setDaId(rs.getInt("da_id"));
                o.setOrderState(rs.getInt("order_state"));
                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                o.setBusiness(business);
                list.add(o);
            }
        } finally {
            DBUtil.close(st,rs);
        }
        return list;

    }
}
