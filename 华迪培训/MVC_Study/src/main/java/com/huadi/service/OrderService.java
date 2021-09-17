package com.huadi.service;

import com.huadi.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();

    int insertOrder(Order order);

    int deleteOrder(int id);

    int updateOrder(Order order);
}
