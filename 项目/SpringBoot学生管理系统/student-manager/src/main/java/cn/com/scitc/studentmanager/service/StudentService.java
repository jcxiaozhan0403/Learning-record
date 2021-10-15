package cn.com.scitc.studentmanager.service;

import cn.com.scitc.studentmanager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 学生服务接口
 */
@Mapper
public interface StudentService {
    /**
     *
     * @return
     * 学生列表
     */
    List<Student> listStudent();

    /**
     *
     * @param student
     * 添加学生
     */
    void addStudent(Student student);

    /**
     *
     * @param id
     * 删除学生
     */
    void deleteStudent(Integer id);

    /**
     *
     * @param student
     * 修改学生
     */
    void updateStudent(Student student);

    /**
     *
     * @param num
     * @return
     * 根据学号模糊查询学生信息
     */
    List<Student> findByNumContaining(String num);

    /**
     *
     * @param name
     * @return
     * 根据姓名模糊查询学生信息
     */
    List<Student> findByNameContaining(String name);

    /**
     *
     * @param id
     * @return
     * 根据id查询学生
     */
    Student findById(Integer id);
}
