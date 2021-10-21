package cn.com.scitc.studentmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 学生实体
 * 编号、姓名、年龄、性别、学号、年级、班级、地址
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
    private String num;
    private String grade;
    private String clazz;
    private String address;
}
