package cn.com.scitc.webapp1901.dao;

import cn.com.scitc.webapp1901.pojo.Student;
import org.junit.jupiter.api.Test;

class StudentDaoTest {

    @Test
    void findById() {
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.findById(1);
        System.out.println(student.getName());
    }
}