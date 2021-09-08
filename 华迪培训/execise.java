package com.day2;

import java.sql.*;

public class execise {

    private static Connection con  = null;
    private static PreparedStatement ps=null;
    private static Statement statement = null;
//建立account表
    public static void createTable(){
         con = DBTest.getConnection();
        try {
            ps = con.prepareStatement("create table account" +
                    "(id int(4) not null primary key auto_increment," +
                    "name varchar(12)," +
                    "money int(8))");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//插入记录
    public static void insertData() throws SQLException {
        con = DBTest.getConnection();
        ps = con.prepareStatement("insert into account values (?,?,?)");
        ps.setInt(1,1);
        ps.setString(2,"张三");
        ps.setInt(3,10000);
        ps.executeUpdate();

        ps = con.prepareStatement("insert into account values (?,?,?)");
        ps.setInt(1,2);
        ps.setString(2,"李四");
        ps.setInt(3,10000);
        ps.executeUpdate();
    }

    /**
     * 模拟一次转账操作
     * @throws SQLException
     */
    public static void transfer() throws SQLException {

        con = DBTest.getConnection();
        con.setAutoCommit(false);
        Savepoint savepoint = null;
        try{
            //支出
            ps = con.prepareStatement("update account set money = money - ? where name = ?");
            ps.setInt(1,5000);
            ps.setString(2,"张三");
            ps.executeUpdate();
            savepoint = con.setSavepoint(); //回滚点
            int i= 100/0; //产生异常
          //收入
            ps = con.prepareStatement("update account set money = money + ? where name = ?");
            ps.setInt(1,5000);
            ps.setString(2,"李四");
            ps.executeUpdate();

        }catch (Exception ex){
            con.rollback(savepoint);  //回滚
        }
        finally {
            con.commit();
        }

    }
    public static void main(String[] args) throws SQLException {
//        createTable();
//        insertData();
        transfer();
    }
}
