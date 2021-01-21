import com.mchange.v2.c3p0.ComboPooledDataSource;
import utiles.JDBCUtiles;
import utiles.JDBCUtiles02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * C3P0连接池的使用(使用配置文件、使用新工具类)
 *
 */
public class Test06 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            //获取连接
            conn = JDBCUtiles02.getConnection();

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
