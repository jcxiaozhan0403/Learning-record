package cn.com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author John.Cena
 * @date 2022/8/2 18:39
 * @Description: 登录拦截器
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getSession().getAttribute("user") == null){
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }else {
            chain.doFilter(req,res);
        }

    }

    public void destroy() {

    }
}
