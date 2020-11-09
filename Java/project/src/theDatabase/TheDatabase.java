package theDatabase;

import java.sql.*;

public class TheDatabase {
    private static Connection conn; //创建到数据库的一个连接
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        //2.创建连接
        String url = "jdbc:sqlserver://localhost:1433;databaseName=soft1901";
        conn = DriverManager.getConnection(url,"sa","lishuang001219");

        System.out.println("连接创建成功！");

        return conn;
    }

    public static void closeConn(Statement s) throws SQLException {
        if (s != null){
            s.close();
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        try {
            Connection c = getConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Statement s = conn.createStatement();
//        String sql = "insert into student values('007',"+"'阿九'"+","+"'女'"+","+20+")";
        String sql = "select * from student";
        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            String id = rs.getString(1);// 可以使用字段名
            String name = rs.getString(2);// 也可以使用字段的顺序
            String sex = rs.getString(3);
            int age = rs.getInt(4);
            System.out.printf("%s\t%s\t%s\t%d%n", id, name, sex, age);
        }

        closeConn(s);
    }
}
