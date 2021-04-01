package cn.com.scitc.test.dao;

import cn.com.scitc.test.mapper.UserMapper;
import cn.com.scitc.test.pojo.User;
import cn.com.scitc.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDao {

    public User findById(Integer id) {
        try(SqlSession session = MybatisUtils.getSqlSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.findById(id);
        }
    }
}
