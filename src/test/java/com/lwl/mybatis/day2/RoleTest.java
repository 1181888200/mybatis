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
    }

}
