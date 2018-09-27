package com.pojo;

/**
 * 商品模型
 */
public class Good
{
    private Long id; // 农产品编码
    private String goodname; // 农产品名称
    private String look; // 农产品外观
    private Double price; // 农产品市场价
    private String address; // 农产品产地
    private String season; // 农产品上市季节
    private String taste; // 农产品口感
    private String picurl; // 缩略图

    public String getPicurl()
    {
        return picurl;
    }

    public void setPicurl(String picurl)
    {
        this.picurl = picurl;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getGoodname()
    {
        return goodname;
    }

    public void setGoodname(String goodname)
    {
        this.goodname = goodname;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
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