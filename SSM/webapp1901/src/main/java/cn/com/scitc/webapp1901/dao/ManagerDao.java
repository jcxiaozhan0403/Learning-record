package cn.com.scitc.webapp1901.dao;

import cn.com.scitc.webapp1901.mapper.ManagerMapper;
import cn.com.scitc.webapp1901.model.Manager;
import cn.com.scitc.webapp1901.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ManagerDao implements ManagerMapper {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Manager record) {
        return 0;
    }

    @Override
    public Manager selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Manager> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Manager record) {
        return 0;
    }

    @Override
    public Manager findById(String loginId) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            return mapper.findById(loginId);
        }
    }
}
