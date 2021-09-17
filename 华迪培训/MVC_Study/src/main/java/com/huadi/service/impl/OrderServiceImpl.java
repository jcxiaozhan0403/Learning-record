package com.huadi.service.impl;

import com.huadi.mapper.OrderMapper;
import com.huadi.pojo.Order;
import com.huadi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<Order> getOrderList() {
        return orderMapper.getOrderList();
    }

    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    public int deleteOrder(int id) {
        return orderMapper.deleteOrder(id);
    }

    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }
}
