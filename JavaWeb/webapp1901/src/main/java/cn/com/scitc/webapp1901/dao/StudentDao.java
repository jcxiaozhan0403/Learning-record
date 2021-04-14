package cn.com.scitc.webapp1901.dao;

import cn.com.scitc.webapp1901.pojo.Student;
import cn.com.scitc.webapp1901.mapper.StudentMapper;
import cn.com.scitc.webapp1901.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentDao {

    public Student findById(Integer id) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.findById(1);
        }
    }
}
