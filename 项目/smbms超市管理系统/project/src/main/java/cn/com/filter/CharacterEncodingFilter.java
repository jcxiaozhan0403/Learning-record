package cn.com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author John.Cena
 * @date 2022/8/2 9:36
 * @Description: 字符编码过滤器
 */
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
