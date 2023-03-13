package mapper;

import com.github.pagehelper.PageInfo;
import pojo.Student;

import java.util.List;

public interface StudentMapper {
    //增加一个Student
    int addStudent(Student student);

    //根据id删除一个Student
    int deleteStudentById(int id);

    //更新Student
    int updateStudent(Student student);

    //根据id查询,返回一个Student
    Student findStudentById(int id);

    //查询全部Student,返回list集合
    List<Student> findStudentList();

    //根据学号模糊查询学生信息
    List<Student> findByClsContaining(String cls);

    //根据姓名模糊查询学生信息
    List<Student> findByNameContaining(String name);
}
