package com.vue_spring.dao;

import com.vue_spring.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDaoImpl implements AdminDao{
    @Override
    public String validation(String userName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String pwd = "";

        try{
            conn = JDBCUtil.getConnection();

            String sql = "select * from admin where userName = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userName);

            rs = pstmt.executeQuery();
            while(rs.next()){
                pwd = rs.getString(2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(rs,pstmt,conn);
        }
        return pwd;
    }
}
