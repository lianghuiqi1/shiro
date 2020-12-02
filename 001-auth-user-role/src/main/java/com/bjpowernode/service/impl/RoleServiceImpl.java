package com.bjpowernode.service.impl;

import com.bjpowernode.entity.Role;
import com.bjpowernode.mapper.RoleMapper;
import com.bjpowernode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> list() {

        return roleMapper.selectAll();
    }

    @Override
    public List<Role> listByUser(int userId) {

        return roleMapper.listByUser(userId);

    }

    @Override
    public Role get(int roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public void save(Role role) {
        roleMapper.insertSelective(role);
    }

    @Override
    public void update(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void delete(int roleId) {

        roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Role findRole(Role role) {
        return roleMapper.selectRole(role);
    }
}
