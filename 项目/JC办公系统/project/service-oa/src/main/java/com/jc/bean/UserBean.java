package com.jc.bean;

import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2023/4/12 17:04
 * @Description:
 */
@Component
public class UserBean {

    public String getUsername(int id) {
        if(id == 1) {
            return "zhangsan";
        }
        if(id == 2) {
            return "lisi";
        }
        return "admin";
    }
}
