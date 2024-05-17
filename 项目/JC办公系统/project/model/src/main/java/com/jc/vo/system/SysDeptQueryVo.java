package com.jc.vo.system;

import lombok.Data;

import java.io.Serializable;

/**
 * @author John.Cena
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
