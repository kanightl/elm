package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Business;
import com.neuedu.elm.entity.Cart;
import com.neuedu.elm.entity.Food;
import com.neuedu.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private Connection conn=null;
    private PreparedStatement st=null;
    private ResultSet rs=null;


    @Override
    public List<Cart> listCart(Cart cart) throws Exception {
        List<Cart> list =new ArrayList<>();
        StringBuffer sql=new StringBuffer();
        sql.append(" select c.*, ");
        sql.append("   f.food_id ff_id, ");
        sql.append("   f.food_name ff_name, ");
        sql.append("   f.food_explain ff_explain, ");
        sql.append("   f.food_img ff_img, ");
        sql.append("   f.food_price ff_price,");
        sql.append("   f.business_id ff_businessid, ");
        sql.append("   f.remarks f_remarks, ");
        sql.append("   b.business_id bb_id, ");
        sql.append("   b.business_name bb_name, ");
        sql.append("   b.business_address bb_address, ");
        sql.append("   b.business_explain bb_explain, ");
        sql.append("   b.business_img bb_img, ");
        sql.append("   b.order_typeid b_ordertypeid, ");
        sql.append("   b.star_price b_starprice, ");
        sql.append("   b.delivery_price b_deliveryprice");
        sql.append("   from (elm_cart c left join elm_food f on c.food_id=f.food_id) ");
        sql.append("   left join elm_business b on c.business_id=b.business_id ");
        sql.append("  where 1=1 ");
        if (cart.getBusinessId()!=null){
            sql.append(" and c.business_id="+cart.getBusinessId() );
        }
        if (cart.getUserId()!=null){
            sql.append("  and c.user_id='"+cart.getUserId()+"'");
        }


        try {
            conn= DBUtil.getConnection();
            st=conn.prepareStatement(sql.toString());
            rs=st.executeQuery();
            while (rs.next()){
                Cart c = new Cart();
                c.setCartId(rs.getInt("cart_id"));
                c.setFoodId(rs.getInt("food_id"));
                c.setBusinessId(rs.getInt("business_id"));
                c.setUserId(rs.getString("user_id"));
                c.setQuantity(rs.getInt("quantity"));
                Food f = new Food();
                f.setFoodId(rs.getInt("ff_id"));
                f.setFoodName(rs.getString("ff_name"));
                f.setFoodExplain(rs.getString("ff_explain"));
                f.setFoodImg(rs.getString("ff_img"));
                f.setFoodPrice(rs.getDouble("ff_price"));
                f.setBusinessId(rs.getInt("ff_businessid"));
                f.setRemarks(rs.getString("f_remarks"));
                c.setFood(f);
                Business b = new Business();
                b.setBussinessId(rs.getInt("bb_id"));
                b.setBusinessName(rs.getString("bb_name"));
                b.setBusinessAddress(rs.getString("bb_address"));
                b.setBusinessExplain(rs.getString("bb_explain"));
                b.setBusinessImg(rs.getString("bb_img"));
                b.setOrderTypeId(rs.getInt("b_ordertypeid"));
                b.setStarPrice(rs.getDouble("b_starprice"));
                b.setDeliveryPrice(rs.getDouble("b_deliveryprice"));
                c.setBusiness(b);
                list.add(c);

            }
        }finally {
            DBUtil.close(st,rs);
        }

        return list;
    }

    @Override
    public int saveCart(Cart cart) throws Exception {
        int i=0;
        String sql="insert into elm_cart(food_id,business_id,user_id,quantity) values (?,?,?,1)";
        try {
            conn=DBUtil.getConnection();
            st=conn.prepareStatement(sql);
            st.setInt(1,cart.getFoodId());
            st.setInt(2,cart.getBusinessId());
            st.setString(3,cart.getUserId());
            i=st.executeUpdate();
        }finally {
            DBUtil.close(st,rs);
        }
        return i;
    }

    @Override
    public int removeCart(Cart cart) throws Exception {
        int i=0;
        StringBuffer sql = new StringBuffer("delete from elm_cart where 1=1 ");
        if(cart.getFoodId()!=null) {
            sql.append(" and food_id="+cart.getFoodId());
        }
        if(cart.getBusinessId()!=null) {
            sql.append(" and business_id="+cart.getBusinessId());
        }
        if(cart.getUserId()!=null) {
            sql.append(" and user_id='"+cart.getUserId()+"'");
        }
        try {
            conn=DBUtil.getConnection();
            st=conn.prepareStatement(sql.toString());

            i=st.executeUpdate();
        }finally {
            DBUtil.close(st,rs);
        }
        return i;
    }

    @Override
    public int updateCart(Cart cart) throws Exception {
        int i = 0;
        String sql = "update elm_cart set quantity=? where food_id=? and business_id=? and user_id=?";
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, cart.getQuantity());
            st.setInt(2, cart.getFoodId());
            st.setInt(3, cart.getBusinessId());
            st.setString(4, cart.getUserId());
            i = st.executeUpdate();
        }finally {
            DBUtil.close(st,rs);
        }
        return i;
    }
}
