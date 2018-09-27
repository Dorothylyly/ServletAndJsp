package com.servlet.backstage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.shoppingcar.ShoppingcarManager;
import com.pojo.Shoppingcar;

/**
 * 后台购物车控制器 */
public class ShoppingcarServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    ShoppingcarManager sm = new ShoppingcarManager();

    public ShoppingcarServlet()
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

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        response.setContentType("text/html");

        String opFlag = request.getParameter("op");
        List<Shoppingcar> shoppingcarList = null;

        if("findAll".equals(opFlag))
        { // 查所有商品
            String username = request.getParameter("username");
            shoppingcarList = sm.findAll(username);

            request.setAttribute("shoppingcarlist", shoppingcarList);
            request.getRequestDispatcher("reception/user_shoppingcar.jsp").forward(request,
                                                                                   response);
            return;
        }
    }

    public void init() throws ServletException
    {

    }
}
