package com.dao.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pojo.Order;
import com.util.JDBCUtil;

/**
 * 订单dao层 */
public class OrderDao
{
    private StringBuffer sql = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 查看所有订单
     * @return
     * @throws Exception
     */
    public List<Order> findAll() throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from v_indent");
        ResultSet rs = JDBCUtil.queryData(sql.toString());

        List<Order> IndentList = new ArrayList<Order>();
        while(rs.next())
        {
            Order i = new Order();

            i.setActionid(rs.getLong("actionid"));
            i.setUsername(rs.getString("username"));
            i.setGoodname(rs.getString("goodname"));
            i.setProductnum(rs.getInt("productnum"));
            i.setActiondate(rs.getDate("actiondate"));
            i.setState(rs.getString("state"));
            i.setRelname(rs.getString("relname"));
            i.setMobile(rs.getString("mobile"));
            i.setAddress(rs.getString("address"));
            i.setPostcode(rs.getString("postcode"));
            i.setPrice(rs.getDouble("price"));
            i.setMemberprice(rs.getDouble("memberprice"));
            i.setTotal(rs.getDouble("total"));
            i.setPicurl(rs.getString("picurl"));

            IndentList.add(i);
        }
        return IndentList;
    }

    /**
     * 查看一个订单
     * @param Actionid
     * @return
     * @throws Exception
     */
    public Order findById(Long Actionid) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from v_indent where actionid=?");

        PreparedStatement pstmt = JDBCUtil.getConn().prepareStatement(sql.toString());
        pstmt.setLong(1, Actionid);

        ResultSet rs = pstmt.executeQuery();
        if(!rs.next())
        {
            return null;
        }

        Order indent = new Order();
        indent.setActionid(rs.getLong("actionid"));
        indent.setUsername(rs.getString("username"));
        indent.setGoodname(rs.getString("goodname"));
        indent.setProductnum(rs.getInt("productnum"));
        indent.setActiondate(rs.getDate("actiondate"));
        indent.setState(rs.getString("state"));
        indent.setRelname(rs.getString("relname"));
        indent.setMobile(rs.getString("mobile"));
        indent.setAddress(rs.getString("address"));
        indent.setPostcode(rs.getString("postcode"));
        indent.setPrice(rs.getDouble("price"));
        indent.setMemberprice(rs.getDouble("memberprice"));
        indent.setTotal(rs.getDouble("total"));
        indent.setPicurl(rs.getString("picurl"));

        rs.close();
        pstmt.close();

        return indent;
    }

    /**
     * 查询订单
     * @param username
     * @return
     * @throws Exception
     */
    public List<Order> findAllIndent(String username) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from v_indent where username='").append(username).append("';");

        ResultSet rs = JDBCUtil.queryData(sql.toString());
        List<Order> IndentList = new ArrayList<Order>();

        while(rs.next())
        {
            Order i = new Order();

            i.setActionid(rs.getLong("actionid"));
            i.setUsername(rs.getString("username"));
            i.setGoodname(rs.getString("goodname"));
            i.setProductnum(rs.getInt("productnum"));
            i.setActiondate(rs.getDate("actiondate"));
            i.setState(rs.getString("state"));
            i.setRelname(rs.getString("relname"));
            i.setMobile(rs.getString("mobile"));
            i.setAddress(rs.getString("address"));
            i.setPostcode(rs.getString("postcode"));
            i.setPrice(rs.getDouble("price"));
            i.setMemberprice(rs.getDouble("memberprice"));
            i.setTotal(rs.getDouble("total"));
            i.setPicurl(rs.getString("picurl"));

            IndentList.add(i);
        }
        return IndentList;
    }

    /**
     * 立即购买
     * @param goodId
     * @param userId
     * @param num
     * @return
     * @throws Exception
     */
    public int buyGoods(long goodId, long userId, int num) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("insert into t_indent_info(userid,id,actiondate,productnum)values(")
           .append(userId).append(",").append(goodId).append(",'").append(df.format(new Date()))
           .append("',").append(num).append(");");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 修改订单状态
     * @param state
     * @param actionid
     * @return
     * @throws Exception
     */
    public int upIndent(String state, long actionid) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("update t_indent_info set state='").append(state).append("' where actionid=")
           .append(actionid).append(";");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }
}