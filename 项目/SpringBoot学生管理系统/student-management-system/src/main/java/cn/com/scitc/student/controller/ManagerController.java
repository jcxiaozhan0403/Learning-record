package cn.com.scitc.student.controller;

import cn.com.scitc.student.pojo.Manager;
import cn.com.scitc.student.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("{loginId}")
    @ResponseBody
    public Manager findByLoginId(@PathVariable String loginId) {
        return managerService.findByLoginId(loginId);
    }
}
