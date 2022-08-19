package cn.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author John.Cena
 * @date 2022/8/19 7:58
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int stuId;
    private String stuName;
    private String stuSex;
    private int stuAge;
    private String stuCls;
}
