package com.pojo;

/**
 * 购物车模型
 */
public class Shoppingcar
{
    private Long shopid; // 购物车编号
    private Long userid; // 用户编号
    private String username; // 用户名
    private Long id; // 农产品编码
    private String goodname; // 农产品名称
    private String look; // 农产品外观
    private Double price; // 农产品市场价
    private String address; // 农产品产地
    private String season; // 农产品上市季节
    private String taste; // 农产品口感
    private String picurl; // 缩略图
    private Integer shopnum;

    public Integer getShopnum()
    {
        return shopnum;
    }

    public void setShopnum(Integer shopnum)
    {
        this.shopnum = shopnum;
    }

    public String getPicurl()
    {
        return picurl;
    }

    public void setPicurl(String picurl)
    {
        this.picurl = picurl;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getGoodname()
    {
        return goodname;
    }

    public void setGoodname(String goodname)
    {
        this.goodname = goodname;
    }

    public Long getShopid()
    {
        return shopid;
    }

    public void setShopid(Long shopid)
    {
        this.shopid = shopid;
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getLook()
    {
        return look;
    }

    public void setLook(String look)
    {
        this.look = look;
    }

    public String getSeason()
    {
        return season;
    }

    public void setSeason(String season)
    {
        this.season = season;
    }

    public String getTaste()
    {
        return taste;
    }

    public void setTaste(String taste)
    {
        this.taste = taste;
    }
}