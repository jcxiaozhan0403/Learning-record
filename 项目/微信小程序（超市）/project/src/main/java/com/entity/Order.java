package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author John.Cena
 * @date 2022/11/19 12:59
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private String no;
    private Date time;
    private int userId;
}
