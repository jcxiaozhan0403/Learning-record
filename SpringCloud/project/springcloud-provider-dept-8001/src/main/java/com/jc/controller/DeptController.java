package com.jc.controller;

import com.jc.pojo.Dept;
import com.jc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author John.Cena
 * @date 2023/3/18 16:50
 * @Description:
 */
//提供Restful服务
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService service;
    @PostMapping("/add")
    public boolean addDept(Dept dept){
        boolean b = service.save(dept);
        return b;
    }
    @GetMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = service.getById(id);
        return dept;
    }
    @GetMapping("/list")
    public List<Dept> queryAll(){
        return service.list();
    }
}
