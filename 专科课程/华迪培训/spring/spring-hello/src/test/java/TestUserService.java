import dao.impl.UserDaoImpl2;
import org.junit.Test;
import com.service.impl.UserServiceImpl;

public class TestUserService {

    @Test
    public void showTest(){
        UserServiceImpl userService = new UserServiceImpl();
        String show = userService.show();
        System.out.println(show);
    }

    @Test
    public void showTest2(){
        UserServiceImpl userService = new UserServiceImpl();
//        userService.setUserDao(new UserDaoImpl1());
        userService.setUserDao(new UserDaoImpl2());
        String show = userService.show();
        System.out.println(show);
    }

}
