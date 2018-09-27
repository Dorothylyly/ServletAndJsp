package com.servlet.reception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.user.UserManager;
import com.pojo.User;

/**
 * 前台用户控制器 */
public class UserUserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    UserManager um = new UserManager();

    public UserUserServlet()
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
        String userName = request.getParameter("username");

        if("upDate".equals(opFlag))
        {
            User user = um.findByUserName(userName);
            request.setAttribute("user", user);
            request.getRequestDispatcher("reception/user_personal_update.jsp").forward(request,
                                                                                       response);
            return;
        }
        else
            if("userUpdate".equals(opFlag))
            { // 修改用户
                User uUser = new User();
                uUser.setName(request.getParameter("name"));
                uUser.setUseremail(request.getParameter("useremail"));
                uUser.setMobile(request.getParameter("mobile"));
                uUser.setRelname(request.getParameter("relname"));
                uUser.setSex(request.getParameter("sex"));
                uUser.setCity(request.getParameter("city"));
                uUser.setAddress(request.getParameter("address"));
                uUser.setPostcode(request.getParameter("postcode"));
                uUser.setTel(request.getParameter("tel"));
                uUser.setUsername(request.getParameter("username"));

                if(!um.updateUser(uUser))
                {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    return;
                }
                request.setAttribute("msg", "修改成功！");
            }

        User user = um.findByUserName(userName);
        request.setAttribute("user", user);
        request.getRequestDispatcher("reception/user_personal_dateils.jsp").forward(request,
                                                                                    response);
    }

    public void init() throws ServletException
    {

    }
}