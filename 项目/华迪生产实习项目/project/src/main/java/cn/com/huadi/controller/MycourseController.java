package cn.com.huadi.controller;


import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.Mycourse;
import cn.com.huadi.service.impl.CurriculumService;
import cn.com.huadi.service.impl.MycourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import util.ExcludeEmptyQueryWrapper;

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
@RestController
public class MycourseController {
    @Autowired
    MycourseService mycourseService;
    @Autowired
    CurriculumService curriculumService;
//  8
    @RequestMapping("/getMycourse")
    public String getMycourse(String userId){
        ExcludeEmptyQueryWrapper<Mycourse> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        ArrayList<Curriculum> curricula = null;
        try {
            List<Mycourse> list = mycourseService.list(queryWrapper);

            curricula = new ArrayList<>();

            for (Mycourse mycourse : list) {
                curricula.add(curriculumService.getById(mycourse.getCurriculumId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }


        return curricula.toString();

    }
}

