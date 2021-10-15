package cn.com.scitc.studentmanager.service.impl;

import cn.com.scitc.studentmanager.mapper.TeacherMapper;
import cn.com.scitc.studentmanager.pojo.Teacher;
import cn.com.scitc.studentmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 教师服务实现类
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> listTeacher() {
        return teacherMapper.listTeacher();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherMapper.deleteTeacher(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> findByNumContaining(String num) {
        return teacherMapper.findByNumContaining(num);
    }

    @Override
    public List<Teacher> findByNameContaining(String name) {
        return teacherMapper.findByNameContaining(name);
    }
}
