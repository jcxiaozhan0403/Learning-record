package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.Teacher;
import cn.com.scitc.studentmanager.service.impl.TeacherServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 教师控制器
 */
@CrossOrigin
@RestController
@RequestMapping("teacher")
public class TeacherController {

    private static final String NUM = "1";
    private static final String NAME = "2";

    @Autowired
    Teacher teacher;

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    /**
     *
     * @param teacher
     * @return
     * 添加教师
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultData addTeacher(@RequestBody Teacher teacher){
        teacherServiceImpl.addTeacher(teacher);
        return ResultData.ok();
    }

    /**
     *
     * @return
     * 教师列表
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultData listTeacher(){
        List<Teacher> list = teacherServiceImpl.listTeacher();
        return ResultData.ok().data("data",list);
    }

    /**
     *
     * @param teacher
     * @return
     * 更新教师
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultData updateTeacher(@RequestBody Teacher teacher){
        teacherServiceImpl.updateTeacher(teacher);
        return ResultData.ok();
    }

    /**
     *
     * @param id
     * @return
     * 删除教师
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResultData deleteTeacher(@PathVariable Integer id){
        teacherServiceImpl.deleteTeacher(id);
        return ResultData.ok();
    }

    /**
     *
     * @param reqJson
     * @return
     * 搜索教师
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public ResultData searchTeacher(@RequestBody JSONObject reqJson){
        try {
            String select = reqJson.getString("select");
            String content = reqJson.getString("content");
            List<Teacher> list = new ArrayList<>();
            switch (select){
                case NUM:
                    list = teacherServiceImpl.findByNumContaining(content);
                    break;
                case NAME:
                    list = teacherServiceImpl.findByNameContaining(content);
                    break;
            }
            return ResultData.ok().data("data",list);
        }catch (Exception e) {
            return ResultData.error();
        }
    }
}