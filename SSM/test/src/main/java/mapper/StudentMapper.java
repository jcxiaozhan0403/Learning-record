package mapper;

import entity.Student;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/10 22:12
 * @Description:
 */
public interface StudentMapper {
    int addStudent(Student student);

    int deleteStudent(int stuId);

    int updateStudent(Student student);

    Student getStudent(int stuId);
}
