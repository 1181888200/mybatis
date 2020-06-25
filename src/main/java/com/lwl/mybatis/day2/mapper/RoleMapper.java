package com.lwl.mybatis.day2.mapper;

import com.lwl.mybatis.day2.domain.Role;

import java.util.List;

public interface RoleMapper {

    int insert(Role role);

    int update(Role role);

    int delOne(long id);

    Role findOne(long id);

    List<Role> list();


}
