package cn.com.scitc.student.controller;

import cn.com.scitc.student.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("{loginId}")
    public String findByLoginId(@PathVariable String loginId) {
        return managerService.findByLoginId(loginId).toString();
    }
}
