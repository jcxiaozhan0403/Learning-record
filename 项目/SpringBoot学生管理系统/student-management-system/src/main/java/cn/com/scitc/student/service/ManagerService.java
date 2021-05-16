package cn.com.scitc.student.service;

import cn.com.scitc.student.mapper.ManagerMapper;
import cn.com.scitc.student.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    ManagerMapper managerMapper;
    public Manager findByLoginId(String loginId) {
        return managerMapper.findByLoginId(loginId);
    }
}
