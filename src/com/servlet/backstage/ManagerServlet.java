package com.servlet.backstage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.manager.ManagerManager;
import com.pojo.Manager;
import com.util.CommonUtil;

/**
 * 后台管理员控制器 */
public class ManagerServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    ManagerManager mm = new ManagerManager();

    public ManagerServlet()
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
        List<Manager> managerList = null;

        String opFlag = request.getParameter("op");

        if("upPwd".equals(opFlag))
        {
            Manager cManager = new Manager();
            cManager.setAdmin(CommonUtil.currManager.getAdmin());
            String oldPwd = CommonUtil.currManager.getPwd();
            String oldPwd2 = request.getParameter("oldpwd");
            String newPwd = request.getParameter("rpwd");

            if(!oldPwd.equals(oldPwd2))
            {
                request.setAttribute("errmsg", "密码错误");
                request.getRequestDispatcher("backstage/manager_uppwd.jsp").forward(request,
                                                                                    response);
                return;
            }

            if(!mm.modifyPwd(cManager, newPwd))
            {
                request.setAttribute("errmsg2", "修改失败！");
                request.getRequestDispatcher("backstage/manager_uppwd.jsp").forward(request,
                                                                                    response);
                return;
            }
            request.getRequestDispatcher("backstage/managerlogin.jsp").forward(request, response);
            return;
        }
        else
            if(!"超级管理员".equals(CommonUtil.currManager.getRank()))
            {
                request.setAttribute("errmsg", "抱歉~您不是超级管理员！");
                request.getRequestDispatcher("backstage/managerindex.jsp").forward(request,
                                                                                   response);
                return;
            }
            else
                if("findAll".equals(opFlag))
                {// 查所有管理员
                    managerList = mm.findAll();

                    request.setAttribute("managerlist", managerList);
                    request.getRequestDispatcher("backstage/manager_manager_list.jsp")
                           .forward(request, response);
                    return;
                }
                else
                    if("detail".equals(opFlag))
                    { // 查看详情
                        String Admin = request.getParameter("admin");
                        Manager manager = mm.findByAdmin(Admin);

                        request.setAttribute("manager", manager);
                        request.getRequestDispatcher("backstage/manager_manager_details.jsp")
                               .forward(request, response);
                        return;
                    }
                    else
                        if("adduser".equals(opFlag))
                        {// 添加管理员
                            Manager nManager = new Manager();
                            nManager.setAdmin(request.getParameter("admin"));
                            nManager.setPwd(request.getParameter("rpwd"));
                            nManager.setRank(request.getParameter("type"));

                            if(!mm.addManager(nManager))
                            {
                                request.setAttribute("errmsg", "抱歉！管理员已存在");
                                request.getRequestDispatcher("backstage/manager_manager_add.jsp")
                                       .forward(request, response);
                            }
                            request.setAttribute("succeedmsg", "添加成功！");
                            request.getRequestDispatcher("backstage/manager_manager_add.jsp")
                                   .forward(request, response);
                            return;
                        }
                        else
                            if("deluser".equals(opFlag))
                            {
                                Manager dManager = new Manager();
                                dManager.setAdmin(request.getParameter("admin"));

                                if(!mm.deleteManager(dManager))
                                {
                                    request.setAttribute("errmsg", "删除失败!");
                                    request.getRequestDispatcher("backstage/manager_manager_del.jsp")
                                           .forward(request, response);
                                    return;
                                }
                                request.setAttribute("succeedmsg", "删除成功！");
                                request.getRequestDispatcher("backstage/manager_manager_del.jsp")
                                       .forward(request, response);
                                return;
                            }
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

    public void init() throws ServletException
    {
        // Put your code here
    }

}
