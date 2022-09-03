package cn.com.huadi.controller;


import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CurriculumController {
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;

    /**
     * 添加课程
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/addCurriculum")
    public String addCurriculum(Curriculum curriculum){
        curriculumServiceImpl.save(curriculum);
        return "redirect:/course/list";
    }


    /**
     * 删除课程
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/deleteCurriculum")
    public String deleteCurriculum(String id){
        curriculumServiceImpl.removeById(id);
        return "redirect:/course/list";
    }

    /**
     * 修改课程
     * @param curriculum
     * @return
     */
    @RequestMapping("/updateCurriculum")
    public String updateCurriculum(Curriculum curriculum){
        UpdateWrapper<Curriculum> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", curriculum.getId());

        curriculumServiceImpl.update(curriculum, updateWrapper);

        return "redirect:/course/list";
    }

    /**
     * 根据类型或者讲师查询课程
     * @param lecturer
     * @param type
     * @param model
     * @return
     */
    @RequestMapping("selectNameType")
    public String selectNameType(@RequestParam("lecturer") String lecturer, @RequestParam("type") String type, Model model){
        QueryWrapper<Curriculum> queryWrapper = new QueryWrapper<>();

        if(lecturer.equals("null")){
            queryWrapper.eq("type",type);
        }else if(type.equals("null")){
            queryWrapper.eq("lecturer",lecturer);
        }else{
            queryWrapper
                    .eq("lecturer",lecturer)
                    .eq("type",type);
        }

        List<Curriculum> list = curriculumServiceImpl.list(queryWrapper);

        model.addAttribute("courseList",list);
        return "index";
    }

    /**
     * 获取课程讲师数组
     * @return
     */
    @RequestMapping("/getLecturer")
    @ResponseBody
    public List<String> getLecturer(){
        QueryWrapper<Curriculum> queryWrapper = new QueryWrapper<>();
        //select distinct lecturer from curriculum
        queryWrapper.select("distinct lecturer");
        List<Curriculum> list = curriculumServiceImpl.list(queryWrapper);

        List<String> lecturers = new ArrayList<>();
        for (Curriculum curriculum : list) {
            lecturers.add(curriculum.getLecturer());
        }

        return lecturers;
    }

    /**
     * 获取课程类型数组
     * @return
     */
    @RequestMapping("/getType")
    @ResponseBody
    public List<String> getType(){
        QueryWrapper<Curriculum> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct type");
        List<Curriculum> list = curriculumServiceImpl.list(queryWrapper);

        List<String> types = new ArrayList<>();
        for (Curriculum curriculum : list) {
            types.add(curriculum.getType());
        }

        return types;
    }

}

