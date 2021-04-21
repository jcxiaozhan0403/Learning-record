package cn.com.scitc.webapp1901.dao;

import cn.com.scitc.webapp1901.model.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDaoTest {

    @Test
    void findById() {
        ManagerDao managerDao = new ManagerDao();
        Manager manager = managerDao.findById("JohnCena");
        System.out.println(manager.getRealname());
    }
}