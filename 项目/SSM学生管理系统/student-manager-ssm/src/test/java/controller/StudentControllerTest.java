package controller;

import com.github.pagehelper.PageInfo;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;
import service.impl.StudentServiceImpl;

import java.util.List;

public class StudentControllerTest extends TestCase {

    public void testList() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl studentService = context.getBean("StudentServiceImpl", StudentServiceImpl.class);

        PageInfo list = studentService.findStudentList(1,3);
        System.out.println(list.getList());
    }

    public void testSearch() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = context.getBean("studentController", StudentController.class);

//        List<Student> list = studentController.search();
//        for (Student student : list) {
//            System.out.println(student.toString());
//        }

    }
}