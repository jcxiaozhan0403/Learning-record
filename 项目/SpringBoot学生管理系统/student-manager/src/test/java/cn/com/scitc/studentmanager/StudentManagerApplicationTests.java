package cn.com.scitc.studentmanager;

import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.controller.ClazzController;
import cn.com.scitc.studentmanager.mapper.ClazzMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentManagerApplicationTests {
    @Autowired
    ClazzController controller;

    @Autowired
    ClazzMapper clazzMapper;

    @Test
    void contextLoads() {
       List<String> list = clazzMapper.getAllCalzz("大一");

       for (String str : list) {
           System.out.println(str);
       }

    }

}
