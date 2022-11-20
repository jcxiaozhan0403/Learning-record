package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author John.Cena
 * @date 2022/11/19 12:58
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String openId;
    private String avatarUrl;
    private String nickName;
}
