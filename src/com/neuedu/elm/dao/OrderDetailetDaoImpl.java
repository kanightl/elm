package com.neuedu.elm.dao;

import com.neuedu.elm.entity.Food;
import com.neuedu.elm.entity.OrderDetailet;
import com.neuedu.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailetDaoImpl implements OrderDetailetDao {
    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public int saveOrderDetailetBatch(List<OrderDetailet> list) throws Exception {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer("insert into elm_orderdetailet(order_id,food_id,quantity) values ");
        for(OrderDetailet od : list) {
            stringBuffer.append("("+od.getOrderId()+","+od.getFoodId()+","+od.getQuantity()+")");
        }
        String sql = stringBuffer.toString();
        System.out.println(sql);
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            i = st.executeUpdate();
        }finally {
            DBUtil.close(st,rs);
        }
        return i;
    }

    @Override
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) throws Exception {
        List<OrderDetailet> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer();
        sql.append(" select o.*, ");
        sql.append("        f.food_id ffood_id, ");
        sql.append("        f.food_name ffood_name, ");
        sql.append("        f.food_price ffood_price ");
        sql.append(" from elm_orderdetailet o left join elm_food f on o.food_id=f.food_id ");
        sql.append(" where o.order_id=? ");
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql.toString());
            st.setInt(1, orderId);
            rs = st.executeQuery();
            while(rs.next()) {
                OrderDetailet od = new OrderDetailet();
                od.setOdId(rs.getInt("od_id"));
                od.setOrderId(rs.getInt("order_id"));
                od.setFoodId(rs.getInt("food_id"));
                od.setQuantity(rs.getInt("quantity"));
                Food food = new Food();
                food.setFoodId(rs.getInt("ffood_id"));
                food.setFoodName(rs.getString("ffood_name"));
                food.setFoodPrice(rs.getDouble("ffood_price"));
                od.setFood(food);
                list.add(od);
            }
        }finally {
            DBUtil.close(st,rs);
        }
        return list;
    }
}
