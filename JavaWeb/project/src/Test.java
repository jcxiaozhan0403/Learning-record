import utiles.JDBCUtiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * JDBC Statement
 *
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = JDBCUtiles.getConnection();
            stmt = conn.createStatement();

            String sql = "select * from admin";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtiles.release(rs,stmt,conn);
        }
    }
}
