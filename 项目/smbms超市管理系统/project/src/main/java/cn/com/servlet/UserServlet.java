package cn.com.servlet; /**
 * @author John.Cena
 * @date 2022/8/5 9:11
 * @Description: ${todo}
 */

import cn.com.pojo.User;
import cn.com.service.user.UserService;
import cn.com.service.user.impl.UserServiceImpl;
import cn.com.util.PageSupport;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        PageSupport pageSupport = new PageSupport();
        List<User> userList = userService.getUserList();
        int totalCount = userService.getTotalCount();
        int pageSize = 5;

        request.getSession().setAttribute("userList",userList);
        request.getSession().setAttribute("totalCount",totalCount);
        request.getSession().setAttribute("pageSize",pageSize);
        request.getSession().setAttribute("totalPageCount",totalCount/pageSize);
        request.getSession().setAttribute("currentPageNo",1);

        request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);
    }
}
