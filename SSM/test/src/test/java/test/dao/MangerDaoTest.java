package test.dao;

import org.junit.jupiter.api.Test;
import test.pojo.Manager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MangerDaoTest {

    @Test
    void selectAll() {
        MangerDao mangerDao = new MangerDao();
        List<Manager> managers = mangerDao.selectAll();
        System.out.println(managers);
    }
}