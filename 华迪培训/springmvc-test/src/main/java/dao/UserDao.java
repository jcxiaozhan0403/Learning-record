package dao;

import org.springframework.stereotype.Repository;
import pojo.User;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static Connection conn;
    private static Statement s;
    private static PreparedStatement ps;

    //查询用户列表
    public List<User> findAll() throws Exception {
        User user = new User();

        List<User> list = new ArrayList<>();

        Class.forName(JDBCUtils.getDriver());
        conn = JDBCUtils.getConnection();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from user");
        while (rs.next()) {
            int id = rs.getInt(1);
            String username = rs.getString(2);
            int sex = rs.getInt(3);
            int age = rs.getInt(4);
            Date birthday = rs.getDate(5);

            user.setId(id);
            user.setUsername(username);
            user.setSex(sex);
            user.setAge(age);
            user.setBirthday(birthday);

            list.add(user);
        }

        JDBCUtils.close(conn,statement,rs);
        return list;
    }
}
