package com.jc.service;

import com.jc.pojo.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2023/3/21 12:17
 * @Description:
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClineService> {
    @Override
    public DeptClineService create(Throwable cause) {
        return new DeptClineService() {
            @Override
            public String getProvider() {
                return "该服务已被关闭";
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id).setDname("这个id=>"+id+",没有对应的信息,null---@Hystrix~").setDb_source("在Mysql中没有这个数据库");
            }
        };
    }
}
