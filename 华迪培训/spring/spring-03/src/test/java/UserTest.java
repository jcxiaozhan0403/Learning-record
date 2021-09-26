import com.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
  @Test
  public void test(){
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userService = (UserService) context.getBean("userServiceImpl");
    userService.add();
   }
}
