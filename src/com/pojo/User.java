package com.pojo;

import java.io.Serializable;

/**
 * �û� */
public class User implements Serializable
{

    /**
	 * 
	 */
    private static final long serialVersionUID = 9126352579409448012L;

    private Long userid; // �û����
    private String username; // �˺�
    private String pwd; // �û�����
    private String name; // �ǳ�
    private String useremail; // �û�����
    private String mobile; // �û��ƶ��绰
    private String relname; // ����
    private String sex; // �û��Ա�
    private String city; // �ջ�����
    private String address; // �ջ���ַ
    private String postcode; // ��������
    private String tel; // �û��绰
    private String vip; // �Ƿ�VIP�û�
    private Integer score; // �û�����

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUseremail()
    {
        return useremail;
    }

    public void setUseremail(String useremail)
    {
        this.useremail = useremail;
    }

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

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getVip()
    {
        return vip;
    }

    public void setVip(String vip)
    {
        this.vip = vip;
    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        return "User [userid=" + userid + ", username=" + username + ", pwd=" + pwd + ", name="
                + name + ", useremail=" + useremail + ", mobile=" + mobile + ", relname=" + relname
                + ", sex=" + sex + ", city=" + city + ", address=" + address + ", postcode="
                + postcode + ", tel=" + tel + ", vip=" + vip + ", score=" + score + "]";
    }

}
