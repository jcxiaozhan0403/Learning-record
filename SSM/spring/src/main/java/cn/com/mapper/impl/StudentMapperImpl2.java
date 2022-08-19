package cn.com.mapper.impl;

import cn.com.entity.Student;
import cn.com.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/19 9:05
 * @Description:
 */
public class StudentMapperImpl2 extends SqlSessionDaoSupport implements StudentMapper {
    @Override
    public List<Student> studentList() {
        //使用getSqlSession方法可以直接获取SqlSession
        return getSqlSession().getMapper(StudentMapper.class).studentList();
    }
}
