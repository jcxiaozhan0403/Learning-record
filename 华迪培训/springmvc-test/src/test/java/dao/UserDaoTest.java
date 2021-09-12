package dao;

import junit.framework.TestCase;
import org.junit.Test;
import pojo.User;

import java.util.List;

public class UserDaoTest extends TestCase {

    @Test
    public void testFindAll() throws Exception {
        UserDao dao = new UserDao();
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}