package com.dao.shoppingcar;

import java.util.List;

import com.pojo.Shoppingcar;

/**
 * 购物车业务层 */
public class ShoppingcarManager
{
    ShoppingcarDao shoppingcarDao = new ShoppingcarDao();

    /**
     * 添加到购物车
     * @param nShoppingcar
     * @return
     */
    public boolean addGood(Shoppingcar nShoppingcar)
    {
        boolean bFlag = false;
        try
        {
            int iFlag = shoppingcarDao.addShoppingcar(nShoppingcar);
            bFlag = iFlag > 0 ? true : false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return bFlag;
    }

    /**
     * 查询购物车
     * @param username
     * @return
     */
    public List<Shoppingcar> findAll(String username)
    {
        List<Shoppingcar> ShoppingcarList = null;
        try
        {
            ShoppingcarList = shoppingcarDao.findAll(username);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return ShoppingcarList;
    }
}
