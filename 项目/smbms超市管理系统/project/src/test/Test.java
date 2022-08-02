import java.sql.*;

public class Test {
    // 将数据库对象设置为静态变量，保证连接只有一份
    private static Connection conn;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver"); //Mysql 5.0


        //创建连接函数
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false&userUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8"; //Mysql
        String user = "root";
        String password = "lishuang001219";
        conn = DriverManager.getConnection(url,user,password);

        //数据库对象关于事务的操作
        //conn.setAutoCommit(false); 关闭提交，会自动开启事务
        //conn.commit();
        //conn.rollback();

        //创建Statement对象用于执行sql
        Statement statement = conn.createStatement();

        //SQL语句
        String sql = "select * from student";

        //执行SQL，返回结果集
        ResultSet resultSet = statement.executeQuery(sql);
        // statement.execute(sql)  可以执行所有的sql语句，由于效率问题，一般不使用
        // statement.executeQuery(sql)  执行查询语句，返回一个结果集
        // statement.executeUpdate(sql) 执行更新、插入、删除语句，返回一个int代表受影响行数

        //操作结果集
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("stuId") + " " + resultSet.getString("stuName") + " " + resultSet.getString("stuSex") + " " + resultSet.getInt("stuAge") + " " + resultSet.getString("stuCls") + "\r\n");
        }

        //关闭连接
        resultSet.close();
        statement.close();
        conn.close();
    }
}