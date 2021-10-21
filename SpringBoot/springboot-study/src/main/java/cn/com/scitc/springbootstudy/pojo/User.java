package cn.com.scitc.springbootstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author John.Cena
 * @date 2021/10/21 14:58
 * @Description: 用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "user1")
@Validated
public class User {
    @Email()
    private String name;
    private int age;
    private Date birthday;
    private String[] likes;
    private Map<String,Object> maps;
    private List<Object> lists;
}
