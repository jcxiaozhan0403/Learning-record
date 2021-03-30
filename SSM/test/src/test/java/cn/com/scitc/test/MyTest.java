package cn.com.scitc.test;

import cn.com.scitc.test.dao.UserDao;
import cn.com.scitc.test.pojo.User;
import cn.com.scitc.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println(sqlSession);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
