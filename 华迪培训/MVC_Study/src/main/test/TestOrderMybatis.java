import com.huadi.pojo.Order;
import com.huadi.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml", "classpath:springApplication.xml"})//构建一个Spring容器
@RunWith(SpringJUnit4ClassRunner.class)
public class TestOrderMybatis {

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void testOrder(){
        List<Order> orderList = orderService.getOrderList();
        for (Order order:orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void addOrder(){

    }

    @Test
    public void updateOrder(){

    }
    @Test
    public void deleteOrder(){

    }
}
