package cn.com.scitc.project.dao;

import cn.com.scitc.project.model.Image;
import org.junit.jupiter.api.Test;

class ImageDaoTest {

    @Test
    void test() {
        ImageDao dao = new ImageDao();
        Image image = dao.findImageByName("page1");
        image.setUrl("https://img.jcxiaozhan.top/markdown%E5%86%99%E5%8D%9A%E5%AE%A2%E6%96%87%E7%AB%A0%E5%9B%BE%E6%A0%87.jpg");
        dao.updateByPrimaryKey(image);
    }
}