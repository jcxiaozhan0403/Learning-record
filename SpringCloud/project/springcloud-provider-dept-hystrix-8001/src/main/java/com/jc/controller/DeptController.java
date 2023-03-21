package com.jc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jc.pojo.Dept;
import com.jc.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /**
     * 根据id查询部门信息
     * HystrixCommand：一旦调用该方法发生异常后，就执行hystrixGet方法中的代码
     * @Param:id
     */
    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/get/{id}")//根据id查询
    public Dept queryById(@PathVariable("id") Long id){
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.eq("deptno",id);
        Dept dept = service.getOne(wrapper);
        if(dept==null){
            throw new RuntimeException("该id："+id+"没有对应的的信息");
        }
        return dept;
    }
    /**
     * 根据id查询备选方案（熔断）
     * @Param:id
     * @return
     * */
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("这个id=>"+id+",没有对应的信息,null---@Hystrix~").setDb_source("在Mysql中没有这个数据库");
    }
}
