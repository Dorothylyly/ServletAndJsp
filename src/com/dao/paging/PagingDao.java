package com.dao.paging;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Good;
import com.pojo.Order;
import com.util.JDBCUtil;

/**
 * 分页dao层
 */
public class PagingDao
{
    private StringBuffer sql = null;

    /**
     * 获取总记录数
     * @param table
     * @return
     * @throws Exception
     */
    public int getTotalrows(String table) throws Exception
    {
        int iFlag = 0;
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) from ").append(table).append(";");

        ResultSet rs = JDBCUtil.queryData(sql.toString());

        if(rs.next())
        {
            iFlag = rs.getInt(1);
        }
        return iFlag;
    }

    /**
     * 获取页面数据（商品）
     * @param table
     * @param fromIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<Good> getGoodPagedata(String table, int fromIndex, int pageSize) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from ").append(table).append(" limit ?,?");

        PreparedStatement pstmt = JDBCUtil.getConn().prepareStatement(sql.toString());
        pstmt.setInt(1, fromIndex);
        pstmt.setInt(2, pageSize);

        ResultSet rs = pstmt.executeQuery();

        List<Good> goodList = new ArrayList<Good>();
        while(rs.next())
        {
            Good g = new Good();

            g.setId(rs.getLong("id"));
            g.setGoodname(rs.getString("goodname"));
            g.setLook(rs.getString("look"));
            g.setPrice(rs.getDouble("price"));
            g.setAddress(rs.getString("address"));
            g.setSeason(rs.getString("season"));
            g.setTaste(rs.getString("taste"));
            g.setPicurl(rs.getString("picurl"));

            goodList.add(g);
        }
        return goodList;
    }

    /**
     * 获取页面数据（订单）
     * @param table
     * @param fromIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<Order> getIndentPagedata(String table, int fromIndex, int pageSize)
            throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from ").append(table).append(" limit ?,?");

        PreparedStatement pstmt = JDBCUtil.getConn().prepareStatement(sql.toString());
        pstmt.setInt(1, fromIndex);
        pstmt.setInt(2, pageSize);

        ResultSet rs = pstmt.executeQuery();

        List<Order> indentList = new ArrayList<Order>();
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

            indentList.add(i);
        }
        return indentList;
    }
}