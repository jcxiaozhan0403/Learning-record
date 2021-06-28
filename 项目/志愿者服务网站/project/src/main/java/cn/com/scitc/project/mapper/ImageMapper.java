package cn.com.scitc.project.mapper;

import cn.com.scitc.project.model.Image;

import java.util.List;

public interface ImageMapper {
    Image findImageById(Integer id);

    List<Image> findAll();
}
