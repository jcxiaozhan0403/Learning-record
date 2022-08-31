package cn.com.huadi.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;

    private String name;

    private String pwd;

    private String age;

    private Integer sex;

    private String mailbox;

    private String unmber;

    private String autograph;

    private String birthday;

    private String time;

    private Integer role;

}
