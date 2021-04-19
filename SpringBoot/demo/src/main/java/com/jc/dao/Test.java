package com.jc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    public static String find(String userName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String pwd = "";
        try {
            conn = JDBCUtil.getConnection();

            String sql = "select * from admin where userName = " + userName;
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\n");
                pwd = rs.getString(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, pstmt, conn);
        }
        return pwd;
    }
}