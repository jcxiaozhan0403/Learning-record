package cn.com.huadi.controller;

import cn.com.huadi.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author John.Cena
 * @date 2022/8/31 19:18
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class CurriculumControllerTest {

    @Autowired
    CurriculumController curriculumController;

    @Test
    void getLecturer() {
        curriculumController.getLecturer();
    }
}