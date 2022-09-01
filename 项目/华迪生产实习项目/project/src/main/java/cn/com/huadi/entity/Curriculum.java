package cn.com.huadi.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 课程
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum implements Serializable {

    private Integer id;

    private String name;

    private String sketch;

    private String cover;

    private String url;

    private String lecturer;

    private String type;
}
