package com.jc.controller;

import com.jc.pojo.Dept;
import com.jc.service.DeptClineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/get/{id}")//根据id查询
    Dept queryById(@PathVariable("id") Long id){
        return service.queryById(id);
    }
}
