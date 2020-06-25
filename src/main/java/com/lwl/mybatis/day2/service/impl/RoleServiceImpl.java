package com.lwl.mybatis.day2.service.impl;

import com.lwl.mybatis.day2.domain.Role;
import com.lwl.mybatis.day2.mapper.RoleMapper;
import com.lwl.mybatis.day2.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int delOne(long id) {
        return roleMapper.delOne(id);
    }

    @Override
    public Role findOne(long id) {
        return roleMapper.findOne(id);
    }

    @Override
    public List<Role> list() {
        return roleMapper.list();
    }
}
