package com.servlet.backstage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.goods.GoodManager;
import com.dao.paging.PagingManager;
import com.pojo.Good;

/**
 * 后台商品控制器
 */
public class GoodServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    GoodManager gm = new GoodManager();
    PagingManager pm = new PagingManager();
    int fromIndex;
    int pageSize;
    String table = "t_goods_info";

    public GoodServlet()
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
        List<Good> goodList = null;

        String opFlag = request.getParameter("op");

        if("detail".equals(opFlag))
        { // 查看详情
            long Id = Long.valueOf(request.getParameter("id"));
            Good good = gm.findById(Id);

            request.setAttribute("good", good);
            request.getRequestDispatcher("backstage/manager_good_details.jsp").forward(request,
                                                                                       response);
            return;
        }
        else
            if("adduser".equals(opFlag))
            { // 添加商品
                Good nGood = new Good();
                nGood.setGoodname(request.getParameter("goodname"));
                nGood.setLook(String.valueOf(request.getParameter("look")));
                nGood.setPrice(Double.valueOf(request.getParameter("price")));
                nGood.setAddress(String.valueOf(request.getParameter("address")));
                nGood.setSeason(String.valueOf(request.getParameter("season")));
                nGood.setTaste(String.valueOf(request.getParameter("taste")));
                nGood.setPicurl("images/test/" + request.getParameter("picurl"));

                if(!gm.addGood(nGood))
                {
                    request.setAttribute("errmsg", "添加失败！");
                    request.getRequestDispatcher("backstage/manager_good_add.jsp")
                           .forward(request, response);
                    return;
                }

                request.setAttribute("succeedmsg", "添加成功！");
                request.getRequestDispatcher("backstage/manager_good_add.jsp").forward(request,
                                                                                       response);
                return;
            }
            else
                if("deluser".equals(opFlag))
                { // 删除商品
                    Good dGood = new Good();
                    dGood.setId(Long.valueOf(request.getParameter("id")));

                    try
                    {
                        if(!gm.deleteGood(dGood))
                        {
                            request.setAttribute("errmsg", "删除失败!");
                            request.getRequestDispatcher("backstage/manager_good_del.jsp")
                                   .forward(request, response);
                            return;
                        }
                    }
                    catch(Exception ex)
                    {
                        request.setAttribute("errmsg", "删除失败!");
                        request.getRequestDispatcher("backstage/manager_good_del.jsp")
                               .forward(request, response);
                        return;
                    }
                    request.setAttribute("succeedmsg", "删除成功！");
                    request.getRequestDispatcher("backstage/manager_good_del.jsp")
                           .forward(request, response);
                    return;
                }
                else
                    if("first".equals(opFlag))
                    { // 首页
                        pm.setPageSize(5);
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
                                    goodList = pm.getGoodPagedata(table, fromIndex, pageSize);
                                    request.setAttribute("msg", "本页已经是最后一页");
                                    request.setAttribute("goodlist", goodList);
                                    request.getRequestDispatcher("backstage/manager_good_list.jsp")
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

        goodList = pm.getGoodPagedata(table, fromIndex, pageSize);
        request.setAttribute("totalpages", pm.getCurrentPage());
        request.setAttribute("pageno", pm.getPageCount());
        request.setAttribute("goodlist", goodList);
        request.getRequestDispatcher("backstage/manager_good_list.jsp").forward(request, response);
    }

    public void init() throws ServletException
    {

    }
}
