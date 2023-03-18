package com.jc.controller;

import com.jc.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author John.Cena
 * @date 2023/3/18 20:20
 * @Description:
 */
@RestController
public class CustomerController {

    //提供服务的地址
    private static final String REST_URL_PREFIX="http://localhost:8001";

    //使用restTemplate模板发送http请求调用远程服务，完成模块通信
    //(url,实体：map,Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
}
