package sqlConnection;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtils {
    private static  String url ;
    private static String pwd;
    private static  String user;
    static {
        // 静态变量代码块中赋值。
        // 1. 读取，配置配置文件
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = properties.getProperty("url");
            pwd = properties.getProperty("pwd");
            user = properties.getProperty("user");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /* 获取连接*/
    public static java.sql.Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,user,pwd);
    }
    /*
     * 封装关闭资源的方法
     * */
    public static void close(java.sql.Connection connection, Statement statement){
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
                connection.close(); /// 关闭conn 资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet != null){
            resultSet.close();
        }
    }
}
