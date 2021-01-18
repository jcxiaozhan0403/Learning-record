import utiles.JDBCUtiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try{
            conn = JDBCUtiles.getConnection();
            statement = conn.createStatement();

            String sql = "select * from admin";

            rs = statement.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\n");
            }
        }catch (Exception e){

        }finally {
            JDBCUtiles.release(rs,statement,conn);
        }
    }
}
