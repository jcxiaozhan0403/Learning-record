package com.jc.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */

public class JDBCUtil {
    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        //读取配置文件
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driverClassName = properties.getProperty("driverClassName");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //注册驱动的方法
    public static void loadDriver() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接的方法
    public static Connection getConnection() {
        Connection conn = null;

        try {
            //注册驱动
            loadDriver();
            //获取连接
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    //释放资源
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            conn = null;
        }
    }
}