package cn.com.scitc.studentmanagement.dao;

import cn.com.scitc.studentmanagement.model.Manager;
import com.power.common.util.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManagerDaoTest {
    @Autowired
    private ManagerDao managerDao;

    @Test
    void selectByPrimaryKey() {
        Manager manager = managerDao.selectByPrimaryKey(1);

        System.out.println(manager.toString());

        String u1 = UUIDUtil.getUuid();
        System.out.println(u1);

    }
}