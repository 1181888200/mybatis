package com.lwl.mybatis.day1;

import java.util.List;

/**
 * @description： 测试类
 * @author     ：lwl
 * @date       ：2020/6/24 14:28
 * @version:     1.0.0
 */

public class UserJdbcTest {

    public static void main(String[] args) {
        // 测试新增
//        addUserTest();
        /**
         * ---------正在执行的sql----------
         * com.mysql.cj.jdbc.ClientPreparedStatement: insert into user (name, password, sex, phone) VALUES('帅气的劉先生','66666666666','男','18888888888')
         * 运行结果：true
         */



        // 测试删除
//        delUserTest(4);
        // 运行结果：true
        /**
         * 如果删除一个不存在的，则返回false
         *
         * ---------正在执行的sql----------
         * com.mysql.cj.jdbc.ClientPreparedStatement: delete from user where id = 4
         * 运行结果：false
         *
         */


        // 测试获取集合
//        List<User> list = list();
        /**
         * 运行结果
         *   ---------正在执行的sql----------
         * com.mysql.cj.jdbc.ClientPreparedStatement: select * from user
         * 运行结果如下：
         * User{id='2'name='lwl', sex='男', password='123456', phone='18888888888'} BaseModel(id=2, createUser=null, createTime=null, modifyUser=null, modifyTime=null)
         * User{id='3'name='lwl', sex='?', password='123456', phone='18888888888'} BaseModel(id=3, createUser=null, createTime=null, modifyUser=null, modifyTime=null)
         * User{id='5'name='帅气的劉先生', sex='男', password='66666666666', phone='18888888888'} BaseModel(id=5, createUser=null, createTime=null, modifyUser=null, modifyTime=null)
         */



        // 更新某个对象
//        update(6, "刘先生66666", "18800006666", "未知");
        /**
         * 运行结果：
         * ---------正在执行的sql----------
         * com.mysql.cj.jdbc.ClientPreparedStatement: update  user set name = '刘先生', phone = '18800001234', sex = '未知', modify_time = now() where id = 2
         * 运行结果：true
         */

    }


    private static void addUserTest() {
        // 初始化数据类
        User user = new User();
        user.setName("帅气的劉先生").setPassword("66666666666")
                .setPhone("18888888888").setSex("男");
        UserJdbc userJdbc = new UserJdbc();
        int num = userJdbc.addUser(user);
        // 是否成功 如果成功则返回影响的记录数
        System.out.println("运行结果：" + (num==1));
    }

    private static void delUserTest(long id) {
        UserJdbc userJdbc = new UserJdbc();
        int num = userJdbc.del(id);
        // 是否成功 如果成功则返回影响的记录数
        System.out.println("运行结果：" + (num==1));
    }

    private static List<User> list() {
        UserJdbc userJdbc = new UserJdbc();
        List<User> list =  userJdbc.list();
        // 打印输出结果
        System.out.println("运行结果如下：");
        list.forEach(System.out::println);
        return list;
    }


    private static void update(long id, String name, String phone, String sex) {
        UserJdbc userJdbc = new UserJdbc();
        User user = new User();
        user.setPhone(phone).setSex(sex).setName(name).setId(id);
        int num = userJdbc.update(user);
        System.out.println("运行结果：" + (num==1));
    }

}
