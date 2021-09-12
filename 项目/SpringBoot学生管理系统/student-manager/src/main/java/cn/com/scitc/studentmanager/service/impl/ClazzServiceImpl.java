package cn.com.scitc.studentmanager.service.impl;

import cn.com.scitc.studentmanager.mapper.ClazzMapper;
import cn.com.scitc.studentmanager.pojo.Clazz;
import cn.com.scitc.studentmanager.pojo.Student;
import cn.com.scitc.studentmanager.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    ClazzMapper clazzMapper;

    @Override
    public List<Clazz> listClazz() {
        return clazzMapper.listClazz();
    }

    @Override
    public List<String> getAllGrade() {
        return clazzMapper.getAllGrade();
    }

    @Override
    public List<String> getAllCalzz(String grade) {
        return clazzMapper.getAllCalzz(grade);
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazzMapper.addClazz(clazz);
    }

    @Override
    public void deleteClazz(Integer id) {
        clazzMapper.deleteClazz(id);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazzMapper.updateClazz(clazz);
    }
}
