package com.cheng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
  private Integer id;
  private String roleCode;
  private String roleName;
  private Integer createdBy;
  private java.sql.Timestamp creationDate;
  private Integer modifyBy;
  private java.sql.Timestamp modifyDate;
}
