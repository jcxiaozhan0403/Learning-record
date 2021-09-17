package com.huadi.dao.impl;

import com.huadi.DBTest;
import com.huadi.dao.UserDao;
import com.huadi.pojo.Order;
import com.huadi.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private Connection connection =null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public boolean getUser(User user)  {
        connection = DBTest.getConnection();
        try {
            preparedStatement = connection.prepareStatement("select * from t_account where username = ? and password  = ?");
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 客户列表展示
     */
    public List<Order> getOrders(){
        connection = DBTest.getConnection();
        List<Order> orderList = new ArrayList<Order>();
        try {
            preparedStatement = connection.prepareStatement("select * from order2");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Order order = new Order();
                order.setOrder_id(resultSet.getInt("order_id"));
                order.setOrder_name(resultSet.getString("order_name"));
                order.setOrder_price(resultSet.getString("order_price"));
                order.setOrder_date(resultSet.getDate("order_date"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
    /*
    修改页面查询
     */
    public Order getOrder(int orderId)  {
        connection = DBTest.getConnection();
        Order order = new Order();
        try {
            preparedStatement = connection.prepareStatement("select * from order2 where o_id = ?");
            preparedStatement.setInt(1,orderId);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){

                order.setOrder_id(resultSet.getInt("o_id"));
                order.setOrder_name(resultSet.getString("o_name"));
                order.setOrder_price(resultSet.getString("o_price"));
                order.setOrder_date(resultSet.getDate("o_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    /*
    修改执行
     */
    public boolean updateOrder(Order order) {
        connection = DBTest.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update order2 set o_name = ?,o_price=?,o_date = ? where o_id = ?");
            preparedStatement.setString(1,order.getOrder_name());
            preparedStatement.setString(2,order.getOrder_price());
            preparedStatement.setDate(3, order.getOrder_date());
            preparedStatement.setInt(4,order.getOrder_id());
            int number = preparedStatement.executeUpdate();
            if(number>0){
                System.out.println("修改成功！");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     *
     * 删除订单
     */
    public boolean deleteOrder(int orderId){
        connection = DBTest.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from order2 where o_id =?");
            preparedStatement.setInt(1,orderId);
            int num = preparedStatement.executeUpdate();
            if(num > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 新增订单
     */
    public boolean addOrder(Order order){
        connection = DBTest.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into order2 (o_name,o_price,o_date) values (?,?,?)");
            preparedStatement.setString(1,order.getOrder_name());
            preparedStatement.setString(2,order.getOrder_price());
            preparedStatement.setDate(3, order.getOrder_date());
            int num = preparedStatement.executeUpdate();
            if(num >0 ){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
