package com.day02;

import java.sql.*;

public class Test05 {
    public static void main(String[] args) {
        PreparedStatement pre = null;
        Connection conn = null;
        try{
            //2.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");//mysql5之后的驱动jar包可以省略注册驱动的步骤
            // 3. 获取数据库连接对象 Connection
            conn = JDBCUtils.getConnection();
            // 4.定义sql
            String sql = "select * from stu where name = ? and pwd = ? ";
            // 5 ，获取sql 执行对象，换成pre

            pre = conn.prepareStatement(sql);

            // 6. 要给占位符赋值
            pre.setString(1,"xx");
            pre.setString(2,"xx");

            ResultSet resultSet = pre.executeQuery();
            if(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }else {
                System.out.println("没有查询到数据");
            }
        }catch (Exception e){
            System.out.println("xxxx");
            e.printStackTrace(); // 打印
        }finally {
            // 不管有没有发生异常都不要执行代码块
            if(pre != null){
                try {
                    pre.close(); // 关闭资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close(); /// 关闭conn 资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
