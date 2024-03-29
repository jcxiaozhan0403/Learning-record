package cn.com.scitc.project.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/management/*")
public class ManagerLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri= request.getRequestURI();
        System.out.println(uri);

        HttpSession session = request.getSession();
        if (session.getAttribute("currentUser") == null){
            // 未登录状态处理

            // 访问指定路径时不进行处理
            if (uri.contains("/management/login") || uri.contains("/management/checkLogin")){

            }else {
                // 直接访问主页则重定向到登录页
//                response.sendRedirect("login");
                response.sendRedirect("/project/management/login");
                return;
            }
        }else {
            // 已登录状态不进行处理
        }
        chain.doFilter(request, response);
    }
}
