package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author John.Cena
 * @date 2022/11/19 12:58
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private String picture;
    private int number;
}
