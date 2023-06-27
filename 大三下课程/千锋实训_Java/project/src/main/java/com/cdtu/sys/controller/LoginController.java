package com.cdtu.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.cdtu.sys.domain.User;
import com.cdtu.sys.domain.UserVo;
import com.cdtu.sys.service.IUserService;
import com.cdtu.sys.utils.SysConstant;
import com.cdtu.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */

@RequestMapping("login")
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转到 view/main/login.jsp页面
     * 返回值：String 就是上面跳转的路径地址
     * 参数：没有
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/main/login";
    }

    /**
     * 生成验证码： 生成一个图片，以io流的方式输出到前台
     * 参数：session （验证码生成后要放到session）    response  获取输出流
     * 返回什么：空
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response , HttpSession session) throws IOException {
        //1.使用工具类生成图片
        //参数116 宽度  37高度  4 四个字符  5条干扰线
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 37, 4, 5);

        //2.把生成的code 验证码放到session中
        session.setAttribute("code",lineCaptcha.getCode());

        //3.以流的方式输出
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(),"JPEG",outputStream);
    }

    /**
     * 登录操作
     * 返回值类型： 页面跳转，String
     * 参数： UserVo  目的：封装前台传递的三个参数  username  pwd  code ;
     *       Model 对象， 存放一些提示消息
     */
    @RequestMapping("login")
    public String login(UserVo userVo , Model model){
        //1.获取验证码
        HttpSession session = WebUtils.getHttpSession();
        String sessionCode = WebUtils.getHttpSession().getAttribute("code").toString();
        String userCode = userVo.getCode();
        if(userCode.equals(sessionCode)){
            //2.判断用户是否存在
            User user = userService.login(userVo);
            if(user != null){ //查到了
                //3.如果存在放到session中,页面跳转到 `system/main/index`
                session.setAttribute("user",user);
                return "system/main/index";
            }else{
                ////4如果不存在返回用户名或密码错误，并跳转到login.jsp （用户名或这密码的问题）
                model.addAttribute("error", SysConstant.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        }else{
            //5.验证码错误
            model.addAttribute("error", SysConstant.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }
    }

}
