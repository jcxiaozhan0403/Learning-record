import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.User;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

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
        List<User> list = userService.list();
        for (User user : list) {
            System.out.println(user.toString());
        }

    }


    @Test
    public void testPage(){
        /**
         * new Page<>(current,size);
         * current：页码
         * size：每一页容量
         */
        IPage<User> page = new Page<>(1,2);

        userMapper.selectPage(page, null);
        System.out.println("总页数" + page.getPages());
        System.out.println("当前页的数据:" + page.getRecords());
        System.out.println("总记录数:" + page.getTotal());
        System.out.println("当前页码:" + page.getCurrent());
        System.out.println("页面容量" + page.getSize());
    }


}
