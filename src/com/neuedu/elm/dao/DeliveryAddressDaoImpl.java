package com.neuedu.elm.dao;

import com.neuedu.elm.entity.DeliveryAddress;
import com.neuedu.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDaoImpl implements DeliveryAddressDao {
    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) throws Exception {
        List<DeliveryAddress> list = new ArrayList<>();
        String sql = "select * from elm_deliveryAddress where user_id=? order by da_id";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, userId);
            rs = st.executeQuery();
            while(rs.next()) {
                DeliveryAddress d = new DeliveryAddress();
                d.setDaId(rs.getInt("da_id"));
                d.setContactName(rs.getString("contact_name"));
                d.setContactSex(rs.getInt("contact_sex"));
                d.setContactTel(rs.getString("contact_tel"));
                d.setAddress(rs.getString("address"));
                d.setUserId(rs.getString("user_id"));
                list.add(d);
            }
        }finally {
            DBUtil.close(st,rs);
        }
        return list;
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress d) throws Exception {
        int i=0;
        String sql = "insert into elm_deliveryAddress (da_id,contact_name,contact_sex,contact_tel,address,user_id) values (null ,?,?,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, d.getContactName());
            st.setInt(2, d.getContactSex());
            st.setString(3, d.getContactTel());
            st.setString(4, d.getAddress());
            st.setString(5, d.getUserId());
            i=st.executeUpdate();
        }finally {
            DBUtil.close(st,rs);
        }
        return i;
    }

    @Override
    public int removeDeliveryAddress(Integer daId) throws Exception {
        int i=0;
        String sql = "delete from elm_deliveryAddress where da_id=?";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, daId);
            i=st.executeUpdate();
        }finally {
            DBUtil.close(st,rs);
        }
        return i;
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) throws Exception {
        DeliveryAddress d2 = null;
        String sql = "select * from elm_deliveryAddress where da_id=?";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, daId);
            rs = st.executeQuery();
            if(rs.next()) {
                d2 = new DeliveryAddress();
                d2.setDaId(rs.getInt("da_id"));
                d2.setContactName(rs.getString("contact_name"));
                d2.setContactSex(rs.getInt("contact_sex"));
                d2.setContactTel(rs.getString("contact_tel"));
                d2.setAddress(rs.getString("address"));
                d2.setUserId(rs.getString("user_id"));
            }
        }finally {
            DBUtil.close(st,rs);
        }
        return d2;

    }

    @Override
    public int updateDeliveryAddress(DeliveryAddress d) throws Exception {
        int i = 0;
        String sql = "update elm_deliveryAddress set contact_name=?,contact_sex=?,contact_tel=?,address=?,user_id=? where da_id=?";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, d.getContactName());
            st.setInt(2, d.getContactSex());
            st.setString(3, d.getContactTel());
            st.setString(4, d.getAddress());
            st.setString(5, d.getUserId());
            st.setInt(6, d.getDaId());
            i = st.executeUpdate();
        }finally {
            DBUtil.close(st,rs);
        }
        return i;
    }
}
