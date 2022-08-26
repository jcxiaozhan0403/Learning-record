import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
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
import java.util.function.Predicate;


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

    @Test
    public void testUpdatex(){
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("name","李爽");
        map.put("age","21");
        Object o = queryWrapper.allEq(map);

        List list = userMapper.selectList(queryWrapper);

        for (Object o1 : list) {
            System.out.println(o1);
        }

    }

    @Test
    public void testSelect02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(User.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return "name".equals(tableFieldInfo.getColumn());
            }
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testSelect03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.select(User.class,new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return !"email".equals(tableFieldInfo.getColumn());
            }
        });

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
}
