package cn.com.servlet;

import cn.com.pojo.Bill;
import cn.com.pojo.Pro;
import cn.com.service.user.BillService;
import cn.com.service.user.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/4 8:37
 * @Description:
 */
public class BillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BillService billService = new BillServiceImpl();
        List<Bill> billList = billService.getBillList();
        List<Pro> providerList = billService.getProList();

        req.getSession().setAttribute("providerList",providerList);
        req.getSession().setAttribute("billList",billList);

        req.getRequestDispatcher("/jsp/billlist.jsp").forward(req,resp);
    }
}
