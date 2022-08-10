import entity.Student;
import org.junit.Test;
import service.impl.StudentServiceImpl;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/10 22:19
 * @Description:
 */
public class MyTest {
    StudentServiceImpl studentService = new StudentServiceImpl();

    @Test
    public void addStudent(){
        Student student = new Student(0,"赵小二", "男", 25, "软件19-1");
        studentService.addStudent(student);
    }

    @Test
    public void deleteStudent(){
        studentService.deleteStudent(7);
    }

    @Test
    public void updateStudent(){
        Student student = new Student(5,"赵小二", "女", 18, "软件19-1");
        studentService.updateStudent(student);
    }

    @Test
    public void getStudent(){
        Student student = studentService.getStudent(1);
        System.out.println(student.toString());
    }
}
