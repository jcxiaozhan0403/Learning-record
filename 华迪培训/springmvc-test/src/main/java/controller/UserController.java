package controller;

import dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;

import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/userList1")
    public String hello(Model model) throws Exception {
        UserDao dao = new UserDao();
        List<User> users = dao.findAll();

        model.addAttribute("data",users);

        return "user";
    }

    @RequestMapping("/userList2")
    public String hello(ModelMap modelMap) throws Exception {
        UserDao dao = new UserDao();
        List<User> users = dao.findAll();

        modelMap.addAttribute("data",users);

        return "user";
    }

    @RequestMapping("/userList3")
    public ModelAndView hello(ModelAndView modelAndView) throws Exception {
        UserDao dao = new UserDao();
        List<User> users = dao.findAll();

        modelAndView.addObject("data",users);
        modelAndView.setViewName("user");

        return modelAndView;
    }
}