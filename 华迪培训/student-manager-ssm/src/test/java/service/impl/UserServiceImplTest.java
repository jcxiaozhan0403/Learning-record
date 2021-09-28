package service.impl;

import junit.framework.TestCase;
import mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;


public class UserServiceImplTest extends TestCase {

    @Test
    public void testFindInfoByUsername() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = context.getBean("UserServiceImpl",UserServiceImpl.class);
        System.out.println(userService.findInfoByUsername("JohnCena"));

    }
}