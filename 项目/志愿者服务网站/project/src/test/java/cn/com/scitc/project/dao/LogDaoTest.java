package cn.com.scitc.project.dao;

import cn.com.scitc.project.model.Log;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

class LogDaoTest {

    @Test
    void findAll() {
        Calendar calendar = Calendar.getInstance();
        LogDao dao = new LogDao();
        List<Log> list = dao.findAll();


        Log log = new Log();
        log.setTime(calendar.getTime());
        log.setLoginid("JohnCena");
        log.setEvent("添加用户");

        dao.insert(log);
    }
}