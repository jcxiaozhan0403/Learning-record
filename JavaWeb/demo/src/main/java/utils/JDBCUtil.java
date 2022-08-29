package utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
 * 封装一个工具类，能够减少重复代码
 *
 * 可以通过一个配置文件的形式，导入
 *
 * */
public class JDBCUtil {
    private static  String url;
    private static String pwd;
    private static  String user;
    static {
        // 静态变量代码块中赋值。
        // 1. 读取，配置配置文件
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("database.properties"));
            url = properties.getProperty("jdbc.url");
            pwd = properties.getProperty("jdbc.password");
            user = properties.getProperty("jdbc.username");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 获取连接
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,user,pwd);
    }

    //关闭资源
    public static void close(Connection connection, Statement statement){
        if(statement != null){
            try {
                statement.close(); // 关闭资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close(); /// 关闭conn 资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(statement != null){
            try {
                statement.close(); // 关闭资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close(); // 关闭conn 资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet != null){
            resultSet.close();
        }
    }
}