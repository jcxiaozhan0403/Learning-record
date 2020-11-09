package theDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TheDatabase {
    private static Connection conn; //创建到数据库的一个连接
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        //2.创建连接
        String url = "jdbc:sqlserver://localhost:1433;databaseName=soft1901";
        conn = DriverManager.getConnection(url,"sa","lishuang001219");
        return conn;
    }

    public static void closeConn(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Connection c = getConn();
            System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
