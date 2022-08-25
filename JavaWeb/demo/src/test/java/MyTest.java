import entity.User;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    @Test
    public void testDeleteById(){
        userMapper.deleteById(1);
    }

    @Test
    public void testDeleteBatchIds(){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        userMapper.deleteBatchIds(integers);
    }

    @Test
    public void testD(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        //
        map.put("age","18");
        map.put("name","John.Cena");
        userMapper.deleteByMap(map);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(3);
        user.setName("John.Cena");
        user.setAge(22);
        user.setEmail("1111@qq.com");
        userMapper.updateById(user);
    }
}
