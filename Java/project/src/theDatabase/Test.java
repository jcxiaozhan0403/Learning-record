package theDatabase;

import java.nio.file.Files;
import java.sql.SQLException;

import static theDatabase.StudentDAO.delete;

public class Test {
    public static void main(String[] args) {
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

        try {
            delete("008");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        SqlHelper.closeConn();
    }
}
