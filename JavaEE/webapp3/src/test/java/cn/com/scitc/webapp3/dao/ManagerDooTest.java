package cn.com.scitc.webapp3.dao;

import cn.com.scitc.webapp3.pojo.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerDooTest {
    @Autowired
    private ManagerDoo managerDoo;


    @Test
    public void test() {
        Optional<Manager> obj = managerDoo.findById(1);
        Manager manager = obj.get();
        System.out.println(manager.getLoginCount());
    }
}