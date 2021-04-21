package cn.com.scitc.webapp1901.dao;

import cn.com.scitc.webapp1901.mapper.SigninMapper;
import cn.com.scitc.webapp1901.model.Signin;

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
