package com.huadi.service;


import com.huadi.pojo.Order;
import com.huadi.pojo.User;

import java.util.List;


public interface UserService {

    public boolean getLoginUser(User user) ;
    public List<Order> getOrderList();
    public Order getOrder(int orderId);
    public boolean updateOrder(Order order);
    public boolean deleteOrder(int orderId);
    public  boolean addOrder(Order order);

}
