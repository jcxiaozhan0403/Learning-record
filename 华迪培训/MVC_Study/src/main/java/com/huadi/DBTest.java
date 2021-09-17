package com.huadi;

import java.sql.*;

/***
 * 1、加载驱动
 * 2、获取连接对象
 * 3、语句对象执行SQL
 * 4、处理返回结果
 * 5、释放资源
 */
public class DBTest {
    private static String URL = "jdbc:mysql://localhost:3306/springmvc-study?CharactorEncoding=utf-8";
    private static String DriverClass = "com.mysql.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "lishuang001219";
    private static Connection connection = null;
    private static PreparedStatement ps = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {
//        捕获异常
        try {
            Class.forName(DriverClass);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
//        处理异常
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     */
    public static void closeResource(){
         if(connection != null){
             try {
                 connection.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
    }

    /**
     * 查询数据
     * @param
     */
    public static void getStudents(){
        connection = getConnection();
        try {
             ps = connection.prepareStatement("select * from student");
            resultSet =  ps.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("s_no"));
                System.out.println(resultSet.getString("s_name"));
                System.out.println(resultSet.getString("s_sex"));
                System.out.println(resultSet.getString("birthday"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增记录
     * @param
     */
    public static void insertStudent() throws SQLException {
        connection = getConnection();
        ps = connection.prepareStatement("insert into student (s_name,s_sex,s_score) values (?,?,?)");
        ps.setString(1,"bobo");
        ps.setString(2,"男");
        ps.setDouble(3,88.5);
        int result = ps.executeUpdate();
//        statement = connection.createStatement();
//        int result = statement.executeUpdate("insert into student (s_name,s_sex,s_score) values ('abc','男',86.5)");

        System.out.println(result);
    }

    /**
     * 创建表
     * @param
     * @throws SQLException
     */
    public static void createTable(){
        connection = getConnection();
        try {
//            如果存在orde2就先删除
            ps = connection.prepareStatement("drop table  if exists order2");
            ps.executeUpdate();
//              创建表order2
            ps = connection.prepareStatement("" +
                    "create table order2 (" +
                    "o_id int(4) not null primary key auto_increment," +
                    "o_name varchar(12)," +
                    "o_price double(6,2)," +
                    "o_date date" +
                    ")");
            int result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
//        connection = DBTest.getConnection();
//        if(connection != null){
//            System.out.println("连接成功");
//        }
//        else{
//            System.out.println("连接失败");
//        }
//        getStudents();
//        insertStudent();
//        createTable();
        System.out.println(getConnection());;
        closeResource();
    }
}
