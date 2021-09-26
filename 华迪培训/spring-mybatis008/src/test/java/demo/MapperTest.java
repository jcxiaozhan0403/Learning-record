package demo;

import com.bao.mapper.UserMapper;
import com.bao.mapper.impl.UserMapperImpl;
import com.bao.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperTest {
    @Test
    public void t1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        List<User> users = userMapperImpl.selectAllUser();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
