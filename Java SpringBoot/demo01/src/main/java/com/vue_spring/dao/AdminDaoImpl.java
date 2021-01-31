package com.vue_spring.dao;

import com.vue_spring.utils.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class AdminDaoImpl implements AdminDao{
    @Override
    public Vector<Vector<Object>> validation(String userName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> rowVector = null;

        try{
            conn = JDBCUtil.getConnection();

            String sql = "select * from admin where userName = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"111");

            rs = pstmt.executeQuery();
            while(rs.next()){
              String name = rs.getString(1);
              String pwd = rs.getString(2);

                rowVector = loading(name,pwd);

                data.addElement(rowVector);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(rs,pstmt,conn);
        }

        return data;
    }


    public Vector<Object> loading(String name,String pwd) {
        Vector<Object> rowVector = new Vector<>();
        rowVector.addElement(name);
        rowVector.addElement(pwd);

        return rowVector;
    }
}
