import com.huadi.dao.UserDao;
import com.huadi.pojo.Order;
import com.huadi.service.UserService;
import com.huadi.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

@ContextConfiguration("classpath:springApplication.xml")//构建一个Spring容器
@RunWith(SpringJUnit4ClassRunner.class)
public class TestOrder {

   @Autowired
    private BeanFactory beanFactory; //获取spring容器BeanFactory

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testOrder(){
//        UserService userService = beanFactory.getBean("userService", UserService.class);
        List<Order> orderList = userService.getOrderList();
        for (Order order:orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void addOrder(){
        UserService userService = beanFactory.getBean("userService", UserService.class);
        Order order = new Order();
        order.setOrder_name("aaa");
        order.setOrder_price("200.50");
        order.setOrder_date(Date.valueOf("2020-12-10"));
        userService.addOrder(order);
    }

    @Test
    public void updateOrder(){
        UserService userService = beanFactory.getBean("userService", UserService.class);
        Order order = new Order();
        order.setOrder_id(52);
        order.setOrder_name("bbb");
        order.setOrder_price("1000.50");
        order.setOrder_date(Date.valueOf("2020-12-10"));
        userService.updateOrder(order);
    }
    @Test
    public void deleteOrder(){
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.deleteOrder(52);
    }
}
