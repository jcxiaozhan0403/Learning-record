package cn.com.huadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author John.Cena
 * @date 2021/11/3 9:54
 * @Description: 宣传课程页面的控制器
 */
@Controller
public class VideoController {

    @GetMapping("/video")
    public String toVideo() {
        return "video";
    }
}
