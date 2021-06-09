package cn.com.scitc.webapp2.controller;

import cn.com.scitc.webapp2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.ParseException;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping ("/edit")
    public String edit() {
        return "edit";
    }

    @PostMapping("/update")
    public String update(User user, Model model) throws ParseException {

//        String dateStr = user.getBirthday().toString();
//        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//        Date date = (Date) sdf.parse(dateStr);


//        String formatStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthday = sdf2.parse(formatStr);


//        user.setBirthday(birthday);
//        System.out.println(user.getBirthday());

        return "edit";
    }
}
