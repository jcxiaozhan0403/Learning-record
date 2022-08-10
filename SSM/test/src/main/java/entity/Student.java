package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author John.Cena
 * @date 2022/8/10 22:10
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int stuId;
    private String stuName;
    private String stuSex;
    private int stuAge;
    private String stuCls;


}
