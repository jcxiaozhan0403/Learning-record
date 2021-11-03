package cn.com.huadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author John.Cena
 * @date 2021/11/2 13:35
 * @Description: 登录控制器
 */
@Controller
public class LoginController {

    /**
     * 跳转到到登录页面
     * @return
     */
    @GetMapping("/login")
    public String toLogin() {
       return "login";
    }

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/checkLogin")
    public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("userType") String userType, HttpServletRequest req) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(userType);
        req.getSession().setAttribute("name","李爽");
        return "redirect:/index";
    }

    /**
     * 注销
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().removeAttribute("name");
        return "redirect:/index";
    }

    /**
     * 跳转到主页
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
