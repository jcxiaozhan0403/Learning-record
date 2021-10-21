package cn.com.scitc.springbootstudy;

import cn.com.scitc.springbootstudy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootStudyApplicationTests {

    @Autowired
    public User user;

    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
