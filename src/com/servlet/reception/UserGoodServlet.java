package com.servlet.reception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.goods.GoodManager;
import com.dao.order.OrderManager;
import com.dao.shoppingcar.ShoppingcarManager;
import com.dao.user.UserManager;
import com.pojo.Good;
import com.pojo.Shoppingcar;
import com.pojo.User;
import com.util.CommonUtil;

/**
 * 前台购物车控制器
 * @author chenguoji
 */
public class UserGoodServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    GoodManager gm = new GoodManager();
    OrderManager im = new OrderManager();
    UserManager um = new UserManager();
    ShoppingcarManager sm = new ShoppingcarManager();

    public UserGoodServlet()
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

        long goodId = Long.valueOf(request.getParameter("goodId"));

        Good good = gm.findById(goodId);
        request.setAttribute("good", good);

        if("buyGoods".equals(opFlag))
        { // 立即购买。
            String buyPwd = request.getParameter("buyPwd");
            String userPwd = CommonUtil.currUser.getPwd();

            long userId = CommonUtil.currUser.getUserid();
            int num = Integer.parseInt(request.getParameter("num"));

            if(!userPwd.equals(buyPwd))
            {
                request.setAttribute("errmsg", "您输入的支付密码错误！请您重新核对~");
                request.getRequestDispatcher("reception/user_good_details.jsp").forward(request,
                                                                                        response);
                return;
            }

            if(!im.buyGoods(goodId, userId, num))
            {
                request.setAttribute("errmsg", "购买失败~");
            }
        }
        else
            if("shoppingCar".equals(opFlag))
            { // 加入收藏夹

                long userId = CommonUtil.currUser.getUserid();

                // int num = Integer.parseInt(request.getParameter("num"));

                Shoppingcar nShoppingcar = new Shoppingcar();

                nShoppingcar.setId(goodId);
                nShoppingcar.setUserid(userId);
                // nShoppingcar.setShopnum(num);

                System.out.println(goodId);

                if(!sm.addGood(nShoppingcar))
                {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    return;
                }
            }
            else
                if("login".equals(opFlag))
                { // 快捷登录
                    String username = request.getParameter("userName");
                    String pwd = request.getParameter("pwd");

                    User lUser = new User();
                    lUser.setUsername(username);
                    lUser.setPwd(pwd);

                    if(!um.login(lUser))
                    {
                        String errMsg = "您输入的账号或密码不存在，请核对后重新输入";
                        request.setAttribute("errMsg", errMsg);
                    }
                    else
                    {
                        CommonUtil.currUser = lUser;
                        request.getSession().setMaxInactiveInterval(3600);
                        HttpSession hs = request.getSession();
                        hs.setAttribute("user", lUser);
                    }
                }
        request.getRequestDispatcher("reception/user_good_details.jsp").forward(request, response);
    }

    public void init() throws ServletException
    {

    }
}
