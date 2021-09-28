package controller;

import com.github.pagehelper.PageInfo;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.StudentServiceImpl;

public class StudentControllerTest extends TestCase {

    public void testList() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl studentService = context.getBean("StudentServiceImpl", StudentServiceImpl.class);

        PageInfo list = studentService.findStudentList(2,3);
        System.out.println(list);
    }
}