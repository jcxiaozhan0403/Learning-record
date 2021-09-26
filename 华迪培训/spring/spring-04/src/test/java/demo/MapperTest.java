package demo;

import com.bao.mapper.UserMapper;
import com.bao.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperTest {
    @Test
    public void t1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        List<Student> students = userMapperImpl.selectAllUser();

        for (Student student : students) {
            System.out.println(student);
        }
    }
}