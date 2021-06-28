package cn.com.scitc.project.dao;

import cn.com.scitc.project.model.Image;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImageDaoTest {

    @Test
    void findImageById() {
        ImageDao dao = new ImageDao();
        List<Image> images = dao.findAll();
        HashMap<String,String> map = new HashMap<>();
        for (Image image : images) {
            map.put(image.getName(),image.getUrl());
        }
        System.out.println(map);
    }
}