package dao;

import handler.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
    private static Connection conn;
    public static boolean login(String name,String pwd) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = JDBCUtils.getConnection();

        String sql = "select * from admin where userName = ? and password = ? ";
        PreparedStatement pre = conn.prepareStatement(sql);

        pre.setString(1,name);
        pre.setString(2,pwd);

        ResultSet resultSet = pre.executeQuery();

        return resultSet.next();
    }
}
