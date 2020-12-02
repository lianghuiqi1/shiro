package com.bjpowernode.service.impl;

import com.bjpowernode.entity.Auth;

import com.bjpowernode.mapper.AuthMapper;
import com.bjpowernode.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> list() {
        return authMapper.selectAll();
    }

    @Override
    public List<Auth> listByUser(int userId) {
        return authMapper.selectByUser(userId);
    }

    @Override
    public List<Auth> listByRole(int roleId) {

        return authMapper.selectByRole(roleId);

    }

    @Override
    public Auth get(int authId) {
        return authMapper.selectByPrimaryKey(authId);
    }

    @Override
    public void save(Auth auth) {
        authMapper.insert(auth);
    }


    @Override
    public void update(Auth auth) {
        authMapper.updateByPrimaryKey(auth);
    }

    @Override
    public void delete(int authId) {

        authMapper.deleteByPrimaryKey(authId);
    }
}
