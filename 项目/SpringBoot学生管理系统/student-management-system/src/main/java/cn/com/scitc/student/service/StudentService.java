package cn.com.scitc.student.service;

import cn.com.scitc.student.mapper.StudentMapper;
import cn.com.scitc.student.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    public Student Sel(int id){
        return studentMapper.Sel(id);
    }
}