package com.dao.shoppingcar;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Shoppingcar;
import com.util.JDBCUtil;

/**
 * 购物车dao层
 */
public class ShoppingcarDao
{
    private StringBuffer sql = null;

    /**
     * 增加商品到购物车
     * @param nShoppingcard
     * @return
     * @throws Exception
     */
    public int addShoppingcar(Shoppingcar nShoppingcard) throws Exception
    {
        System.out.println("LLLLLLLLLLLL111111111111111");
        sql = new StringBuffer("");

        sql.append("insert into t_shoppingcar_info(userid,id)values('")
           .append(nShoppingcard.getUserid()).append("','").append(nShoppingcard.getId())
           .append("');");

        System.out.println(sql);

        System.out.println("LLLLLLLLLLLL33333333333");
        int iFlag = JDBCUtil.updateData(sql.toString());
        System.out.println("LLLLLLLLLLLL444444444444");
        return iFlag;
    }

    /**
     * 查询购物车
     * @param username
     * @return
     * @throws Exception
     */
    public List<Shoppingcar> findAll(String username) throws Exception
    {
        System.out.println("LLLLLLLLLLLL22222222222222222");
        sql = new StringBuffer("");
        sql.append("select * from v_shoppingcar where username='").append(username)
           .append("' and STATUS='未购买';");

        ResultSet rs = JDBCUtil.queryData(sql.toString());
        List<Shoppingcar> ShoppingcarList = new ArrayList<Shoppingcar>();

        while(rs.next())
        {
            Shoppingcar s = new Shoppingcar();

            s.setPicurl(rs.getString("picurl"));
            s.setUsername(rs.getString("username"));
            s.setGoodname(rs.getString("goodname"));

            s.setPrice(rs.getDouble("price"));
            s.setAddress(rs.getString("address"));
            s.setSeason(rs.getString("season"));

            ShoppingcarList.add(s);
        }
        return ShoppingcarList;
    }
}
