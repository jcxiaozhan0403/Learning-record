package com.day2;

import com.day2.util.JDBCUtils;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DBTest {
    private static Connection conn;

    //查询全部
    public void find() throws Exception {
        Class.forName(JDBCUtils.getDriver());
        conn = JDBCUtils.getConnection();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from student");
        while (rs.next()) {
            String s_id = rs.getString(1);
            String s_number = rs.getString(2);
            String s_name = rs.getString(3);
            int s_age = rs.getInt(4);
            String s_tel = rs.getString(5);
            String s_address = rs.getString(6);
            double s_score = rs.getDouble(7);
            String t_id = rs.getString(8);
            Date birthday = rs.getDate(9);
            System.out.println(s_id + " " + s_number + " " + s_name + " " + s_age + " " + s_tel + " " + s_address + " " + s_score + " " + t_id + " " + birthday + "\n");
        }

        JDBCUtils.close(conn,statement,rs);
    }

    // 新增
    public void createTable() throws Exception {
        Class.forName(JDBCUtils.getDriver());
        conn = JDBCUtils.getConnection();

        String sql = "insert into Student (s_number,s_name,s_age,s_tel,s_address,s_score) values(?,?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,123456);
        ps.setString(2,"新增");
        ps.setInt(3,45);
        ps.setString(4,"18982379506");
        ps.setString(5,"成都");
        ps.setDouble(6,88.0);

        ps.execute();

        JDBCUtils.close(conn,ps);
    }

    //练习
    public void test() throws Exception {
        Class.forName(JDBCUtils.getDriver());
        conn = JDBCUtils.getConnection();
        conn.setAutoCommit(false);

        //sql1：建表
        String sql1 = "create table account ( " +
                "id int(4) primary key not null auto_increment," +
                "name varchar(10)," +
                "money double(10,2))";

        PreparedStatement ps = conn.prepareStatement(sql1);
        ps.execute();

        //sql2：插入记录
        String sql2 = "insert into account (name,money) values (?,?);";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setString(1,"张三");
        ps2.setDouble(2,10000);
        ps2.execute();

        ps2.setString(1,"李四");
        ps2.setDouble(2,10000);
        ps2.execute();
        //sql3：转账

//        PreparedStatement ps3 = null;
//        PreparedStatement ps4 = null;
//        try {
//            String sql4 = "update account set money = money-5000 where name = '张三'";
//            String sql5 = "update account set money = money+5000 where name = '李四'";
//            ps3 = conn.prepareStatement(sql4);
//            ps4 = conn.prepareStatement(sql5);
//
//            ps3.execute();
//            ps4.execute();
//        }catch (Exception e) {
//            conn.rollback();
//        }finally {
//            JDBCUtils.close(conn,ps);
//            JDBCUtils.close(conn,ps2);
//            JDBCUtils.close(conn,ps3);
//            JDBCUtils.close(conn,ps4);
//        }

    }
    public static void main(String[] args) throws Exception {

    }
}
