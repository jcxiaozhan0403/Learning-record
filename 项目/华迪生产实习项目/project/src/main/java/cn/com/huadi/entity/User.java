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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识符")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "唯一用户名")
    private String name;

    @ApiModelProperty(value = "用户密码")
    private String pwd;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "性别(0：女，1：男)")
    private Integer sex;

    @ApiModelProperty(value = "邮箱")
    private String mailbox;

    @ApiModelProperty(value = "手机号码")
    private String unmber;

    @ApiModelProperty(value = "个性签名")
    private String autograph;

    @ApiModelProperty(value = "生日日期")
    private String birthday;

    @ApiModelProperty(value = "注册时间")
    private String time;

    @ApiModelProperty(value = "角色ID")
    private Integer role;


}
