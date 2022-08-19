package cn.com.mapper.impl;

import cn.com.entity.Student;
import cn.com.mapper.StudentMapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/19 8:05
 * @Description:
 */
public class StudentMapperImpl implements StudentMapper {
    private SqlSessionTemplate sqlSession;

     public void setSqlSession(SqlSessionTemplate sqlSession) {
         this.sqlSession = sqlSession;
     }

    @Override
    public List<Student> studentList() {
        return sqlSession.getMapper(StudentMapper.class).studentList();
    }
}
