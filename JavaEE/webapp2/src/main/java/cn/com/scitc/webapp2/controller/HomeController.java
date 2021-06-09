package cn.com.scitc.webapp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    HttpServletRequest req;

    @GetMapping("")
    public String defaultPage(Integer id) {
        String ID = req.getParameter("id");
        System.out.println("id = " + id);
        System.out.println("ID = " + ID);

        return "default";
    }
}
