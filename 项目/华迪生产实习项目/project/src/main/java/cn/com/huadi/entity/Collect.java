package cn.com.huadi.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 我的收藏
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer curriculumId;
}
