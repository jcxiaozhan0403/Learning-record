import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import utiles.JDBCUtiles;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * Druid连接池的使用(使用配置文件)
 *
 */
public class Test04 {
    public static void main(String[] args) {
        //创建连接池
        DataSource dataSource = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            //读取配置信息
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
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
