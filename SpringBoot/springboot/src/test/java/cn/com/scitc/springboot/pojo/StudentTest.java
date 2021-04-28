package cn.com.scitc.springboot.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentTest {
    @Autowired
    private Student student;

    @Test
    public void test() {
        System.out.println(student.toString());
    }

}