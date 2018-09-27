package com.servlet.backstage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.order.OrderManager;
import com.dao.paging.PagingManager;
import com.pojo.Order;

/**
 * 后台订单控制器 */
public class OrderServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    OrderManager im = new OrderManager();
    PagingManager pm = new PagingManager();
    int fromIndex;
    int pageSize;
    String table = "v_indent";

    public OrderServlet()
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

        List<Order> indentList = null;

        if("detail".equals(opFlag))
        { // 查看详情
            long Actionid = Long.valueOf(request.getParameter("actionid"));
            Order indent = im.findById(Actionid);

            request.setAttribute("indent", indent);
            request.getRequestDispatcher("backstage/manager_indent_details.jsp").forward(request,
                                                                                         response);
            return;
        }
        else
            if("upIndent".equals(opFlag))
            {
                String state = "已发货";
                int actionid = Integer.parseInt(request.getParameter("actionid"));

                if(!im.upIndent(state, actionid))
                {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    return;
                }
            }
            else
                if("first".equals(opFlag))
                { // 首页
                    pm.setPageSize(7);
                    int currentPage = 1;
                    pm.setCurrentPage(currentPage);
                    fromIndex = pm.getFromIndex(); // 起始位置
                    pageSize = pm.getPageSize(); // 每页显示的记录数
                }
                else
                    if("prepage".equals(opFlag))
                    { // 上一页
                        if((pm.getCurrentPage() - 1) <= 0)
                        {
                            pm.setCurrentPage(1);
                            fromIndex = pm.getFromIndex();
                            pageSize = pm.getPageSize();
                        }
                        else
                        {
                            int currentPage = pm.getCurrentPage() - 1;
                            pm.setCurrentPage(currentPage);
                            fromIndex = pm.getFromIndex();
                            pageSize = pm.getPageSize();
                        }
                    }
                    else
                        if("next".equals(opFlag))
                        { // 下一页
                            if((pm.getCurrentPage() + 1) > pm.getPageCount())
                            {
                                pm.setCurrentPage(pm.getPageCount());
                                fromIndex = pm.getFromIndex();
                                pageSize = pm.getPageSize();

                                request.setAttribute("totalpages", pm.getCurrentPage());
                                request.setAttribute("pageno", pm.getPageCount());
                                indentList = pm.getIndentPagedata(table, fromIndex, pageSize);
                                request.setAttribute("msg", "本页已经是最后一页");
                                request.setAttribute("indentList", indentList);
                                request.getRequestDispatcher("backstage/manager_indent_list.jsp")
                                       .forward(request, response);
                                return;
                            }
                            else
                            {
                                int currentPage = pm.getCurrentPage() + 1;
                                pm.setCurrentPage(currentPage);
                                fromIndex = pm.getFromIndex();
                                pageSize = pm.getPageSize();
                            }
                        }
                        else
                            if("last".equals(opFlag))
                            { // 最后一页
                                pm.setCurrentPage(pm.getPageCount());
                                fromIndex = pm.getFromIndex();
                                pageSize = pm.getPageSize();
                            }

        indentList = pm.getIndentPagedata(table, fromIndex, pageSize);
        request.setAttribute("totalpages", pm.getCurrentPage());
        request.setAttribute("pageno", pm.getPageCount());
        request.setAttribute("indentList", indentList);
        request.getRequestDispatcher("backstage/manager_indent_list.jsp")
               .forward(request, response);
    }

    public void init() throws ServletException
    {

    }
}
