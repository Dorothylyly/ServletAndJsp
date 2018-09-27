package com.dao.manager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Manager;
import com.util.JDBCUtil;

/**
 * 管理员dao层 */
public class ManagerDao
{
    private StringBuffer sql = null;

    /**
     * 管理员登录
     * @param lManager
     * @return
     * @throws Exception
     */
    public boolean login(Manager lManager) throws Exception
    {
        boolean bFlag = false;
        sql = new StringBuffer("");
        sql.append("select * from t_controller_info where admin='").append(lManager.getAdmin())
           .append("'");
        ResultSet rs = JDBCUtil.queryData(sql.toString());
        if(!rs.next())
        {
            return bFlag;
        }

        if(lManager.getPwd().equals(rs.getString("pwd")))
        {
            bFlag = true;
            lManager.setId(rs.getLong("id"));
            lManager.setRank(rs.getString("rank"));
            lManager.setEmail(rs.getString("email"));
        }
        return bFlag;
    }

    /**
     * 增加管理员
     * @param nManager
     * @return
     * @throws Exception
     */
    public int addManager(Manager nManager) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("insert into t_controller_info(admin,pwd,rank,email)values('")
           .append(nManager.getAdmin()).append("','").append(nManager.getPwd()).append("','")
           .append(nManager.getRank()).append("','").append(nManager.getEmail()).append("')");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 设置管理员
     * @param uManager
     * @return
     * @throws Exception
     */
    public int updateManager(Manager uManager) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("update t_controller_info set rank='").append(uManager.getRank())
           .append("' where admin='").append(uManager.getAdmin()).append("'");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 删除管理员
     * @param dManager
     * @return
     * @throws Exception
     */
    public int deleteManager(Manager dManager) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("delete from t_controller_info").append(" where admin='")
           .append(dManager.getAdmin()).append("'");

        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 修改密码
     * @param cManager
     * @param newPwd
     * @return
     * @throws Exception
     */
    public int modifyPwd(Manager cManager, String newPwd) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("update t_controller_info set pwd='").append(newPwd).append("' where admin='")
           .append(cManager.getAdmin()).append("';");
        int iFlag = JDBCUtil.updateData(sql.toString());
        return iFlag;
    }

    /**
     * 查询所有管理员
     * @return
     * @throws Exception
     */
    public List<Manager> findAll() throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from t_controller_info");
        ResultSet rs = JDBCUtil.queryData(sql.toString());

        List<Manager> managerList = new ArrayList<Manager>();
        while(rs.next())
        {
            Manager m = new Manager();
            m.setId(rs.getLong("id"));
            m.setAdmin(rs.getString("admin"));
            m.setPwd(rs.getString("pwd"));
            m.setRank(rs.getString("rank"));
            m.setEmail(rs.getString("email"));

            managerList.add(m);
        }
        return managerList;
    }

    /**
     * 查询一个管理员
     * @param admin
     * @return
     * @throws Exception
     */
    public Manager findByAdmin(String admin) throws Exception
    {
        sql = new StringBuffer("");
        sql.append("select * from t_controller_info where admin='").append(admin).append("'");
        ResultSet rs = JDBCUtil.queryData(sql.toString());

        if(!rs.next())
        {
            return null;
        }

        Manager m = new Manager();
        m.setId(rs.getLong("id"));
        m.setAdmin(rs.getString("admin"));
        m.setPwd(rs.getString("pwd"));
        m.setRank(rs.getString("rank"));
        m.setEmail(rs.getString("email"));
        return m;
    }
}