package service;

import com.github.pagehelper.PageInfo;
import pojo.Student;

import java.util.List;

public interface StudentService {
    //增加一个Student
    int addStudent(Student student);

    //根据id删除一个Student
    int deleteStudentById(int id);

    //更新Student
    int updateStudent(Student student);

    //根据id查询,返回一个Student
    Student findStudentById(int id);

    //查询全部Student,返回list集合
    PageInfo findStudentList(int pageNum,int pageSize);

    //根据学号模糊查询学生信息
    PageInfo findByClsContaining(int pageNum,int pageSize,String cls);

    //根据姓名模糊查询学生信息
    PageInfo findByNameContaining(int pageNum,int pageSize,String name);

}
