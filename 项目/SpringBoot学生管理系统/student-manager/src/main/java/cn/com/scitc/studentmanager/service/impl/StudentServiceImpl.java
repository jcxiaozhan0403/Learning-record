package cn.com.scitc.studentmanager.service.impl;

import cn.com.scitc.studentmanager.mapper.StudentMapper;
import cn.com.scitc.studentmanager.pojo.Student;
import cn.com.scitc.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> listStudent() {
        return studentMapper.listStudent();
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> findByNumContaining(String num) {
        return studentMapper.findByNumContaining(num);
    }

    @Override
    public List<Student> findByNameContaining(String name) {
        return studentMapper.findByNameContaining(name);
    }

}
