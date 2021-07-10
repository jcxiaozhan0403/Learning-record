package com.smis.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smis.common.SqlHelper;
import com.smis.model.Cls;

public class ClsDao {
    private Connection conn;
    public ClsDao() throws ClassNotFoundException, SQLException, IOException{
        conn=SqlHelper.getConn();
    }
    //添加
    public void add(Cls cls) throws SQLException{
        String sql="insert into cls values(?,?,?,?)";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setString(1,cls.getClsId());
        pState.setString(2,cls.getClsName());
        pState.setString(3,cls.getClsAdmin());
        pState.setDate(4, new Date(cls.getClsTime().getTime()));
        pState.executeUpdate();
    }
    //删除
    public void delete(String clsId) throws SQLException{
        String sql="delete from cls where clsId=?";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setString(1,clsId);
        pState.executeUpdate();
    }
    //修改记录
    public void update(Cls cls) throws SQLException{
        String sql="update cls set clsName=?,clsAdmin=?,clsTime=? where clsId=?";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setString(4,cls.getClsId());
        pState.setString(1,cls.getClsName());
        pState.setString(2,cls.getClsAdmin());
        pState.setDate(3, new Date(cls.getClsTime().getTime()));
        pState.executeUpdate();
    }
    //查询
    public Cls findById(String clsId) throws SQLException{
        String sql="select * from cls where clsId=?";
        PreparedStatement pState=conn.prepareStatement(sql);
        pState.setString(1,clsId);
        Cls cls=null;
        ResultSet rs=pState.executeQuery();
        if(rs.next()){
            cls=new Cls();
            cls.setClsId(rs.getString("clsId"));
            cls.setClsName(rs.getString("clsName"));
            cls.setClsAdmin(rs.getString("clsAdmin"));
            cls.setClsTime(rs.getDate("clsTime"));
        }
        return cls;
    }
    public List<Cls> findAll() throws SQLException {
        String sql="select * from cls";
        List<Cls> list=new ArrayList<Cls>();
        PreparedStatement pState=conn.prepareStatement(sql);
        ResultSet rs=pState.executeQuery();
        while(rs.next()){
            Cls cls=new Cls();
            cls.setClsId(rs.getString("clsId"));
            cls.setClsName(rs.getString("clsName"));
            cls.setClsAdmin(rs.getString("clsAdmin"));
            cls.setClsTime(rs.getDate("clsTime"));
            list.add(cls);
        }
        return list;
    }
    public List<Cls> findByProerties(String proName, Object proValue) throws SQLException {
        String sql="select * from cls where ";
        if(proName.equals("clsTime")){
            sql+=proName + " > '"+proValue+"'";
        }else{
            sql+=proName+" like '%"+proValue+"%'";
        }
        List<Cls> list=new ArrayList<Cls>();
        PreparedStatement pState=conn.prepareStatement(sql);
        ResultSet rs=pState.executeQuery();
        while(rs.next()){
            Cls cls=new Cls();
            cls.setClsId(rs.getString("clsId"));
            cls.setClsName(rs.getString("clsName"));
            cls.setClsAdmin(rs.getString("clsAdmin"));
            cls.setClsTime(rs.getDate("clsTime"));
            list.add(cls);
        }
        return list;
    }
}
