package com.jc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Paths;


/**
 * @author John.Cena
 * @date 2023/4/13 19:11
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Test
    public void demo() throws FileNotFoundException, UnsupportedEncodingException, URISyntaxException {
        String path = Paths.get(ResourceUtils.getURL("classpath:").toURI()).toString();
        System.out.println(path);
        File file = new File(new String(path.getBytes("UTF-8"), "UTF-8"));
    }
}
