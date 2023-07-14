package com.cdtu.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class SysController {

    /**
     * 跳转到菜单管理页
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }


    /**
     * 跳转到dTree
     */
    @RequestMapping("dTreeDemo")
    public String todTreeDemo(){
        return "system/menu/dTreeDemo";
    }

    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/MenuLeft";
    }



    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/MenuRight";
    }

    @RequestMapping("toRoleManager")
    public String toRoleManager(){
        return "system/role/roleManager";
    }

    @RequestMapping("toUserManager")
    public String toUserManager(){
        return "system/user/userManager";
    }


    //跳转到日志管理页
    @RequestMapping("toLogInfoManager")
    public String toLogInfoManager(){
        return "system/logInfo/logInfoManager";
    }
}
