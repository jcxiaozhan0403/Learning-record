package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

   public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       Object session = httpServletRequest.getSession().getAttribute("currentUser");
       if(session != null) {
           return true;
       }else {
           httpServletResponse.sendRedirect("/");
           System.out.println("非法访问");
       }
       return false;
  }
}