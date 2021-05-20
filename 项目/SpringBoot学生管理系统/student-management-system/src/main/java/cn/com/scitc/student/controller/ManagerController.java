package cn.com.scitc.student.controller;

import cn.com.scitc.student.pojo.Manager;
import cn.com.scitc.student.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("{loginId}")
    @ResponseBody
    public Manager findByLoginId(@PathVariable String loginId,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("manager",managerService.findByLoginId(loginId));
        return managerService.findByLoginId(loginId);
    }
}
