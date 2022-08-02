package cn.com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author John.Cena
 * @date 2022/8/2 9:18
 * @Description: 数据库公共类
 */
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //编写查询公共类
    //自动导包  alt + enter
    //有SQL异常 直接 alt + enter  抛出异常
    public static ResultSet execute(Connection connection, String sql, Object[] params, ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i <params.length ; i++) {
            // 数组从0开始， setObject 从1开始
            preparedStatement.setObject(i+1,params[i]);
        }
        //预编译SQL，直接添加就可以，不需要String sql
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //编写增删改工具类
    public static int execute(Connection connection,String sql, Object[] params,  PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i <params.length ; i++) {
            // 数组从0开始， setObject 从1开始
            preparedStatement.setObject(i+1,params[i]);
        }
        int Updaterows = preparedStatement.executeUpdate();
        return Updaterows;
    }

    //释放资源
    public static boolean closeresource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag =true;
        if( connection != null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag =false;
            }
        }
        if( preparedStatement != null){
            try {
                preparedStatement.close();
                //GC
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag =false;
            }
        }if( resultSet != null){
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag =false;
            }
        }
        return flag;
    }
}
