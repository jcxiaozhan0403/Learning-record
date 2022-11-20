package com.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @Description: [接收用户信息的对象]
 * @Author: pjqdyd
 * @Version: [v1.0.0]
*/
@Data
public class UserInfoDTO {
    private int id;

    private String nickName;

    private String gender;

    private String language;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private String token;

    private String openId;


    public void from(JSONObject jsonUserInfo){
        this.nickName = jsonUserInfo.getString("nickName");
        this.gender = jsonUserInfo.getString("gender");
        this.language = jsonUserInfo.getString("language");
        this.city = jsonUserInfo.getString("city");
        this.province = jsonUserInfo.getString("province");
        this.country = jsonUserInfo.getString("country");
        this.avatarUrl = jsonUserInfo.getString("avatarUrl");
        this.openId = jsonUserInfo.getString("openId");
    }
}
