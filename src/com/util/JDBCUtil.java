package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库操作公用类（JDBC）
 */
public class JDBCUtil
{

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    static
    {
        // 连接数据库(仅连一次)
        if(!CommonUtil.isConn)
        {
            try
            {
                CommonUtil.isConn = connectDB("com.mysql.jdbc.Driver", "mysql", "localhost",
                                              "3306", "GoodsSaleDB", "root", "123456");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 连接数据库
     * @param driverStr
     *        ：驱动类的字符串
     * @param dbmsName
     *        ：数据库管理系统名(小写)
     * @param serverName
     *        ：服务器名
     * @param port
     *        ：端口号
     * @param dbName
     *        ：数据库名
     * @param user
     *        ：用户名
     * @param pwd
     *        ：密码
     * @return
     * @throws Exception
     */
    public static boolean connectDB(String driverStr, String dbmsName, String serverName,
            String port, String dbName, String user, String pwd) throws Exception
    {
        String url = "";

        // 加载并注册驱动
        Class.forName(driverStr);
        if("sqlserver".equals(dbmsName))
        {
            url = "jdbc:" + dbmsName + "://" + serverName + ":" + port + ";databaseName=" + dbName;
        }
        else
            if("mysql".equals(dbmsName))
            {
                url = "jdbc:" + dbmsName + "://" + serverName + ":" + port + "/" + dbName
                        + "?useUnicode=true&characterEncoding=UTF-8";
                // +"&useUnicode=true&characterEncoding=UTF-8"
            }
            else
                if("oracle".equals(dbmsName))
                {
                    url = "jdbc:" + dbmsName + ":thin:@" + serverName + ":" + port + ":" + dbName;
                }

        // 连接数据库
        conn = DriverManager.getConnection(url, user, pwd);
        stmt = conn.createStatement();
        return true;
    }

    /**
     * 查询
     * @param sql
     * @return
     * @throws Exception
     */
    public static ResultSet queryData(String sql) throws Exception
    {
        rs = stmt.executeQuery(sql);
        return rs;
    }

    /**
     * 更新(增、删、改)
     * @param sql
     * @return
     * @throws Exception
     */
    public static int updateData(String sql) throws Exception
    {
        System.out.println("LLLLLLLLLLLL55555555555");
        int iFlag = stmt.executeUpdate(sql);
        System.out.println("LLLLLLLLLLLL66666666666");
        return iFlag;
    }

    /**
     * 关闭数据库对象
     * @return
     * @throws Exception
     */
    public static boolean closeDB() throws Exception
    {
        if(rs != null)
        {
            rs.close();
        }
        if(stmt != null)
        {
            stmt.close();
        }
        if(conn != null)
        {
            conn.close();
        }
        return true;
    }

    public static Connection getConn()
    {
        return conn;
    }

}
