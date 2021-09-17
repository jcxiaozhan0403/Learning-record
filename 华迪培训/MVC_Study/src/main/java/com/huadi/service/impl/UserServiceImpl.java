package com.huadi.service.impl;

import com.huadi.dao.UserDao;
import com.huadi.pojo.Order;
import com.huadi.pojo.User;
import com.huadi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
//    private UserDao userDao = new UserDaoImpl(); //创建UserDao的实现类
     @Autowired
     private UserDao userDao;
    /**
     * 登录验证
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean getLoginUser(User user) {
        return userDao.getUser(user);
    }
    /**
     * 获取订单列表
     */
    public List<Order> getOrderList(){
        return userDao.getOrders();
    }

    /**
     * 获取一个订单
     */
    public Order getOrder(int orderId) {
        return userDao.getOrder(orderId);
    }

    /**
     * 修改订单
     */
    public boolean updateOrder(Order order) {
        boolean result = userDao.updateOrder(order);
        return result;
    }

    /*
    删除订单
     */
    public boolean deleteOrder(int orderId){
        boolean result = userDao.deleteOrder(orderId);
        return result;
    }
    /*
    新增订单
     */
    public  boolean addOrder(Order order){
        boolean result = userDao.addOrder(order);
        return result;
    }
}
