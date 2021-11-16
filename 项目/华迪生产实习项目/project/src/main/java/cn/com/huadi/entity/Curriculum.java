package cn.com.huadi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuan点
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Curriculum对象", description="")
public class Curriculum implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "课程名")
    private String name;

    @ApiModelProperty(value = "课程简述")
    private String sketch;

    @ApiModelProperty(value = "课程封面")
    private String cover;

    @ApiModelProperty(value = "课程资源地址")
    private String url;

    @ApiModelProperty(value = "课程讲师")
    private String lecturer;

    @ApiModelProperty(value = "课程类型")
    private String type;


}
