package cn.com.scitc.student.controller;

import cn.com.scitc.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("getStudent/{id}")
    public String GetStudent(@PathVariable int id){
        return studentService.Sel(id).toString();
    }
}
