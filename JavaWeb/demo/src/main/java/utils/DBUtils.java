package utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author John.Cena
 * @date 2022/8/29 10:16
 * @Description:
 */
public class DBUtils {
    private static DataSource dataSource;

    static {
        // 静态变量代码块中赋值。
        // 1. 读取，配置配置文件
        try {
            Properties properties = new Properties();
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            //使用工厂，创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 获取连接
    public static Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }

    //封装关闭资源的方法
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
