package com.cheng.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (request.getRequestURI().contains("login")){
            System.out.println(1);
            return true;

        };

        if (session.getAttribute("userLoginInfo")!=null){
            System.out.println(2);
            return true;
        }
        if (session.getAttribute("user")!=null){
            System.out.println(3);
            return true;
        }

        request.getRequestDispatcher("/WEB-INF/jsp/logintext.jsp").forward(request,response);

        return true;
    }
}
