package cn.com.scitc.project.mapper;

import cn.com.scitc.project.model.Image;

import java.util.List;

public interface ImageMapper {
    Image findImageById(Integer id);

    List<Image> findAll();

    Image findImageByName(String name);

    int updateByPrimaryKey(Image image);


}
