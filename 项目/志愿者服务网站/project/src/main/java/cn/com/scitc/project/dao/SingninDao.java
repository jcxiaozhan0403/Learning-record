package cn.com.scitc.project.dao;



import cn.com.scitc.project.mapper.SigninMapper;
import cn.com.scitc.project.model.Signin;

import java.util.List;

public class SingninDao implements SigninMapper {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Signin record) {
        return 0;
    }

    @Override
    public Signin selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Signin> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Signin record) {
        return 0;
    }
}
