package cn.com.scitc.springbootstudy.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author John.Cena
 * @date 2021/10/22 10:27
 * @Description: 拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}
