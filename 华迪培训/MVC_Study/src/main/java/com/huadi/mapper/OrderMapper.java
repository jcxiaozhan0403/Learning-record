package com.huadi.mapper;

import com.huadi.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderMapper {
    List<Order> getOrderList();

    int insertOrder(Order order);

    int deleteOrder(int id);

    int updateOrder(Order order);
}
