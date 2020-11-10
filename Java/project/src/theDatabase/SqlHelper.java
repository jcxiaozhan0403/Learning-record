package theDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SqlHelper {
    private static Connection conn;
    public static Connection getConn() throws ClassNotFoundException, SQLException{
        //1.加载驱动程序
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Class.forName("com.mysql.cj.jdbc.Driver");  mysql
        //2.创建一个连接
        String url="jdbc:sqlserver://localhost:1433;databaseName=soft1901";
        conn=DriverManager.getConnection(url,"sa","lishuang001219");
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo","root","password");
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
//	public static void main(String[] args) {
//		try {
//			Connection c=getConn();
//		//	System.out.print("数据库连接成功！");
//			//查询数据
//			//1.创建statement的一个对象
//			Statement state=c.createStatement();
//			//2.编写sql语句
//			String sql="select * from student";
//			//3.执行sql
//			ResultSet rs=state.executeQuery(sql);
//			//4.显示数据
//			System.out.print("学号\t姓名\t性别\t年龄\n");
//			while(rs.next()){
//				String id=rs.getString("stuId");
//				String name=rs.getString("stuName");
//				String sex=rs.getString("stuSex");
//				int age=rs.getInt("stuAge");
//				System.out.print(id+"\t"+name+"\t"+sex+"\t"+age+"\n");
//			}
//			//5.关闭连接
//			c.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
}
