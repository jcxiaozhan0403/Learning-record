package cn.com.huadi.controller;

import cn.com.huadi.entity.Mycourse;
import cn.com.huadi.service.impl.CurriculumService;
import cn.com.huadi.service.impl.MycourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //    15
    @RequestMapping("/addMyCourse")
    public String addMyCourse(Mycourse mycourse){
        try {
            mycourseService.save(mycourse);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

        return "true";
    }
    //    16
    @RequestMapping("/deleteMyCourse")
    public String deleteMyCourse(Mycourse mycourse){
        ExcludeEmptyQueryWrapper<Mycourse> wrapper = new ExcludeEmptyQueryWrapper<>();
        wrapper.eq("user_id",mycourse.getUserId())
                .eq("curriculum_id",mycourse.getCurriculumId());
        try {
            mycourseService.remove(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
    }
}

