package sqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    private Connection conn;
    public Test() throws Exception {
        conn= sqlConnection.Connection.getConn();
    }

    public boolean sss(String username,String pwd) throws SQLException {
        String sql = "select * from users where userId = username and pwd = pwd";

        Statement statement = conn.createStatement();

        // 执行查询语句，并把结果集返回给ResultSet,基1(下标从一开始)
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            username = rs.getString(1);
            pwd = rs.getString(2);
            System.out.println(username);
            System.out.println(pwd);
        }


        try {
            return statement.execute(sql);
        } catch (Exception exception) {
            return false;
        }
    }

}
