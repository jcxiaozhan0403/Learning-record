package com.day02;

import java.rmi.ConnectIOException;
import java.sql.*;

/*
* 1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
	1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
	2.右键-->Add As Library
2. 注册驱动
3. 获取数据库连接对象 Connection
4. 定义sql
5. 获取执行sql语句的对象 Statement
6. 执行sql，接受返回结果
7. 处理结果
8. 释放资源
*
*
*
* */
public class Test03 {
    private static Connection conn;
        public static void main(String[] args) throws Exception {
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");//mysql5之后的驱动jar包可以省略注册驱动的步骤
        // 3. 获取数据库连接对象 Connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=UTC", "root", "lishuang001219");
//        // 4. 定义sql
        String sql = "select * from users where username ='349636607' and pwd = 'lishuang001219'";

//            String sql = "select * from users where  username = '"+name+"'  and pwd = '"+pwd+"'";


        //5. 获取执行sql语句的对象 Statement
        Statement statement = conn.createStatement();

        // 执行查询语句，并把结果集返回给ResultSet,基1(下标从一开始)
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String username = rs.getString(1);
            String pwd = rs.getString(2);
            System.out.println(username);
            System.out.println(pwd);
        }


        // 6. 执行sql
//        boolean execute = statement.execute(sql);
//        System.out.println(execute);
        // 7.关闭
        statement.close();
        conn.close();
    }
}
