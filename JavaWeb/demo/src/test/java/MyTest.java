import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import entity.User;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/25 11:06
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")	//注解寻找配置文件
public class MyTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testDeleteById(){
        //删除单个值
        userMapper.deleteById(1);
    }

    @Test//通过id查询多个用户
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        users.forEach(System.out::println);
        //System.out.println(users);
    }

    @Test
    public void test(){
        User user1 = userMapper.selectById(1l);
        user1.setAge(1);
        user1.setName("线程一");

        //模拟线程插队
        User user2 = userMapper.selectById(1l);
        user2.setAge(100);
        user2.setName("线程二");

        userMapper.updateById(user2);
        userMapper.updateById(user1);
    }
}
