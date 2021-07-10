package com.smis.common;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class SqlHelper {
    private static Connection conn;
    public static Connection getConn() throws ClassNotFoundException, SQLException, IOException{
        Properties prop=new Properties();
        prop.load(SqlHelper.class.getClassLoader().getResourceAsStream("prop.properties"));
        String driver=prop.getProperty("driver");
        String url=prop.getProperty("url");
        String user=prop.getProperty("user");
        String pwd=prop.getProperty("pwd");
        //1.加载驱动程序
        Class.forName(driver);
        //Class.forName("com.mysql.cj.jdbc.Driver");  mysql
        //2.创建一个连接
//		String url="jdbc:sqlserver://localhost:1433;databaseName=soft1901";
        conn=DriverManager.getConnection(url,user,pwd);
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo","root","password");
        return conn;//硬编码
    }
    public static void closeConn(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
