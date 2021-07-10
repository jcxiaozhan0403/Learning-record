package theDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class SqlHelper {
    private static Connection conn;
    public static Connection getConn() throws ClassNotFoundException, SQLException, IOException{
        Properties prop=new Properties();
        prop.load(SqlHelper.class.getClassLoader().getResourceAsStream("prop.properties"));
        String driver=prop.getProperty("driver");
        String url=prop.getProperty("url");
        String user=prop.getProperty("user");
        String pwd=prop.getProperty("pwd");
        //1.加载驱动程序
        Class.forName(driver);
        //Class.forName("com.mysql.cj.jdbc.Driver");  mysql
        //2.创建一个连接
//		String url="jdbc:sqlserver://localhost:1433;databaseName=soft1901";
        conn=DriverManager.getConnection(url,user,pwd);
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo","root","password");
        return conn;//硬编码
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