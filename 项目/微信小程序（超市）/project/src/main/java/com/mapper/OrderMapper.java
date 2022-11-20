package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @author John.Cena
 * @date 2022/11/19 13:06
 * @Description:
 */
@Repository // 表示持久层
public interface OrderMapper extends BaseMapper<Order> {
}
