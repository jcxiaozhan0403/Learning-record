package theDatabase;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static Connection conn;
    public StudentDAO(){
        try {
            conn= SqlHelper.getConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //添加纪录
    public void add(Student stu) throws SQLException{
        String sql="insert into student values('"+stu.getStuId()+"','"+stu.getStuName()+"'"
                + ",'"+stu.getStuSex()+"',"+stu.getStuAge()+")";
        Statement state=conn.createStatement();
        state.executeUpdate(sql);
    }

    //使用预处理的Statement
    public void add1(Student stu) throws SQLException {
        String sql="insert into student(stuId,stuName,stuSex,stuAge) values(?,?,?,?)";
        PreparedStatement pState = conn.prepareStatement(sql);
        pState.setString(1,stu.getStuId());
        pState.setString(2,stu.getStuName());
        pState.setString(3,stu.getStuSex());
        pState.setInt(4,stu.getStuAge());
        pState.executeUpdate();
    }

    //删除记录
    public void delete(String id) throws SQLException {
        String sql = "delete from student where stuId = " + id;

        Statement state=conn.createStatement();
        state.execute(sql);
    }

    //使用预处理的Statement
    public void delete(Student stu) throws SQLException {
        String sql="delete from student where stuId = ?";
        PreparedStatement pState = conn.prepareStatement(sql);
        pState.setString(1,stu.getStuId());
        pState.executeUpdate();
    }

    //修改纪录
    public void edit(Student stu) throws SQLException{
        String sql="update student set stuName='"+stu.getStuName()+"',stuSex='"+stu.getStuSex()+"',"
                + "stuAge="+stu.getStuAge()+" where stuId='"+stu.getStuId()+"'";
        Statement state=conn.createStatement();
        state.executeUpdate(sql);
    }
    //根据主键查询
    public Student findById(String stuId) throws SQLException{
        String sql="select * from student where stuId='"+stuId+"'";
        Student stu=null;
        Statement state=conn.createStatement();
        ResultSet rs=state.executeQuery(sql);
        if(rs.next()){
            stu=new Student();
            stu.setStuId(stuId);
            stu.setStuName(rs.getString("stuName"));
            stu.setStuSex(rs.getString("stuSex"));
            stu.setStuAge(rs.getInt("stuAge"));
        }
        return stu;
    }
    //查询所有记录
    public List<Student> findAll() throws SQLException {
        String sql = "select * from student";
        List <Student> list = new ArrayList<Student>();
        Statement state=conn.createStatement();
        ResultSet rs=state.executeQuery(sql);
        while(rs.next()){
            Student stu=new Student();
            stu.setStuName(rs.getString("stuId"));
            stu.setStuName(rs.getString("stuName"));
            stu.setStuSex(rs.getString("stuSex"));
            stu.setStuAge(rs.getInt("stuAge"));
        }
        return list;
    }
    //根据属性查询
    public List<Student> findByProperty(String proName,Object proValue) throws SQLException {
        String sql = "select * from student";
        if (proValue instanceof String){
            sql += "where" + proName + "like ‘%" + proValue + "%'";
        }else{
            sql += "where" + proName + "=" + proValue;
        }
        List <Student> list = new ArrayList<Student>();
        Statement state=conn.createStatement();
        ResultSet rs=state.executeQuery(sql);
        while(rs.next()){
            Student stu=new Student();
            stu.setStuName(rs.getString("stuId"));
            stu.setStuName(rs.getString("stuName"));
            stu.setStuSex(rs.getString("stuSex"));
            stu.setStuAge(rs.getInt("stuAge"));
        }
        return list;
    }
}