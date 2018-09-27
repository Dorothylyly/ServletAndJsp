package com.pojo;

/**
 * 管理员模型 */
public class Manager
{
    private Long id; // 管理员编号
    private String admin; // 管理员用户名
    private String pwd; // 管理员密码
    private String rank; // 管理员权限
    private String email; // 管理员邮箱

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAdmin()
    {
        return admin;
    }

    public void setAdmin(String admin)
    {
        this.admin = admin;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}