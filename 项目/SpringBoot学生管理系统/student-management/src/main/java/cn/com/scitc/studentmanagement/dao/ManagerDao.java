package cn.com.scitc.studentmanagement.dao;

import cn.com.scitc.studentmanagement.mapper.ManagerMapper;
import cn.com.scitc.studentmanagement.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDao implements ManagerMapper {
    @Autowired
    private ManagerMapper managerMapper;

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
        return managerMapper.selectByPrimaryKey(id);
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
    public Manager selectByUserName(String userName) {
        return managerMapper.selectByUserName(userName);
    }
}
