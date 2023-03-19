package com.jc.controller;

import com.jc.pojo.Dept;
import com.jc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    DiscoveryClient client;

    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return service.save(dept);
    }
    @GetMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return service.getById(id);
    }
    @GetMapping("/list")
    public List<Dept> queryAll(){
        return service.list();
    }

    @GetMapping("/discovery")
    public Object discovery(){
        //获得微服务列表清单
        List<String> list = client.getServices();
        System.out.println("client.getServices()==>"+list);
        //得到一个具体的微服务！
        List<ServiceInstance> serviceInstanceList =
                client.getInstances("springcloud-provider-dept");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println(
                    serviceInstance.getServiceId()+"\t"+
                            serviceInstance.getHost()+"\t"+
                            serviceInstance.getPort()+"\t"+
                            serviceInstance.getUri()
            );
        }
        return this.client;
    }
}
