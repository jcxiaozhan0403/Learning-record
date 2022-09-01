package cn.com.huadi.controller;

import cn.com.huadi.entity.Mycourse;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import cn.com.huadi.service.impl.MycourseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MycourseController {
    @Autowired
    MycourseServiceImpl mycourseServiceImpl;
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;

    /**
     * 收藏课程
     * @param mycourse
     * @return
     */
    @RequestMapping("/addMyCourse")
    public String addMyCourse(Mycourse mycourse){
        mycourseServiceImpl.save(mycourse);
        return "true";
    }

    /**
     * 取消收藏课程
     * @param mycourse
     * @return
     */
    @RequestMapping("/deleteMyCourse")
    public String deleteMyCourse(Mycourse mycourse){
        QueryWrapper<Mycourse> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",mycourse.getUserId())
                .eq("curriculum_id",mycourse.getCurriculumId());

        mycourseServiceImpl.remove(wrapper);
        return "true";
    }
}

