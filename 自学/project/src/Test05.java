import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import utiles.JDBCUtiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * C3P0连接池的使用(使用配置文件)
 *
 */
public class Test05 {
    public static void main(String[] args) {
        //创建连接池
        ComboPooledDataSource dataSource = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            //创建连接池,会自动查找类路径下的配置文件
            dataSource = new ComboPooledDataSource();
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
