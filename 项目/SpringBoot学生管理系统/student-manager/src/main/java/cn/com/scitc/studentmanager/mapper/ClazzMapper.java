package cn.com.scitc.studentmanager.mapper;

import cn.com.scitc.studentmanager.pojo.Clazz;
import cn.com.scitc.studentmanager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    // 学生列表
    List<Clazz> listClazz();

    // 获取年级列表
    List<String> getAllGrade();

    //获取班级列表
    List<String> getAllCalzz(String grade);

    // 添加班级
    void addClazz(Clazz clazz);

    // 删除班级
    void deleteClazz(Integer id);

    // 修改班级
    void updateClazz(Clazz clazz);
}
