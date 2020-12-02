package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.UserRoleMapper;
import com.bjpowernode.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public int save(int userId, int[] roleIds) {
        int i = 0;
        //删除旧角色
        userRoleMapper.deleteByUser(userId);

        //保存新角色
        if(roleIds != null && roleIds.length > 0){
            i = userRoleMapper.insertBatch(userId, roleIds);
        }
        return i;
    }
}
