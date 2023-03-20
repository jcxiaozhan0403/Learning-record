package com.jc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John.Cena
 * @date 2023/3/20 16:31
 * @Description:
 */
@RestController
public class RibbonController {
    @RequestMapping("/ribbon/test")
    public String ribbonTest(){
        return "8001为你提供服务";
    }
}
