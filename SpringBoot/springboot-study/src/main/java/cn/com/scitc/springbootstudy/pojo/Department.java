package cn.com.scitc.springbootstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2021/10/21 21:39
 * @Description: 部门表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Department {
    private Integer id;
    private String departmentName;
}
