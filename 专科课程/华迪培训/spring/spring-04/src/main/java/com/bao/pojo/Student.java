package com.bao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student {
    private Integer stuId;
    private String stuName;
    private String stuSex;
    private String stuAge;
    private String stuCls;
}
