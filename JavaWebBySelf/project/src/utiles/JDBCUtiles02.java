package utiles;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 *
 * JDBC工具类(适配C3P0连接池)
 *
 */

public class JDBCUtiles02 {
    //用静态方法，默认只创建一次连接池
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();

    //获取连接的方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //获取连接池的方法
    public static DataSource getDataSource(){
        return dataSource;
    }

    //释放资源
    public static void release(Statement stmt,Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            stmt = null;
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            rs = null;
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            stmt = null;
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            conn = null;
        }
    }
}
