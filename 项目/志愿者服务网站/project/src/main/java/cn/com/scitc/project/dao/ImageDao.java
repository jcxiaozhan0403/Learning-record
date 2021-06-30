package cn.com.scitc.project.dao;

import cn.com.scitc.project.mapper.ImageMapper;
import cn.com.scitc.project.model.Image;
import cn.com.scitc.project.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ImageDao implements ImageMapper {

    @Override
    public Image findImageById(Integer id) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ImageMapper mapper = session.getMapper(ImageMapper.class);
            return mapper.findImageById(id);
        }
    }

    @Override
    public List<Image> findAll() {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ImageMapper mapper = session.getMapper(ImageMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public Image findImageByName(String name) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ImageMapper mapper = session.getMapper(ImageMapper.class);
            return mapper.findImageByName(name);
        }
    }

    @Override
    public int updateByPrimaryKey(Image image) {
        try(SqlSession session = MybatisUtil.getSqlSession()){
            ImageMapper mapper = session.getMapper(ImageMapper.class);
            int result = mapper.updateByPrimaryKey(image);
            session.commit();
            return result;
        }
    }


}
