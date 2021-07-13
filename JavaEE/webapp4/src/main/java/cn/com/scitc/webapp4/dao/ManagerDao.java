package cn.com.scitc.webapp4.dao;

import cn.com.scitc.webapp4.mapper.ManagerMapper;
import cn.com.scitc.webapp4.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDao {
    @Autowired
    private ManagerMapper managerMapper;

    public List<Manager> findAll() {
        return managerMapper.selectAll();
    }
}
