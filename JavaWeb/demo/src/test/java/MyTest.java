import org.junit.Test;
import utils.DBUtils;
import utils.JDBCUtil;

import java.sql.*;

public class MyTest {
    private static Connection conn;

    @Test
    public void t2() throws Exception {
        conn = DBUtils.getConnection();

        String sql = "select * from tb_user";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.print(resultSet.getString("name") + " ");
            System.out.print(resultSet.getInt("age") + " ");
            System.out.println(resultSet.getString("email") + " ");
        }


    }
}