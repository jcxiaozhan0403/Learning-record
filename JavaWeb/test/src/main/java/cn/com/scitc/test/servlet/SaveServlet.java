package cn.com.scitc.test.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/sava")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String on = request.getParameter("on");
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        System.out.println("编号:" + on);
        System.out.println("姓名:" + name);
        System.out.println("出生年月:" + birth);
        System.out.println("地址:" + address);
    }
}
