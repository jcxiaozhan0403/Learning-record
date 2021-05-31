package test.dao;

import org.apache.ibatis.session.SqlSession;
import test.mapper.ManagerMapper;
import test.pojo.Manager;
import test.utils.MybatisUtil;

import java.util.List;

public class MangerDao implements ManagerMapper {

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
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ManagerMapper mapper = session.getMapper(ManagerMapper.class);
            return mapper.selectAll();
        }
    }

    @Override
    public int updateByPrimaryKey(Manager record) {
        return 0;
    }
}
