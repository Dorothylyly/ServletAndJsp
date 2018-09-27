package com.dao.user;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.User;
import com.util.JDBCUtil;

/**
 * 用户dao层 */
public class UserDao
{
    private StringBuffer sql = null;

    /**
     * 用户登录
     * @param lUser
     * @return
     * @throws Exception
     */
    public boolean login(User lUser) throws Exception
    {
        boolean bFlag = false;
        sql = new StringBuffer("");
        sql.append("select * from t_user_info where username='").append(lUser.getUsername())
           .append("'");
        ResultSet rs = JDBCUtil.queryData(sql.toString());
        if(!rs.next())
        {
            return bFlag;
        }

        if(lUser.getPwd().equals(rs.getString("pwd")))
        {
            bFlag = true;
            lUser.setUserid(rs.getLong("userid"));
            lUser.setName(rs.getString("name"));
            lUser.setUseremail(rs.getString("useremail"));
            lUser.setMobile(rs.getString("mobile"));
            lUser.setRelname(rs.getString("relname"));
            lUser.setSex(rs.getString("sex"));
            lUser.setCity(rs.getString("city"));
            lUser.setAddress(rs.getString("address"));
            lUser.setPostcode(rs.getString("postcode"));
            lUser.setTel(rs.getString("tel"));
            lUser.setVip(rs.getString("vip"));
            lUser.setScore(rs.getInt("score"));
        }
        return bFlag;
    }

    /**
     * 添加用户
     * @param nUser
     * @return
     * @throws Exception
     */
    public int addUser(User nUser) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("insert into t_user_info(username,pwd,vip)values('").append(nUser.getUsername())
           .append("','").append(nUser.getPwd()).append("','").append(nUser.getVip()).append("');");
        int iFlag = JDBCUtil.updateData(sql.toString());

        return iFlag;
    }

    /**
     * 注册用户
     * @param nUser
     * @return
     * @throws Exception
     */
    public int register(User nUser) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("insert into t_user_info(username,pwd)values('").append(nUser.getUsername())
           .append("','").append(nUser.getPwd()).append("');");
        int iFlag = JDBCUtil.updateData(sql.toString());

        return iFlag;
    }

    /**
     * 查询用户存在
     * @param user
     * @return
     * @throws Exception
     */
    public boolean queryUser(User user) throws Exception
    {
        boolean bFlag = false;
        sql = new StringBuffer("");
        sql.append("select * from t_user_info where username='").append(user.getUsername())
           .append("'");
        ResultSet rs = JDBCUtil.queryData(sql.toString());
        if(rs.next())
        {
            bFlag = true;
        }
        return bFlag;
    }

    /**
     * 修改资料
     * @param uUser
     * @return
     * @throws Exception
     */
    public int updateUser(User uUser) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("update t_user_info set NAME='").append(uUser.getName()).append("',useremail='")
           .append(uUser.getUseremail()).append("',mobile='").append(uUser.getMobile())
           .append("',relname='").append(uUser.getRelname()).append("',sex='")
           .append(uUser.getSex()).append("',city='").append(uUser.getCity()).append("',address='")
           .append(uUser.getAddress()).append("',postcode='").append(uUser.getPostcode())
           .append("',tel='").append(uUser.getTel()).append("' where username='")
           .append(uUser.getUsername()).append("'");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 删除用户
     * @param dUser
     * @return
     * @throws Exception
     */
    public int deleteUser(User dUser) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("delete from t_user_info").append(" where username='")
           .append(dUser.getUsername()).append("'");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 修改密码
     * @param cUser
     * @param newPwd
     * @return
     * @throws Exception
     */
    public int modifyPwd(User cUser, String newPwd) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("update t_user_info set pwd='").append(newPwd).append("' where username='")
           .append(cUser.getUsername()).append("'");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 用户修改密码
     * @param cUser
     * @param newPwd
     * @return
     * @throws Exception
     */
    public int upUserPwd(String cUser, String newPwd) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("update t_user_info set pwd='").append(newPwd).append("' where username='")
           .append(cUser).append("'");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    public List<User> findAll() throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from t_user_info");
        ResultSet rs = JDBCUtil.queryData(sql.toString());

        List<User> userList = new ArrayList<User>();
        while(rs.next())
        {
            User u = new User();
            u.setUserid(rs.getLong("userid"));
            u.setUsername(rs.getString("username"));
            u.setPwd(rs.getString("pwd"));
            u.setName(rs.getString("NAME"));
            u.setUseremail(rs.getString("useremail"));
            u.setMobile(rs.getString("mobile"));
            u.setRelname(rs.getString("relname"));
            u.setSex(rs.getString("sex"));
            u.setCity(rs.getString("city"));
            u.setAddress(rs.getString("address"));
            u.setPostcode(rs.getString("postcode"));
            u.setTel(rs.getString("tel"));
            u.setVip(rs.getString("vip"));
            u.setScore(rs.getInt("score"));

            userList.add(u);
        }
        return userList;
    }

    /**
     * 查询一个用户
     * @param userName
     * @return
     * @throws Exception
     */
    public User findByUserName(String userName) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from t_user_info where username='").append(userName).append("'");
        ResultSet rs = JDBCUtil.queryData(sql.toString());

        if(!rs.next())
        {
            return null;
        }

        User user = new User();
        user.setUserid(rs.getLong("userid"));
        user.setUsername(rs.getString("username"));
        user.setPwd(rs.getString("pwd"));
        user.setName(rs.getString("NAME"));
        user.setUseremail(rs.getString("useremail"));
        user.setMobile(rs.getString("mobile"));
        user.setRelname(rs.getString("relname"));
        user.setSex(rs.getString("sex"));
        user.setCity(rs.getString("city"));
        user.setAddress(rs.getString("address"));
        user.setPostcode(rs.getString("postcode"));
        user.setTel(rs.getString("tel"));
        user.setVip(rs.getString("vip"));
        user.setScore(rs.getInt("score"));

        return user;
    }
}