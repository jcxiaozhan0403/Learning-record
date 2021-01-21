import com.alibaba.druid.pool.DruidDataSource;
import utiles.JDBCUtiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * Druid连接池的使用(不使用配置文件)
 *
 */
public class Test03 {
    public static void main(String[] args) {
        //创建连接池
        DruidDataSource dataSource = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            //创建连接池
            dataSource = new DruidDataSource();
            //设置参数
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/student?serverTimezone=UTC");
            dataSource.setUsername("root");
            dataSource.setPassword("lishuang001219");
            //获取连接
            conn = dataSource.getConnection();

            String sql = "select * from admin";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtiles.release(rs,pstmt,conn);
        }
    }
}
