package com.cdtu.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
@Controller
@RequestMapping("desk")
public class DeskController {

    @RequestMapping("toDeskManager")
    public String toDeskManager(){
        return "system/main/deskManager";
    }
}
