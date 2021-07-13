package cn.com.scitc.webapp4.dao;

import cn.com.scitc.webapp4.pojo.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class ManagerDaoTest {
    @Autowired
    private ManagerDao managerDao;


    @Test
    void selectAll() {
        List<Manager> managers = managerDao.findAll();
        for (Manager manager : managers) {
            System.out.println(manager.toString());
        }

    }
}