package service;

import entity.Student;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/10 22:17
 * @Description:
 */
public interface StudentService {
    int addStudent(Student student);

    int deleteStudent(int stuId);

    int updateStudent(Student student);

    Student getStudent(int stuId);
}
