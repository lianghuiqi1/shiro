package com.bjpowernode.service.impl;


import com.bjpowernode.mapper.UserAuthMapper;
import com.bjpowernode.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    UserAuthMapper userAuthMapper;


    @Override
    public int save(int userId, int[] authIds) {
        //删除旧权限
        userAuthMapper.deleteByUser(userId);
        //保存新权限
        int i = 0;
        if(authIds != null && authIds.length > 0){
          i =  userAuthMapper.insertBatch(userId,authIds);

        }
        return i;
    }
}
