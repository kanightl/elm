package com.neuedu.elm.util;

import java.sql.*;

public class DBUtil {
    private static final ThreadLocal<Connection> TL = new ThreadLocal<>();
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/elm2?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private static final String username = "root";
    private static final String password = "zhanghua1100";

    private static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //获取连接对象
    public static Connection getConnection() {
        Connection conn = TL.get();
        if (conn == null) {
            conn = createConnection();
            TL.set(conn);
        }
        return conn;
    }

    //开启事务
    public static void beginTransaction() throws SQLException {
        Connection conn = TL.get();
        if (conn == null) {
            conn = createConnection();
            TL.set(conn);
        }
        conn.setAutoCommit(false);
    }

    //提交事务
    public static void commitTransaction() throws SQLException {
        Connection conn = TL.get();
        conn.commit();
    }

    //回滚事务
    public static void rollbackTransaction() throws SQLException {
        Connection conn = TL.get();
        conn.rollback();
    }

    //释放语句对象和结果集对象
    public static void close(Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //释放连接
    public static void close() {
        Connection conn = TL.get();
        try {
            if (conn != null) {
                conn.close();
                TL.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
