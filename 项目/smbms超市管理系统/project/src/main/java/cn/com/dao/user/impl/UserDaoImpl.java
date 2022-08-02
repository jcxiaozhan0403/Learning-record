package cn.com.dao.user.impl;

import cn.com.dao.user.UserDao;
import cn.com.pojo.User;
import cn.com.util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author John.Cena
 * @date 2022/8/2 16:53
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    public User getUser(String userCode) {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from smbms_user where `userCode` = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userCode);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setCreationDate(resultSet.getTimestamp("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getDate("modifyDate"));
            }
            JDBCUtils.close(connection,preparedStatement,resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
