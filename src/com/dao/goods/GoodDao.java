package com.dao.goods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Good;
import com.util.JDBCUtil;

/**
 * 商品dao层
 */
public class GoodDao
{
    private StringBuffer sql = null;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 增加商品
     * @param nGood
     * @return
     * @throws Exception
     */
    public int addGood(Good nGood) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("insert into goods_info(goodname,price,look,address,season,,picurl)values('")
           .append(nGood.getGoodname()).append("',").append(nGood.getPrice()).append(",")
           .append(nGood.getLook()).append(",").append(nGood.getAddress()).append(",")
           .append(nGood.getSeason()).append(",'").append(nGood.getPicurl()).append("','")
           .append("');");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 修改商品
     * @param uGood
     * @return
     * @throws Exception
     */
    public int updateGood(Good uGood) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("update goods_info set goodname='").append(uGood.getGoodname())
           .append("',price=").append(uGood.getPrice()).append(",look=").append(uGood.getLook())
           .append(",address=").append(uGood.getAddress()).append(",season=")
           .append(uGood.getSeason()).append(",taste=").append(uGood.getTaste())
           .append("' where id=").append(uGood.getId()).append(";");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 删除商品
     * @param dGood
     * @return
     * @throws Exception
     */
    public int deleteGood(Good dGood) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("delete from goods_info ").append(" where id=").append(dGood.getId())
           .append(";");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 查询所有的商品
     * @return
     * @throws Exception
     */
    public List<Good> findAll() throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from goods_info");
        ResultSet rs = JDBCUtil.queryData(sql.toString());

        List<Good> GoodList = new ArrayList<Good>();
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

            GoodList.add(g);
        }
        return GoodList;
    }

    /**
     * 查询最新商品的前12个商品
     * @return
     * @throws Exception
     */
    public List<Good> findTwelve() throws Exception
    {
        sql = new StringBuffer("");
        sql.append("SELECT * FROM goods_info ORDER BY id DESC LIMIT 12;");
        ResultSet rs = JDBCUtil.queryData(sql.toString());

        List<Good> GoodList = new ArrayList<Good>();
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

            GoodList.add(g);
        }
        return GoodList;
    }

    /**
     * 查询一个商品
     * @param id
     * @return
     * @throws Exception
     */
    public Good findById(Long id) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from goods_info where id=?");

        PreparedStatement pstmt = JDBCUtil.getConn().prepareStatement(sql.toString());
        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();
        if(!rs.next())
        {
            return null;
        }

        Good g = new Good();

        g.setId(rs.getLong("id"));
        g.setGoodname(rs.getString("goodname"));
        g.setLook(rs.getString("look"));
        g.setPrice(rs.getDouble("price"));
        g.setAddress(rs.getString("address"));
        g.setSeason(rs.getString("season"));
        g.setTaste(rs.getString("taste"));
        g.setPicurl(rs.getString("picurl"));

        System.out.println("OOOOOOOOOOOO");
        System.out.println(id);

        rs.close();
        pstmt.close();

        return g;
    }
}
