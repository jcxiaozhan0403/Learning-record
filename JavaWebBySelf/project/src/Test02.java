import com.alibaba.druid.pool.DruidDataSource;
import utiles.JDBCUtiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * JDBC PreparedStatement
 *
 */
public class Test02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = JDBCUtiles.getConnection();

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
