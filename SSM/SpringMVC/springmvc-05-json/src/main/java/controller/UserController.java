package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/t1")
    @ResponseBody
    public String getUse() throws JsonProcessingException {
        User user = new User("李爽",20,"男");
        System.out.println(user);
        return JsonUtils.getJson(user);
    }

    @RequestMapping("/t2")
    @ResponseBody
    public String getUse2() throws JsonProcessingException {
        List<User> users = new ArrayList<User>();
        User user1 = new User("张三",20,"男");
        User user2 = new User("李四",20,"男");
        User user3 = new User("王麻子",20,"男");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return JsonUtils.getJson(users);
    }
}
