package theDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
    private Connection conn;
    public StudentDAO(){
        try {
            conn= SqlHelper.getConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

    //删除记录
    public void delete(String stuId) throws SQLException {
        String sql="delete form student where stuId =" + stuId + "";
        Statement state=conn.createStatement();
        state.execute(sql);
    }
}
