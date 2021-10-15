package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultCode;
import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.Clazz;
import cn.com.scitc.studentmanager.pojo.Student;
import cn.com.scitc.studentmanager.service.impl.ClazzServiceImpl;
import cn.com.scitc.studentmanager.service.impl.StudentServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 学生控制器
 */
@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    Student student;
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Autowired
    ClazzServiceImpl clazzServiceImpl;

    private static final String NUM = "1";
    private static final String NAME = "2";

    /**
     *
     * @return
     * 学生列表
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultData listStudent(){
        List<Student> list = studentServiceImpl.listStudent();
        return ResultData.ok().data("data",list);
    }

    /**
     *
     * @param student
     * @return
     * 添加学生
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultData addStudent(@RequestBody Student student){
        Clazz clazz = clazzServiceImpl.findClazz(student.getClazz());
        // 判断班级人数到达上限没
        if (clazz.getCurrentTotalStudent() >= clazz.getTotalStudent()) {
            return ResultData.ok(ResultCode.ERROR,"班级人数已达上限");
        }else {
            // 添加学生
            studentServiceImpl.addStudent(student);
            // 班级人数+1
            clazz.setCurrentTotalStudent(clazz.getCurrentTotalStudent()+1);
            // 更新班级
            clazzServiceImpl.updateClazz(clazz);
            return ResultData.ok(ResultCode.SUCCESS,"添加成功");
        }
    }

    /**
     *
     * @param student
     * @return
     * 更新学生
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultData updateStudent(@RequestBody Student student){
        studentServiceImpl.updateStudent(student);
        return ResultData.ok(ResultCode.SUCCESS,"更新成功");
    }

    /**
     *
     * @param id
     * @return
     * 删除学生
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResultData deleteStudent(@PathVariable Integer id){
        // 通过学生id查询到学生的班级
        Clazz clazz = clazzServiceImpl.findClazz(studentServiceImpl.findById(id).getClazz());
        // 删除学生
        studentServiceImpl.deleteStudent(id);
        // 班级人数-1
        clazz.setCurrentTotalStudent(clazz.getCurrentTotalStudent()-1);
        // 更新班级
        clazzServiceImpl.updateClazz(clazz);
        return ResultData.ok(ResultCode.SUCCESS,"删除成功");
    }

    /**
     *
     * @param reqJson
     * @return
     * 搜索学生
     */
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