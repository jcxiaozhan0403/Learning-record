package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultCode;
import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.Student;
import cn.com.scitc.studentmanager.service.impl.StudentServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    Student student;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    private static final String NUM = "1";
    private static final String NAME = "2";

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultData listStudent(){
        List<Student> list = studentServiceImpl.listStudent();
        return ResultData.ok().data("data",list);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultData addStudent(@RequestBody Student student){
        studentServiceImpl.addStudent(student);
        return ResultData.ok(ResultCode.SUCCESS,"添加成功");
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultData updateStudent(@RequestBody Student student){
        studentServiceImpl.updateStudent(student);
        return ResultData.ok(ResultCode.SUCCESS,"更新成功");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResultData deleteStudent(@PathVariable Integer id){
        studentServiceImpl.deleteStudent(id);
        return ResultData.ok(ResultCode.SUCCESS,"删除成功");
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public ResultData searchStudent(@RequestBody JSONObject reqJson){
        try {
            String select = reqJson.getString("select");
            String content = reqJson.getString("content");
            List<Student> list = new ArrayList<>();
            switch (select){
                case NUM:
                    list = studentServiceImpl.findByNumContaining(content);
                    break;
                case NAME:
                    list = studentServiceImpl.findByNameContaining(content);
                    break;
            }
            return ResultData.ok().data("data",list);
        }catch (Exception e) {
            return ResultData.error(ResultCode.SUCCESS,"查找失败");
        }
    }
}
