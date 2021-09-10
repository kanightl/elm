package com.neuedu.elm.dao;

import com.neuedu.elm.entity.User;
import com.neuedu.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//dao层不自己处理异常，需要把异常抛给service层
public class UserDaoImpl implements UserDao {


    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public int saveUser(User u) throws Exception {
        int i = 0;
        String sql = "insert into elm_user(user_id,password,user_name,user_sex,user_img,del_tag) values (?,?,?,?,?,1)";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, u.getUserId());
            st.setString(2, u.getPassword());
            st.setString(3, u.getUserName());
            st.setInt(4, u.getUserSex());
            st.setString(5, u.getUserImg());
            i = st.executeUpdate();
        } finally {
            DBUtil.close(st, rs);
        }

        return i;
    }

    @Override
    public User getUserByIdByPass(String id, String pass) throws Exception {
        User u2=null;
        String sql="select * from elm_user where user_id=? and password=?";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2,pass);
            rs=st.executeQuery();
            while (rs.next()){
                u2=new User();
                u2.setUserId(rs.getString("user_id"));
                u2.setPassword(rs.getString("password"));
                u2.setUserName(rs.getString("user_name"));
                u2.setUserSex(rs.getInt("user_sex"));
                u2.setUserImg(rs.getString("user_img"));
                u2.setDelTag(rs.getInt("del_tag"));
            }


        } finally {
            DBUtil.close(st, rs);
        }

        return u2;
    }

    @Override
    public User getUserById(String id) throws Exception {
        User u2=null;
        String sql="select * from elm_user where user_id=? ";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs=st.executeQuery();
            while (rs.next()){
                u2=new User();
                u2.setUserId(rs.getString("user_id"));
                u2.setPassword(rs.getString("password"));
                u2.setUserName(rs.getString("user_name"));
                u2.setUserSex(rs.getInt("user_sex"));
                u2.setUserImg(rs.getString("user_img"));
                u2.setDelTag(rs.getInt("del_tag"));
            }
        } finally {
            DBUtil.close(st, rs);
        }

        return u2;
    }
}
