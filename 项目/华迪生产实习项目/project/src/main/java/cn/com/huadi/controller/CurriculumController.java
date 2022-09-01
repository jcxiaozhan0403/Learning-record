package cn.com.huadi.controller;


import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan点
 * @since 2021-11-06
 */
@Controller
public class CurriculumController {
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;

    /**
     * 4
     * 添加课程并且跳转回课程列表
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/addCurriculum")
    public String addCurriculum(Curriculum curriculum){
        boolean b = false;
        try {
            b = curriculumServiceImpl.save(curriculum);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "redirect:/course/list";
    }


    /**
     * 根据课程id删除课程
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/deleteCurriculum")
    public String deleteCurriculum(String id){
        boolean b = false;
        try {
          b = curriculumServiceImpl.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "redirect:/course/list";
    }

//    6
    @RequestMapping("/updateCurriculum")
    public String updateCurriculum(Curriculum curriculum){
        UpdateWrapper<Curriculum> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", curriculum.getId());
        boolean b = false;
        try {
            b = curriculumServiceImpl.update(curriculum, updateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
     * 跳转到课程修改界面
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/course/edit")
    public String getCurriculumById(String id,Model model){
        Curriculum curriculum = null;
        try {
            curriculum = curriculumServiceImpl.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        model.addAttribute("courseInfo",curriculum);
        return "/manager/courseEdit";
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

