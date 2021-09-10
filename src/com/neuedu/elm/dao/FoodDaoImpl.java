package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Food;
import com.neuedu.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    private Connection conn=null;
    private PreparedStatement st=null;
    private ResultSet rs=null;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) throws Exception {
        List<Food> list=new  ArrayList<>();
        String sql="select * from elm_food where business_id=?";

        try {
            conn=DBUtil.getConnection();
            st=conn.prepareStatement(sql);
            st.setInt(1,businessId);
            rs=st.executeQuery();
            while (rs.next()){
                Food f=new Food();
                f.setFoodId(rs.getInt("food_id"));
                f.setFoodName(rs.getString("food_name"));
                f.setFoodExplain(rs.getString("food_explain"));
                f.setFoodImg(rs.getString("food_img"));
                f.setFoodPrice(rs.getDouble("food_price"));
                f.setBusinessId(rs.getInt("business_id"));
                f.setRemarks(rs.getString("remarks"));
                list.add(f);
            }
        }finally {
            DBUtil.close(st,rs);
        }

        return list;
    }
}
