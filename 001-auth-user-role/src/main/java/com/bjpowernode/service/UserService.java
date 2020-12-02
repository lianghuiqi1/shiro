package com.bjpowernode.service;

import com.bjpowernode.entity.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User login(User user);

    User get(int userId);

    void save(User user);

    void update(User user);

    void delete(int userId);




}
