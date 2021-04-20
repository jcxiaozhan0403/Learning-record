package cn.com.scitc.webapp1901;

import cn.com.scitc.webapp1901.mapper.StudentMapper;
import cn.com.scitc.webapp1901.model.Student;
import cn.com.scitc.webapp1901.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Test {
    @org.junit.jupiter.api.Test
    public void SelectId() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.selectByPrimaryKey(1);

        System.out.println(student.getName());
    }
}
