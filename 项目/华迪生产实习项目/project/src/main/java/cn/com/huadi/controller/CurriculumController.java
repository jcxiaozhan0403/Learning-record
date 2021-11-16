package cn.com.huadi.controller;


import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.service.impl.CurriculumService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import util.ExcludeEmptyQueryWrapper;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan点
 * @since 2021-11-06
 */
@RestController
public class CurriculumController {
    @Autowired
    CurriculumService curriculumService;

//    3
    @RequestMapping("/getCurriculumList")
    public String getCurriculumList(){
        List<Curriculum> list = null;
        try {
            list = curriculumService.list(null);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return list.toString();
    }

//    4
    @RequestMapping("/addCurriculum")
    public String addCurriculum(Curriculum curriculum){
        boolean b = false;
        try {
            b = curriculumService.save(curriculum);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
    }

//    5
    @RequestMapping("/deleteCurriculum")
    public String deleteCurriculum(String id){
        boolean b = false;
        try {
          b = curriculumService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
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
            return "false";
        }
        return "true";
    }

//    7
    @RequestMapping("selectNameType")
    public String selectNameType(String lecturer,String type){
        ExcludeEmptyQueryWrapper<Curriculum> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper
                    .eq("lecturer",lecturer)
                    .eq("type",type);
        List<Curriculum> list = null;

        try {
            list = curriculumService.list(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }


        return list.toString();
    }
}

