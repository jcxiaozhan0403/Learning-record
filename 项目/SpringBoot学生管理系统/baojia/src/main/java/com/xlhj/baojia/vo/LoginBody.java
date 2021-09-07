package com.xlhj.baojia.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @ClassName LoginBody
 * @Description TODO
 * @Author liucaijing
 * @Date 2020/10/27 21:31
 * @Version 1.0
 */
@Data
public class LoginBody {

    private String username;
    private String password;
}
