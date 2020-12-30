package sqlConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Connection {
    private static java.sql.Connection conn;
    public static java.sql.Connection getConn() throws Exception {
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");//mysql5之后的驱动jar包可以省略注册驱动的步骤
        // 3. 获取数据库连接对象 Connection
        conn = JDBCUtils.getConnection();
        return conn;
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
