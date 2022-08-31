package cn.com.huadi.controller;


import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.service.impl.CurriculumService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    CurriculumService curriculumService;

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
            b = curriculumService.save(curriculum);
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
          b = curriculumService.removeById(id);
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
            b = curriculumService.update(curriculum, updateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "redirect:/course/list";
    }

//    7
    @RequestMapping("selectNameType")
    public String selectNameType(String lecturer, String type, Model model){
        ExcludeEmptyQueryWrapper<Curriculum> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper
                    .eq("lecturer",lecturer)
                    .eq("type",type);
        List<Curriculum> list = null;

        try {
            list = curriculumService.list(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

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
            curriculum = curriculumService.getById(id);
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
        ExcludeEmptyQueryWrapper<Curriculum> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.select("distinct lecturer");
        List<Curriculum> list = curriculumService.list(queryWrapper);
        ArrayList<String> strings = new ArrayList<>();
        try {
            for (Curriculum curriculum : list) {
                strings.add(curriculum.getLecturer());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

    /**
     * 获取课程类型数组
     * @return
     */
    @RequestMapping("/getType")
    @ResponseBody
    public List<String> getType(){
        ExcludeEmptyQueryWrapper<Curriculum> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.select("distinct type");
        List<Curriculum> list = curriculumService.list(queryWrapper);
        ArrayList<String> strings = new ArrayList<>();
        try {
            for (Curriculum curriculum : list) {
                strings.add(curriculum.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return strings;
    }

}

