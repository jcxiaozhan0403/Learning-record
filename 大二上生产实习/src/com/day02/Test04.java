package com.day02;

import java.sql.*;

public class Test04 {
    private static Connection conn;
    public static void main(String[] args) throws Exception{
        String name = "张三";
        String pwd = " a' or 'b' = 'b ";
        boolean flag = login(name,pwd);
        System.out.println(flag);
    }
    public static boolean login(String name,String pwd) throws Exception{
        // 连接数据库，去查找  stu 表，有没有name = name ，pwd = pwd。

        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");//mysql5之后的驱动jar包可以省略注册驱动的步骤
        // 3. 获取数据库连接对象 Connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=UTC", "root", "lishuang001219");
        // 4.定义sql
        String sql = "select * from users where username = ? and pwd = ? ";
        // 5 ，获取sql 执行对象，换成pre

        PreparedStatement pre = conn.prepareStatement(sql);

        // 6. 要给占位符赋值
        pre.setString(1,name);
        pre.setString(2,pwd);

        ResultSet resultSet = pre.executeQuery();

        return resultSet.next();
    }
}
