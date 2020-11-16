package theDatabase;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
//        Student s = new Student();
//        s.setStuId("008");
//        s.setStuName("陈七");
//        s.setStuSex("男");
//        s.setStuAge(23);
//        StudentDAO dao = new StudentDAO();
//        try {
//            dao.add(s);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        StudentDAO dao = new StudentDAO();
////        dao.delete("008");
//
//        s=dao.findById("003");
//        s.setStuName("黄蓉");
//        s.setStuSex("女");
//        dao.edit(s);
//
//        SqlHelper.closeConn();
        new StudentList();
    }
}
