package cn.com.huadi.controller;

import cn.com.huadi.entity.Collect;
import cn.com.huadi.entity.Curriculum;
import cn.com.huadi.entity.Role;
import cn.com.huadi.entity.User;
import cn.com.huadi.service.impl.CurriculumService;
import cn.com.huadi.service.impl.RoleService;
import cn.com.huadi.service.impl.UserService;
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
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    CurriculumService curriculumService;
    @Autowired
    CollectController collectController;


    /**
     * 跳转到到登录页面
     * @return
     */
    @GetMapping("/login")
    public String toLogin() {
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
    public String longin(@RequestParam("username") String name, @RequestParam("password") String pwd, @RequestParam("userType") String role, HttpServletRequest request){
        HttpSession session = request.getSession();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = null;
        Role byId = null;
        queryWrapper
                .eq("name",name)
                .eq("pwd",pwd)
                .eq("role",role);
        try {
            user = userService.getOne(queryWrapper);
            byId = roleService.getById(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null){

            if (role.equals("2")) {
                session.setAttribute("user",user);
                session.setAttribute("role",byId);
                return "redirect:/index";
            }else if (role.equals("1")){
                session.setAttribute("user",user);
                session.setAttribute("role",byId);
                return "redirect:/management";
            }

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
        List<Integer> collects = new ArrayList<>();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Curriculum> curriculums = collectController.getCollect(user.getId().toString());
            for (Curriculum curriculum : curriculums) {
                collects.add(curriculum.getId());
            }
            model.addAttribute("collects",collects);
        }
        System.out.println(collects);
        List<Curriculum> list = null;
        try {
            list = curriculumService.list(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        model.addAttribute("courseList",list);
        return "index";
    }


    /**
     * 重定向到主页
     * @return
     */
    @GetMapping("/")
    public String indexRedirect() {

        return "redirect:/index";
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
