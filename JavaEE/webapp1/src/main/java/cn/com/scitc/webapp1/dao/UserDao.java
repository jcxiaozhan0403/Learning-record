package cn.com.scitc.webapp1.dao;

import cn.com.scitc.webapp1.pojo.User;
import cn.com.scitc.webapp1.utils.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    SqlHelper sqlHelper;

    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user";
        ArrayList<Object[]> res = sqlHelper.executeQuery(sql,null);
        for(Object[] obj : res) {
            User user = new User();
            user.setUserName(obj[1].toString());
            user.setName(obj[2].toString());
            user.setMobile(obj[3].toString());
            userList.add(user);
        }

        return userList;
    }

    public User findById(int id) {
        User user = new User();
        String sql = "select * from user where id = ?";
        String para[] = {String.valueOf(id)};
        ArrayList<Object[]> res = sqlHelper.executeQuery(sql,para);
        for(Object[] obj : res) {
            user.setUserName(obj[1].toString());
            user.setName(obj[2].toString());
            user.setMobile(obj[3].toString());
        }

        return user;
    }

    public void insert(String userName,String name,String mobile) {
        String sql = "insert into user(userName,name,mobile) values(?,?,?);";
        String para[] = {userName,name,mobile};
        sqlHelper.executeUpdate(sql,para);
    }

    public void update(String userName,String name,String mobile) {
        String sql = "update user set name = ?,mobile = ? where userName=?";
        String para[] = {name,mobile,userName};
        sqlHelper.executeUpdate(sql,para);
    }
}
