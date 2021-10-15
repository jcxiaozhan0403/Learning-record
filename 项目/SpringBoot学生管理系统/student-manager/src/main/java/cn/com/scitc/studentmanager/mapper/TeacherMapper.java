package cn.com.scitc.studentmanager.mapper;

import cn.com.scitc.studentmanager.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 教师模块
 */
@Mapper
public interface TeacherMapper {
    /**
     *
     * @return
     * 教师列表
     */
    List<Teacher> listTeacher();

    /**
     *
     * @param teacher
     * 添加教师
     */
    void addTeacher(Teacher teacher);

    /**
     *
     * @param id
     * 删除教师
     */
    void deleteTeacher(Integer id);

    /**
     *
     * @param teacher
     * 修改教师
     */
    void updateTeacher(Teacher teacher);

    /**
     *
     * @param num
     * @return
     * 根据工号模糊查询教师信息
     */
    List<Teacher> findByNumContaining(String num);

    /**
     *
     * @param name
     * @return
     * 根据姓名模糊查询教师信息
     */
    List<Teacher> findByNameContaining(String name);
}
