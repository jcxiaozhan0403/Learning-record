package service.impl;

import entity.Student;
import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import service.StudentService;
import utils.MybatisUtil;

/**
 * @author John.Cena
 * @date 2022/8/10 22:17
 * @Description:
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public int addStudent(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int rs = mapper.addStudent(student);
        sqlSession.commit();
        return rs;
    }

    @Override
    public int deleteStudent(int stuId) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int rs = mapper.deleteStudent(stuId);
        sqlSession.commit();
        return rs;
    }

    @Override
    public int updateStudent(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int rs = mapper.updateStudent(student);
        sqlSession.commit();
        return rs;
    }

    @Override
    public Student getStudent(int stuId) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        return mapper.getStudent(stuId);
    }
}
