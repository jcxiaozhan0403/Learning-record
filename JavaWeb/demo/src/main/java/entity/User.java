package entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author John.Cena
 * @date 2022/8/25 10:50
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private String email;
    private int flag;
    @Version
    private int version;
}
