package com.pojo;

import java.util.Date;

/**
 * 订单模型 */
public class Order
{
    private Long actionid; // 订单编号
    private Long userid; // 用户编号
    private Long id; // 商品编码
    private String username; // 用户名
    private String goodname; // 商品名称
    private Integer productnum; // 订单数量
    private Date actiondate; // 订单日期
    private String state; // 订单状态
    private String mobile; // 用户移动电话
    private String relname; // 真实名字
    private String address; // 收货地址
    private String postcode; // 邮政编码
    private Double price; // 商品市场价
    private Double memberprice; // 商品会员价
    private Double total; // 总价格
    private String picurl; // 商品图片地址

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getRelname()
    {
        return relname;
    }

    public void setRelname(String relname)
    {
        this.relname = relname;
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

    public Long getActionid()
    {
        return actionid;
    }

    public void setActionid(Long actionid)
    {
        this.actionid = actionid;
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

    public Integer getProductnum()
    {
        return productnum;
    }

    public void setProductnum(Integer productnum)
    {
        this.productnum = productnum;
    }

    public Date getActiondate()
    {
        return actiondate;
    }

    public void setActiondate(Date actiondate)
    {
        this.actiondate = actiondate;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getMemberprice()
    {
        return memberprice;
    }

    public void setMemberprice(Double memberprice)
    {
        this.memberprice = memberprice;
    }

    public Double getTotal()
    {
        return total;
    }

    public void setTotal(Double total)
    {
        this.total = total;
    }
}