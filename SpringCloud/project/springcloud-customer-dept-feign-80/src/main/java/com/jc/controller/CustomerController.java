package com.jc.controller;

import com.jc.service.DeptClineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John.Cena
 * @date 2023/3/18 20:20
 * @Description:
 */
@RestController
public class CustomerController {

    @Autowired
    DeptClineService service;

    @RequestMapping("/get/provide")
    public String getProvider(){
        return service.getProvider();
    }
}
