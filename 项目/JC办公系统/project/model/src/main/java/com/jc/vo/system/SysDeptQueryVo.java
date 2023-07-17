package com.jc.vo.system;

import lombok.Data;

import java.io.Serializable;

/**
 * @author John.Cena
 * @date 2023/7/17 14:22
 * @Description:
 */
@Data
public class SysDeptQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String leader;
    private String name;
    private String phone;

}
