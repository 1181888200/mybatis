package com.lwl.mybatis.day1;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @description： JDBC的连接类
 * @author     ：lwl
 * @date       ：2020/6/24 14:27
 * @version:     1.0.0
 */
@Slf4j
public class JdbcUtil {

    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    /**
     *  数据库连接地址
     *      如果出现中文乱码，请添加 【?useUnicode=true&characterEncoding=utf-8】
     */
    private static final String MYSQL_URL = "jdbc:mysql://192.168.31.33:3306/test?useUnicode=true&characterEncoding=utf-8";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "123456";


    /**
     *  获取JDBC的连接
     * result:
     * author: lwl
     * date: 2020/6/24 14:19
     */
    public Connection getConnection() {
        Connection con = null;
       try{
           // 加载驱动
           Class.forName(DRIVER_CLASS_NAME);
           // 获取连接
           con = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
       } catch (ClassNotFoundException e) {
           log.error("加载JDBC驱动异常",e);
       } catch (SQLException e) {
           log.error("获取JDBC连接异常",e);
       }
        return con;
    }


    /**
     *  关闭资源
     * result:
     * author: lwl
     * date: 2020/6/24 14:21
     */
    public void closeResource(Connection con, PreparedStatement pstmt, ResultSet rs) {
        //关闭资源,倒关
        try {
            if(rs != null) {
                rs.close();
            }
            if(pstmt != null) {
                pstmt.close();
            }
            if(con != null) {
                con.close();  //必须要关
            }
        } catch (Exception e) {
            log.error("关闭资源异常", e);
        }
    }

}
