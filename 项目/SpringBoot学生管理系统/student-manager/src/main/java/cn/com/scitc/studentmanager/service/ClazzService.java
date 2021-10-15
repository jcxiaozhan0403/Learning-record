package cn.com.scitc.studentmanager.service;

import cn.com.scitc.studentmanager.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 班级服务接口
 */
@Mapper
public interface ClazzService {

    /**
     *
     * @return
     * 班级列表
     */
    List<Clazz> listClazz();

    /**
     *
     * @return
     * 年级列表
     */
    List<String> getAllGrade();

    /**
     *
     * @param grade
     * @return
     * 每个年级对应的班级列表
     */
    List<String> getAllCalzz(String grade);

    /**
     *
     * @param clazz
     * 添加班级
     */
    void addClazz(Clazz clazz);

    /**
     *
     * @param id
     * 删除班级
     */
    void deleteClazz(Integer id);

    /**
     *
     * @param clazz
     * 更新班级
     */
    void updateClazz(Clazz clazz);

    /**
     *
     * @param clazz
     * @return
     * 根据班级名查询班级信息
     */
    Clazz findClazz(String clazz);
}
