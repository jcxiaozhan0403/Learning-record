package cn.com.huadi.controller;

import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.Role;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.CurriculumServiceImpl;
import cn.com.huadi.service.impl.RoleServiceImpl;
import cn.com.huadi.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author John.Cena
 * @date 2021/11/2 13:35
 * @Description: 登录控制器
 */
@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    RoleServiceImpl roleServiceImpl;
    @Autowired
    CurriculumServiceImpl curriculumServiceImpl;
    @Autowired
    CollectController collectController;


    /**
     * 跳转到到登录页面
     * @return
     */
    @GetMapping(value = {"/login","/"})
    public String toLoginPage() {
       return "login";
    }

    /**
     * 验证登录
     * @param name
     * @param pwd
     * @param role
     * @param request
     * @return
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(@RequestParam("username") String name, @RequestParam("password") String pwd, @RequestParam("userType") String role, HttpServletRequest request){
        HttpSession session = request.getSession();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = null;
        Role byId = null;
        queryWrapper
                .eq("name",name)
                .eq("pwd",pwd)
                .eq("role",role);
        try {
            user = userServiceImpl.getOne(queryWrapper);
            byId = roleServiceImpl.getById(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null){
            if (role.equals("2")) {
                //session中存入用户信息和用户权限
                session.setAttribute("user",user);
                session.setAttribute("role",byId);
                //普通用户管理界面
                return "redirect:/index";
            }else if (role.equals("1")){
                session.setAttribute("user",user);
                session.setAttribute("role",byId);
                //管理员管理界面
                return "redirect:/management";
            }
        //验证失败跳转登录页面
        }else {
            return "/login";
        }
        return "/login";
    }

    /**
     * 用户注销
     * @param req
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        //清除session中的用户信息和权限信息
        if ( user != null){
            req.getSession().removeAttribute("user");
            req.getSession().removeAttribute("role");
        }else {
            return null;
        }
        return "redirect:/index";
    }

    /**
     * 跳转到主页
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            //查询用户的收藏课程列表
            List<Integer> collects = new ArrayList<>();
            List<Curriculum> curricula = collectController.getCollect(user.getId().toString());
            for (Curriculum curriculum : curricula) {
                collects.add(curriculum.getId());
            }

            //存入用户所有收藏课程的id
            model.addAttribute("collects",collects);
        }else {
            //没有用户信息，跳转到登录页面
            return "redirect:/login";
        }

        //查询所有课程列表
        List<Curriculum> courseList = curriculumServiceImpl.list(null);
        model.addAttribute("courseList",courseList);

        return "index";
    }

    /**
     * 跳转到后台管理界面
     * @return
     */
    @GetMapping("/management")
    public String management() {
        return "/manager/index";
    }
}
