package cn.com.huadi.controller;

import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import cn.com.huadi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    CurriculumServiceImpl curriculumServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * 跳转到课程管理界面
     * @param model
     * @return
     */
    @RequestMapping("/course/list")
    public String getCurriculumList(Model model){
        List<Curriculum> courseList = curriculumServiceImpl.list(null);

        model.addAttribute("courseList",courseList);
        return "/manager/courseList";
    }

    /**
     * 跳转到课程添加界面
     * @return
     */
    @RequestMapping("/course/add")
    public String courseAdd(){
        return "/manager/courseAdd";
    }

    /**
     * 跳转到课程修改界面
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/course/edit")
    public String getCurriculumById(String id,Model model){
        Curriculum courseInfo = curriculumServiceImpl.getById(id);

        model.addAttribute("courseInfo",courseInfo);
        return "/manager/courseEdit";
    }

    /**
     * 跳转到用户管理界面
     * @param model
     * @return
     */
    @RequestMapping("/user/list")
    public String userList(Model model) {
        List<User> userList = userServiceImpl.list(null);

        model.addAttribute("userList",userList);
        return "/manager/userList";
    }

    /**
     * 跳转到用户添加界面
     * @return
     */
    @RequestMapping("/user/add")
    public String userAdd(){
        return "/manager/userAdd";
    }

    /**
     * 跳转到用户修改界面
     * @param
     * @return
     * @Description
     */
    @RequestMapping("/user/edit")
    public String getUserById(String id, Model model){
        User userInfo = userServiceImpl.getById(id);

        model.addAttribute("userInfo",userInfo);
        return "/manager/userEdit";
    }

}
