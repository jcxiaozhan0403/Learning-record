import cn.com.entity.Student;
import cn.com.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        StudentMapper StudentMapperImpl = context.getBean("studentMapperImpl2",StudentMapper.class);

        List<Student> students = StudentMapperImpl.studentList();
        for (Student student : students){
            System.out.println(student.toString());
        }
    }
}
