package cn.com.huadi.controller;

import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.service.impl.CollectServiceImpl;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import cn.com.huadi.service.impl.MycourseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John.Cena
 * @date 2021/11/7 11:30
 * @Description: 主页控制器
 */
@Controller
public class IndexController {
    @Autowired
    MycourseServiceImpl mycourseServiceImpl;
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;
    @Autowired
    CollectServiceImpl collectServiceImpl;
    @Autowired
    CollectController collectController;
    @Autowired
    MycourseController mycourseController;


    /**
     * 跳转到用户个人中心页面
     * @return
     */
    @RequestMapping("/userCenter")
    public String userCenter() {
        return "userCenter";
    }

    /**
     * 跳转到我的课程页面
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/course")
    public String course(@RequestParam("userId") String userId, Model model) {
        //查询用户的课程列表
        List<Curriculum> courseList = mycourseController.getMycourse(userId);

        model.addAttribute("courseList",courseList);

        //存入用户所有收藏课程的id
        List<Integer> collects = new ArrayList<>();
        List<Curriculum> curricula = collectController.getCollect(userId);
        for (Curriculum curriculum : curricula) {
            collects.add(curriculum.getId());
        }
        model.addAttribute("collects",collects);

        return "course";
    }

    /**
     * 跳转到我的收藏页面
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/favorites")
    public String favorites(String userId, Model model) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        ArrayList<Curriculum> curricula = new ArrayList<>();
        List<Collect> list = collectServiceImpl.list(wrapper);

        for (Collect collect : list) {
            curricula.add(curriculumServiceImpl.getById(collect.getCurriculumId()));
        }

        model.addAttribute("courseList",curricula);

        return "favorites";
    }
}
