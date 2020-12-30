package com.day02;

import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
public class Test {
    private static Connection conn;
//    public static void main(String[] args) throws Exception {
//        //2.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");//mysql5之后的驱动jar包可以省略注册驱动的步骤
//        // 3. 获取数据库连接对象 Connection
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=UTC", "root", "lishuang001219");
//        // 4. 定义sql
//        String sql = "insert into stu(id,name,sex,age) values(1,'张三','男',18)";
//        //5. 获取执行sql语句的对象 Statement
//        Statement statement = conn.createStatement();
//        // 6. 执行sql
//        boolean execute = statement.execute(sql);
//        System.out.println(execute);
//        // 7.关闭
//        statement.close();
//        conn.close();
//    }
    public static Connection getConn() throws Exception {
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");//mysql5之后的驱动jar包可以省略注册驱动的步骤
        // 3. 获取数据库连接对象 Connection
        conn = JDBCUtils.getConnection();
        // 4. 定义sql
        String sql = "insert into stu(id,name,sex,age) values(1,'张三','男',18)";
        //5. 获取执行sql语句的对象 Statement
        Statement statement = conn.createStatement();
        // 6. 执行sql
        boolean execute = statement.execute(sql);
        System.out.println(execute);

        return conn;
    }

    //关闭
    public static void closeConn(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        conn = getConn();
        System.out.println(conn);
    }
}
