package com.servlet.backstage;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.manager.ManagerManager;
import com.pojo.Manager;
import com.util.CommonUtil;

/**
 * 后台管理员登录控制器 */
public class ManagerLoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    ManagerManager mm = new ManagerManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String opFlag = request.getParameter("op");
        String admin = request.getParameter("managerName");
        String pwd = request.getParameter("managerPwd");

        Manager lManager = new Manager();
        lManager.setAdmin(admin);
        lManager.setPwd(pwd);

        if("quit".equals(opFlag))
        {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("backstage/managerlogin.jsp");
            return;
        }

        if(!mm.login(lManager))
        {
            String errMsg = "您输入的账户名不存在，请核对后重新输入";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("backstage/managerlogin.jsp").forward(request, response);
            return;
        }
        CommonUtil.currManager = lManager;
        request.getSession().setAttribute("loginFlag", "OK");
        request.getSession().setMaxInactiveInterval(3600);
        HttpSession hs = request.getSession();
        hs.setAttribute("manager", lManager);

        // Cookie记住密码
        String ck[] = request.getParameterValues("rememberPwd");
        if(ck != null && ck.length > 0)
        {
            // 把用户和密码存储到Cookie里面

            // 使用URLEncoder解决无法在Cookie当中保存中文的问题
            String adminName = URLEncoder.encode(admin, "utf-8");
            String adminPwd = URLEncoder.encode(pwd, "utf-8");

            Cookie adminCookie = new Cookie("adminName", adminName);
            Cookie pwdCookie = new Cookie("adminPwd", adminPwd);
            adminCookie.setMaxAge(10 * 24 * 3600); // 设置生存时间为10天
            pwdCookie.setMaxAge(10 * 24 * 3600);
            response.addCookie(adminCookie);
            response.addCookie(pwdCookie);
        }
        else
        {
            Cookie[] cookie = request.getCookies();
            if(cookie != null && cookie.length > 0)
            {
                for(Cookie c : cookie)
                {
                    if(c.getName().equals("adminName") || c.getName().equals("adminPwd"))
                    {
                        c.setMaxAge(0); // 设置Cookie失效
                        response.addCookie(c); // 重新保存
                    }
                }
            }
        }
        request.getRequestDispatcher("backstage/managerindex.jsp").forward(request, response);
    }
}