package cn.com.scitc.webapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootStrapController {

    @RequestMapping("/bootstrap1")
    public String page1() {

        return "bootstrappage1";
    }

    @RequestMapping("/bootstrap2")
    public String page2() {

        return "bootstrappage2";
    }
}
