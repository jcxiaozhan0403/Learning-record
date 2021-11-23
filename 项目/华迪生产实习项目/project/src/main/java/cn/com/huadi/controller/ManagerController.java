package cn.com.huadi.controller;

import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.CurriculumService;
import cn.com.huadi.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author John.Cena
 * @date 2021/11/4 14:41
 * @Description: 管理界面控制器
 */
@Controller
public class ManagerController {
    @Autowired
    CurriculumService curriculumService;
    @Autowired
    UserService userService;


    @RequestMapping("/course/list")
    public String getCurriculumList(Model model){
        List<Curriculum> list = null;
        try {
            list = curriculumService.list(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        model.addAttribute("courseList",list);
        return "/manager/courseList";
    }

    @GetMapping("/user/list")
    public String userList(Model model) {
        List<User> list = null;
        try {
            list = userService.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        model.addAttribute("userList",list);
        return "/manager/userList";
    }

    @GetMapping("/user/add")
    public String userAdd(){
        return "/manager/userAdd";
    }

    @GetMapping("/course/add")
    public String courseAdd(){
        return "/manager/courseAdd";
    }

}
