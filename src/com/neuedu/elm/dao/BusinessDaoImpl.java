package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Business;
import com.neuedu.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) throws Exception {
        List<Business> list = new ArrayList<>();
        String sql = "select * from elm_business where order_typeid=? order by business_id";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, orderTypeId);
            rs = st.executeQuery();
            while (rs.next()) {
                Business b = new Business();
                b.setBussinessId(rs.getInt("business_id"));
                b.setBusinessName(rs.getString("business_name"));
                b.setBusinessAddress(rs.getString("business_address"));
                b.setBusinessExplain(rs.getString("business_explain"));
                b.setBusinessImg(rs.getString("business_img"));
                b.setOrderTypeId(rs.getInt("order_typeid"));
                b.setStarPrice(rs.getDouble("star_price"));
                b.setDeliveryPrice(rs.getDouble("delivery_price"));
                b.setRemarks(rs.getString("remarks"));
                list.add(b);
            }
        } finally {
            DBUtil.close(st, rs);
        }
        return list;
    }
    @Override
    public Business getBusinessById(Integer businessId) throws Exception {
        Business b = null;
        String sql = "select * from elm_business where business_id=? ";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, businessId);
            rs = st.executeQuery();
            while (rs.next()) {
                b = new Business();
                b.setBussinessId(rs.getInt("business_id"));
                b.setBusinessName(rs.getString("business_name"));
                b.setBusinessAddress(rs.getString("business_address"));
                b.setBusinessExplain(rs.getString("business_explain"));
                b.setBusinessImg(rs.getString("business_img"));
                b.setOrderTypeId(rs.getInt("order_typeId"));
                b.setStarPrice(rs.getDouble("star_price"));
                b.setDeliveryPrice(rs.getDouble("delivery_price"));
                b.setRemarks(rs.getString("remarks"));
            }
        } finally {
            DBUtil.close(st, rs);
        }
        return b;
    }

    @Override
    public List<Business> listBusinessByName(String businessName) throws Exception {
        List<Business> list = new ArrayList<>();
        String sql = "select * from elm_business where business_name like  ";
        sql += "  '%" + businessName + "%' ";
        sql += " order by business_id ";
        System.out.println(sql);
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Business b = new Business();
                b.setBussinessId(rs.getInt("business_id"));
                b.setBusinessName(rs.getString("business_name"));
                b.setBusinessAddress(rs.getString("business_address"));
                b.setBusinessExplain(rs.getString("business_explain"));
                b.setBusinessImg(rs.getString("business_img"));
                b.setOrderTypeId(rs.getInt("order_typeId"));
                b.setStarPrice(rs.getDouble("star_price"));
                b.setDeliveryPrice(rs.getDouble("delivery_price"));
                b.setRemarks(rs.getString("remarks"));
                list.add(b);
            }
        } finally {
            DBUtil.close(st, rs);
        }
        return list;
    }
}
