package com.huadi.dao;

import com.huadi.pojo.Order;
import com.huadi.pojo.User;


import java.util.List;

public interface UserDao {
    public boolean getUser(User user);
    public List<Order> getOrders();
    public Order getOrder(int orderId);
    public boolean updateOrder(Order order);
    public boolean deleteOrder(int orderId);
    public boolean addOrder(Order order);

}
