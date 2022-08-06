package cn.com.dao.user.impl;

import cn.com.dao.user.BillDao;
import cn.com.pojo.Bill;
import cn.com.pojo.Pro;
import cn.com.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/4 8:43
 * @Description:
 */
public class BillDaoImpl implements BillDao {

    public List<Bill> getBillList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Bill> list = new ArrayList<Bill>();

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from smbms_bill";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Bill bill = new Bill();
                bill.setId(resultSet.getInt(1));
                bill.setBillCode(resultSet.getString(2));
                bill.setProductName(resultSet.getString(3));
                bill.setProductDesc(resultSet.getString(4));
                bill.setProductUnit(resultSet.getString(5));
                bill.setProductCount(resultSet.getBigDecimal(6));
                bill.setTotalPrice(resultSet.getBigDecimal(7));
                bill.setIsPayment(resultSet.getInt(8));
                bill.setCreatedBy(resultSet.getInt(9));
                bill.setCreationDate(resultSet.getDate(10));
                bill.setModifyBy(resultSet.getInt(11));
                bill.setModifyDate(resultSet.getDate(12));
                bill.setProviderId(resultSet.getInt(13));

                list.add(bill);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public List<Pro> getProList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Pro> list = new ArrayList<Pro>();

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from smbms_provider";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Pro pro = new Pro();
                pro.setId(resultSet.getInt(1));
                pro.setProCode(resultSet.getString(2));
                pro.setProName(resultSet.getString(3));
                pro.setProDesc(resultSet.getString(4));
                pro.setProContact(resultSet.getString(5));
                pro.setProPhone(resultSet.getString(6));
                pro.setProAddress(resultSet.getString(7));
                pro.setProFax(resultSet.getString(8));
                pro.setCreatedBy(resultSet.getInt(9));
                pro.setCreationDate(resultSet.getDate(10));
                pro.setModifyDate(resultSet.getDate(11));
                pro.setModifyBy(resultSet.getInt(12));

                list.add(pro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
