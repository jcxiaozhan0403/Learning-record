package cn.com.scitc.studentmanager.mapper;

import cn.com.scitc.studentmanager.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    // 教师列表
    List<Teacher> listTeacher();

    // 添加教师
    void addTeacher(Teacher teacher);

    // 删除教师
    void deleteTeacher(Integer id);

    // 修改教师
    void updateTeacher(Teacher teacher);

    //根据学号模糊查询教师信息
    List<Teacher> findByNumContaining(String num);

    //根据姓名模糊查询教师信息
    List<Teacher> findByNameContaining(String name);
}
