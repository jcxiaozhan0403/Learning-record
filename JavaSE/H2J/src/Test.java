import java.sql.*;

public class Test {
    // 将数据库对象设置为静态变量，保证连接只有一份
    private static Connection conn;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver"); //Mysql 5.0
        //Class.forName("com.mysql.cj.jdbc.Driver"); //Mysql 8.0
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //SqlServer

        //创建连接函数
        //useSSL=true&userUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8
        //useSSL安全连接 userUnicode是否支持中文编码 characterEncoding设置字符集编码 serverTimezone设置时区
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false&userUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8"; //Mysql
        //String url = "jdbc:sqlserver://localhost:1433;databaseName=soft1901"; //SqlServer
        String user = "root";
        String password = "lishuang001219";
        conn = DriverManager.getConnection(url,user,password);

        //数据库对象关于事务的操作
        //conn.setAutoCommit(false);
        //conn.commit();
        //conn.rollback();

        //创建Statement对象用于执行sql
        String sql = "insert into student values (?,?,?,?,?)";
        //预编译，填入sql，先不执行
        PreparedStatement ps = conn.prepareStatement(sql);
        //设置sql占位的值
        ps.setString(1,null);
        ps.setString(2,"王麻子");
        ps.setString(3,"男");
        ps.setInt(4,25);
        ps.setString(5,"计网19-1");
        //执行sql
        ps.executeUpdate();

        //关闭连接
        ps.close();
        conn.close();
    }
}