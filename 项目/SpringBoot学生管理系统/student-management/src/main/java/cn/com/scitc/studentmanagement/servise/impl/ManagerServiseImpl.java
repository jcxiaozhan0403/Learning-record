package cn.com.scitc.studentmanagement.servise.impl;

import cn.com.scitc.studentmanagement.dao.ManagerDao;
import cn.com.scitc.studentmanagement.model.Manager;
import cn.com.scitc.studentmanagement.servise.ManagerServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiseImpl implements ManagerServise {
    @Autowired
    ManagerDao managerDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return managerDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Manager record) {
        return managerDao.insert(record);
    }

    @Override
    public Manager selectByPrimaryKey(Integer id) {
        return managerDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Manager> selectAll() {
        return managerDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Manager record) {
        return managerDao.updateByPrimaryKey(record);
    }

    @Override
    public Manager selectByUserName(String userName) {
        return managerDao.selectByUserName(userName);
    }
}
