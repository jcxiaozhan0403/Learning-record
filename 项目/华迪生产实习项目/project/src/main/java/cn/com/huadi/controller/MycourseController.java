package cn.com.huadi.controller;

import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.Mycourse;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import cn.com.huadi.service.impl.MycourseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MycourseController {
    @Autowired
    MycourseServiceImpl mycourseServiceImpl;
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;

    /**
     * 根据用户id查询课程列表
     * @param userId
     * @return
     */
    @RequestMapping("/getMycourse")
    public List<Curriculum> getMycourse(String userId){
        QueryWrapper<Mycourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct curriculum_id");
        queryWrapper.eq("user_id",userId);
        List<Mycourse> list = mycourseServiceImpl.list(queryWrapper);

        List<Curriculum> curricula = new ArrayList<>();

        for (Mycourse mycourse : list) {
            curricula.add(curriculumServiceImpl.getById(mycourse.getCurriculumId()));
        }

        return curricula;
    }

    /**
     * 添加到我的课程
     * @param mycourse
     * @return
     */
    @RequestMapping("/addMyCourse")
    public String addMyCourse(Mycourse mycourse){
        mycourseServiceImpl.save(mycourse);
        return "true";
    }

    /**
     * 从我的课程移除
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

