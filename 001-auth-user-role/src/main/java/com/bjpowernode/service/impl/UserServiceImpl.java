package com.bjpowernode.service.impl;

import com.bjpowernode.entity.User;
import com.bjpowernode.mapper.UserMapper;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {

        return userMapper.selectAll();
    }

    @Override
    public User get(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(int userId) {

        userMapper.deleteByPrimaryKey(userId);
    }
}
