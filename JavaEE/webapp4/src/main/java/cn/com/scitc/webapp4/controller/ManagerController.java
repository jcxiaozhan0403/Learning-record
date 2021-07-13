package cn.com.scitc.webapp4.controller;

import cn.com.scitc.webapp4.dao.ManagerDao;
import cn.com.scitc.webapp4.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ManagerController {
    @Autowired
    ManagerDao managerDao;

    @RequestMapping("/list")
    public String userList(Model model) {
        List<Manager> list = managerDao.findAll();
        model.addAttribute("list",list);
        return "/user/list";
    }

}