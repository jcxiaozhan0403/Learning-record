package cn.com.scitc.project.dao;


import cn.com.scitc.project.mapper.StudentMapper;
import cn.com.scitc.project.model.Student;
import cn.com.scitc.project.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDao implements StudentMapper {
    @Override
    public int deleteByPrimaryKey(Integer id) {

        return 0;
    }

    @Override
    public int insert(Student record) {
        return 0;
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Student> selectAll() {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.selectAll();
        }
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }

}
