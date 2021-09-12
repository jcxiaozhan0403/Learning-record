package com.day2;

import com.day2.util.JDBCUtils;

import java.sql.*;

public class DBTest {
    private static Connection conn;
    private static Statement s;
    private static PreparedStatement ps;

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
    public void insert() throws Exception {
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

        //sql1：建表
        public void createTable() throws Exception {
            conn = JDBCUtils.getConnection();

            String sql1 = "create table account ( " +
                    "id int(4) primary key not null auto_increment," +
                    "name varchar(10)," +
                    "money double(10,2))";

            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.execute();

            JDBCUtils.close(conn,ps);
        }


        //sql2：插入记录
        public void insert2() throws Exception {
            conn = JDBCUtils.getConnection();

            String sql = "insert into account (name,money) values (?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"张三");
            ps.setDouble(2,10000);
            ps.execute();

            ps.setString(1,"李四");
            ps.setDouble(2,10000);
            ps.execute();

            JDBCUtils.close(conn,ps);
        }
        //sql3：转账
        public void moveMoney() throws SQLException {
            try {
                conn = JDBCUtils.getConnection();
                String sql = "update account set money = money-5000 where name = '张三'";
                String sql2 = "update account set money = money+5000 where name = '李四'";
                ps = conn.prepareStatement(sql);
                ps.execute();
                ps = conn.prepareStatement(sql2);
                ps.execute();
            }catch (Exception e) {
                conn.rollback();
            }finally {
                JDBCUtils.close(conn,ps);
            }
        }


    public static void main(String[] args) throws Exception {
        DBTest dbTest = new DBTest();
        dbTest.moveMoney();
    }
}
