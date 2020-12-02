package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.RoleAuthMapper;
import com.bjpowernode.service.RoleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleAuthServiceImpl implements RoleAuthService {

    @Autowired
    RoleAuthMapper roleAuthMapper;

    @Override
    public int save(int roleId, int[] authIds) {
        int num = 0;
        //删除旧权限
        roleAuthMapper.deleteByRole(roleId);

        if(authIds != null && authIds.length > 0){
            //写入新权限
            num = roleAuthMapper.insertBatch(roleId,authIds);
        }
        return num;
    }
}
