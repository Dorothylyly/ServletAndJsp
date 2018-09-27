package com.servlet.reception;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.order.OrderManager;
import com.pojo.Order;

/**
 * 前台订单控制器 */
public class UserOrderServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    OrderManager im = new OrderManager();

    public UserOrderServlet()
    {
        super();
    }

    public void destroy()
    {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String opFlag = request.getParameter("op");

        String username = request.getParameter("username");
        List<Order> indentList = null;

        if("upIndent".equals(opFlag))
        {
            String state = "已签收";
            int actionid = Integer.parseInt(request.getParameter("actionid"));

            if(!im.upIndent(state, actionid))
            {
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }
        }

        indentList = im.findAllIndent(username);
        request.setAttribute("indentList", indentList);
        request.getRequestDispatcher("reception/user_personal_buygood.jsp").forward(request,
                                                                                    response);
    }

    public void init() throws ServletException
    {

    }
}
