package com.cheng.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Integer id;
  private String userCode;
  private String userName;
  private String userPassword;
  private Integer gender;
  private Date birthday;
  private String phone;
  private String address;
  private Integer userRole;
  private Integer createdBy;
  private Date creationDate;
  private Integer modifyBy;
  private Date modifyDate;
  private String userRoleName;    //用户角色名称
}