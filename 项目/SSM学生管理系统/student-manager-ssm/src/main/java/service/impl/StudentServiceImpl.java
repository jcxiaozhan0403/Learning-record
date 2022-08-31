package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //调用dao层的操作，设置一个set接口，方便Spring管理
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public int deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public Student findStudentById(int id) {
        return studentMapper.findStudentById(id);
    }

    public PageInfo findStudentList(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.findStudentList();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo findByClsContaining(int pageNum,int pageSize,String cls) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.findByClsContaining(cls);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo findByNameContaining(int pageNum,int pageSize,String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.findByNameContaining(name);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}