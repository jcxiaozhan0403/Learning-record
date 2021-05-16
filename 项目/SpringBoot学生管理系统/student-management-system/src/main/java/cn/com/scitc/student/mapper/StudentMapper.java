package cn.com.scitc.student.mapper;


import cn.com.scitc.student.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student Sel(int id);
}
