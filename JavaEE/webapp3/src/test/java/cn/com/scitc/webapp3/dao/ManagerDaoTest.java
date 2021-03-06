package cn.com.scitc.webapp3.dao;

import cn.com.scitc.webapp3.pojo.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ManagerDaoTest {
    @Autowired
    private ManagerDao managerDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void findById() {
        Optional<Manager> obj = managerDao.findById(1);
        Manager manager = obj.get();
        logger.info(manager.getLoginId());
        Assertions.assertEquals("JohnCena",manager.getLoginId());
    }

    @Test
    public void findAll() {
        Iterable<Manager> list = managerDao.findAll();
        for (Manager manager : list) {
            System.out.println(manager.getRealName());
        }
    }

    @Test
    public void update() {
        Manager manager = new Manager();
        manager.setId(2);
        manager.setLoginId("Admin");
        manager.setRealName("李四");
        manager.setPwd("123456");
        manager.setLoginCount(88);
        manager.setLastLoginDt(null);

       managerDao.save(manager);
        Manager manager1 = managerDao.findById(2).get();
//        System.out.println(manager1.getRealName());
        logger.info(manager1.getRealName());
    }

    @Test
    public void delete() {
        Manager manager = new Manager();
        manager.setId(2);

        managerDao.delete(manager);
    }

    @Test
    public void insert() {
        Manager manager = new Manager();
        manager.setId(2);
        manager.setLoginId("Admin");
        manager.setRealName("李四");
        manager.setPwd("123456");
        manager.setLoginCount(88);
        manager.setLastLoginDt(null);
        managerDao.save(manager);
    }

    @Test
    public void deleteByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);

        managerDao.deleteAllById(ids);
    }

    @Test
    public void findByLoginId() {
        Manager manager = managerDao.findByLoginId("JohnCena");
        Assertions.assertEquals("李爽",manager.getRealName());
    }
}