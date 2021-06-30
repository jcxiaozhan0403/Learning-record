package cn.com.scitc.project.dao;

import cn.com.scitc.project.mapper.LogMapper;
import cn.com.scitc.project.model.Log;
import cn.com.scitc.project.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LogDao implements LogMapper {
    @Override
    public List<Log> findAll() {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            LogMapper mapper = session.getMapper(LogMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public int insert(Log log) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            LogMapper mapper = session.getMapper(LogMapper.class);
            Integer result = mapper.insert(log);
            session.commit();
            return result;
        }
    }

    @Override
    public int reset() {
        return 0;
    }
}
