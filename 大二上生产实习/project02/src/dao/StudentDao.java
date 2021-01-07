package dao;

import handler.JDBCUtils;

import view.MainView;


import java.sql.*;
import java.util.Vector;

public class StudentDao {
    private static Connection conn;

    //加载数据
    public static Vector<Vector<Object>> query() throws Exception {
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> rowVector = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = JDBCUtils.getConnection();

        String sql = "select * from student";

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String stuId = rs.getString(1);
            String stuName = rs.getString(2);
            String stuSex = rs.getString(3);
            int stuAge = rs.getInt(4);
            String stuCls = rs.getString(5);

            rowVector = loading(stuId,stuName,stuSex,stuAge,stuCls);

            data.addElement(rowVector);
        }
        return data;
    }

    public static Vector<Object> loading(String stuId, String stuName, String stuSex, int stuAge,String stuCls) {
        Vector<Object> rowVector = new Vector<>();
        rowVector.addElement(stuId);
        rowVector.addElement(stuName);
        rowVector.addElement(stuSex);
        rowVector.addElement(stuAge);
        rowVector.addElement(stuCls);
        return rowVector;
    }

    //添加数据
    public static void add(String stuId, String stuName, String stuSex, int stuAge,String stuCls) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = JDBCUtils.getConnection();
        String sql = "insert into student values(?,?,?,?,?)";

        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,stuId);
        pre.setString(2,stuName);
        pre.setString(3,stuSex);
        pre.setInt(4,stuAge);
        pre.setString(5,stuCls);
        pre.executeUpdate();
    }

    //删除数据
    public static void del() throws Exception {
        try{
            int count= MainView.jTable.getSelectedRow();//获取你选中的行号（记录）
            String stuId = MainView.jTable.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = JDBCUtils.getConnection();
            String sql = "delete from student where stuId = ?";

            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1,stuId);
            pre.executeUpdate();
        }catch(Exception exception){

        }
    }

    //修改数据
    public static void modifly(String stuId, String stuName, String stuSex, int stuAge,String stuCls) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = JDBCUtils.getConnection();
        String sql = "update student set stuId = ?,stuName = ?,stuSex = ?,stuAge = ?,stuCls = ? where stuId = ?";

        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,stuId);
        pre.setString(2,stuName);
        pre.setString(3,stuSex);
        pre.setInt(4,stuAge);
        pre.setString(5,stuCls);
        pre.setString(6,stuId);
        pre.executeUpdate();
    }

    //查询数据
    public static Vector<Vector<Object>> find(String val,String sql) throws Exception {
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> rowVector = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = JDBCUtils.getConnection();

        PreparedStatement pre = conn.prepareStatement(sql);
         pre.setString(1,val);

        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            String stuId = rs.getString(1);
            String stuName = rs.getString(2);
            String stuSex = rs.getString(3);
            int stuAge = rs.getInt(4);
            String stuCls = rs.getString(5);

            rowVector = loading(stuId,stuName,stuSex,stuAge,stuCls);

            data.addElement(rowVector);
        }
        return data;
    }
}
