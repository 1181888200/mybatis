package com.lwl.mybatis.day1;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @description： 用户的操作类
 * @author     ：lwl
 * @date       ：2020/6/24 15:29
 * @version:     1.0.0
 */
@Slf4j
public class UserJdbc extends JdbcUtil {

    public int addUser (User user) {
        Connection con = getConnection();
        PreparedStatement psst = null;
        String sql = "insert into user (name, password, sex, phone) VALUES(?,?,?,?)";
        try{
            //设置的预编译语句格式
            psst = con.prepareStatement(sql);
            psst.setString(1, user.getName());
            psst.setString(2, user.getPassword());
            psst.setString(3, user.getSex());
            psst.setString(4, user.getPhone());
            log.info("---------正在执行的sql----------");
            log.info(psst.toString());
            return psst.executeUpdate();
        } catch (Exception e) {
            log.error("新增用户信息异常",e);
        }finally {
            closeResource(con, psst, null);
        }
        return 0;
    }

    public int del (long id) {
        Connection con = getConnection();
        PreparedStatement psst = null;
        String sql = "delete from user where id = ?";
        try{
            //设置的预编译语句格式
            psst = con.prepareStatement(sql);
            psst.setLong(1, id);
            log.info("---------正在执行的sql----------");
            log.info(psst.toString());
            return psst.executeUpdate();
        } catch (Exception e) {
            log.error("删除用户信息异常",e);
        }finally {
            closeResource(con, psst, null);
        }
        return 0;
    }


    public List<User> list() {
        List<User> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement psst = null;
        ResultSet resultSet = null;
        String sql = "select * from user";
        try{
            psst = con.prepareStatement(sql);
            log.info("---------正在执行的sql----------");
            log.info(psst.toString());
            resultSet = psst.executeQuery();
            // 从结果集中取数据
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                String password = resultSet.getString(4);
                String phone = resultSet.getString(5);
                User user = new User();
                user.setName(name).setSex(sex).setPhone(phone).setPassword(password).setId(id);
                list.add(user);
            }
        } catch (Exception e) {
            log.error("获取用户集合异常",e);
        } finally {
            closeResource(con, psst, resultSet);
        }
        return list;
    }

    public int update(User user){
        Connection con = getConnection();
        PreparedStatement psst = null;
        String sql = "update  user set name = ?, phone = ?, sex = ?, modify_time = now() where id = ?";

        try{
            psst = con.prepareStatement(sql);
            psst.setString(1, user.getName());
            psst.setString(2, user.getPhone());
            psst.setString(3, user.getSex());
            psst.setLong(4, user.getId());
            log.info("---------正在执行的sql----------");
            log.info(psst.toString());
            return psst.executeUpdate();
        } catch (Exception e) {
            log.error("更新用户信息异常",e);
        }finally {
            closeResource(con, psst, null);
        }
        return 0;
    }

}
