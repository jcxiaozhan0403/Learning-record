package cn.com.scitc.studentmanager.service;

import cn.com.scitc.studentmanager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentService {
    // 学生列表
    List<Student> listStudent();

    // 添加学生
    void addStudent(Student student);

    // 删除学生
    void deleteStudent(Integer id);

    // 修改学生
    void updateStudent(Student student);

    //根据学号模糊查询学生信息
    List<Student> findByNumContaining(String num);

    //根据姓名模糊查询学生信息
    List<Student> findByNameContaining(String name);
}
