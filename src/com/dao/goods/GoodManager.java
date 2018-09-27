package com.dao.goods;

import java.util.List;

import com.pojo.Good;

/**
 * 商品业务层 */
public class GoodManager
{
    GoodDao goodDao = new GoodDao();

    /**
     * 增加商品
     * @param nGood
     * @return
     */
    public boolean addGood(Good nGood)
    {
        boolean bFlag = false;
        try
        {
            int iFlag = goodDao.addGood(nGood);
            bFlag = iFlag > 0 ? true : false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return bFlag;
    }

    /**
     * 修改商品
     * @param uGood
     * @return
     */
    public boolean updateGood(Good uGood)
    {
        boolean bFlag = false;
        try
        {
            int iFlag = goodDao.updateGood(uGood);
            bFlag = iFlag > 0 ? true : false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return bFlag;
    }

    /**
     * 删除商品
     * @param dGood
     * @return
     */
    public boolean deleteGood(Good dGood)
    {
        boolean bFlag = false;
        try
        {
            int iFlag = goodDao.deleteGood(dGood);
            bFlag = iFlag > 0 ? true : false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return bFlag;
    }

    /**
     * 查询所有商品
     * @return
     */
    public List<Good> findAll()
    {
        List<Good> GoodList = null;
        try
        {
            GoodList = goodDao.findAll();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return GoodList;
    }

    /**
     * 查询最新商品的前12个商品
     * @return
     */
    public List<Good> findTwelve()
    {
        List<Good> GoodList = null;
        try
        {
            GoodList = goodDao.findTwelve();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return GoodList;
    }

    /**
     * 查询一个商品
     * @param id
     * @return
     */
    public Good findById(Long id)
    {
        Good good = null;
        try
        {
            good = goodDao.findById(id);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return good;
    }
}