package cn.com.scitc.project.dao;


import cn.com.scitc.project.mapper.ManagerMapper;
import cn.com.scitc.project.model.Manager;
import cn.com.scitc.project.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ManagerDao implements ManagerMapper {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            Integer result = mapper.deleteByPrimaryKey(id);
            session.commit();
            return result;
        }
    }

    @Override
    public int insert(Manager manager) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            Integer result = mapper.insert(manager);
            session.commit();
            return result;
        }
    }

    @Override
    public Manager selectByPrimaryKey(Integer id) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            return mapper.selectByPrimaryKey(id);
        }
    }

    @Override
    public int updateByPrimaryKey(Manager manager) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            int result = mapper.updateByPrimaryKey(manager);
            session.commit();
            return result;
        }
    }

    @Override
    public Manager findByLoginId(String loginId) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            return mapper.findByLoginId(loginId);
        }
    }

    @Override
    public Manager findById(Integer id) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Manager> selectAll() {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            return mapper.selectAll();
        }
    }

    @Override
    public int reset() {
        return 0;
    }
}
