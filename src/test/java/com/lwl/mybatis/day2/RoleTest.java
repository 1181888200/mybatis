package com.lwl.mybatis.day2;

import com.lwl.mybatis.day2.domain.Role;
import com.lwl.mybatis.day2.service.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RoleTest {

    @Autowired
    private IRoleService roleService;

    @Test
    public void addTest() {
        Arrays.stream(new int[]{1, 2, 3, 4}).forEach(r->{
            Role role = new Role();
            role.setName("lwl"+r).setRemark("哈哈哈哈哈 => " + r);
            roleService.insert(role);
        });

        /**
         * 运行结果：
         * 2020-06-26 12:10:17 | DEBUG | main | com.lwl.mybatis.day2.mapper.RoleMapper.insert | ==>
         *      Preparing: insert into role (name, remark, create_time) value (?, ?, now())
         *
         * 2020-06-26 12:10:17 | DEBUG | HikariPool-1 housekeeper | com.zaxxer.hikari.pool.HikariPool |
         *  HikariPool-1 - Pool stats (total=1, active=1, idle=0, waiting=0)
         *
         * 2020-06-26 12:10:17 | DEBUG | main | com.lwl.mybatis.day2.mapper.RoleMapper.insert | ==>
         *      Parameters: lwl1(String), 哈哈哈哈哈 => 1(String)
         * 2020-06-26 12:10:17 | DEBUG | main | com.lwl.mybatis.day2.mapper.RoleMapper.insert | <==
         *
         *  Updates: 1
         */
    }

    @Test
    public void  delOne() {
        int i = roleService.delOne(2);
        System.out.println("运行结果：" + (i!=0));
    }

    @Test
    public void  update() {
        Role role = new Role();
        role.setName("噢噢噢噢").setRemark("12311415").setId(3L);
        int i = roleService.update(role);
        System.out.println("运行结果：" + (i!=0));
    }

    @Test
    public void findOneTest() {
        Role one = roleService.findOne(1);
        System.out.println(Optional.ofNullable(one).toString());
    }

    @Test
    public void list() {
        List<Role> list = roleService.list();
        System.out.println("运行结果：");
        list.forEach(System.out::println);
        /**
         * Role{name='lwl1', remark='哈哈哈哈哈 => 1'}
         *      BaseModel(id=5, createUser=null, createTime=Fri Jun 26 12:10:16 CST 2020, modifyUser=null, modifyTime=null)
         * Role{name='lwl2', remark='哈哈哈哈哈 => 2'}
         *      BaseModel(id=6, createUser=null, createTime=Fri Jun 26 12:10:16 CST 2020, modifyUser=null, modifyTime=null)
         * Role{name='lwl3', remark='哈哈哈哈哈 => 3'}
         *      BaseModel(id=7, createUser=null, createTime=Fri Jun 26 12:10:16 CST 2020, modifyUser=null, modifyTime=null)
         * Role{name='lwl4', remark='哈哈哈哈哈 => 4'}
         *      BaseModel(id=8, createUser=null, createTime=Fri Jun 26 12:10:16 CST 2020, modifyUser=null, modifyTime=null)
         *
         */
    }

}
