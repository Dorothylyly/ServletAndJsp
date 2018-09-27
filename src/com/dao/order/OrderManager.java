package com.dao.order;

import java.util.List;

import com.pojo.Order;

/**
 * 订单业务层 */
public class OrderManager
{
    OrderDao indentdao = new OrderDao();

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> findAll()
    {
        List<Order> IndentList = null;
        try
        {
            IndentList = indentdao.findAll();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return IndentList;
    }

    /**
     * 查询一个订单
     * @param Actionid
     * @return
     */
    public Order findById(Long Actionid)
    {
        Order indent = null;
        try
        {
            indent = indentdao.findById(Actionid);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return indent;
    }

    /***
     * 立刻购买
     * @param goodId
     * @param userId
     * @param num
     * @return
     */
    public boolean buyGoods(long goodId, long userId, int num)
    {
        boolean bFlag = false;
        try
        {
            int iFlag = indentdao.buyGoods(goodId, userId, num);
            bFlag = iFlag > 0 ? true : false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return bFlag;
    }

    /**
     * 查询订单
     * @param username
     * @return
     */
    public List<Order> findAllIndent(String username)
    {
        List<Order> IndentList = null;
        try
        {
            IndentList = indentdao.findAllIndent(username);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return IndentList;
    }

    /**
     * 修改订单状态
     * @param state
     * @param actionid
     * @return
     */
    public boolean upIndent(String state, long actionid)
    {
        boolean bFlag = false;
        try
        {
            int iFlag = indentdao.upIndent(state, actionid);
            bFlag = iFlag > 0 ? true : false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return bFlag;
    }
}
