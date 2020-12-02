package com.bjpowernode.service;

import com.bjpowernode.entity.Auth;

import java.util.List;

public interface AuthService {

    List<Auth> list();

    List<Auth> listByUser(int userId);

    List<Auth> listByRole(int roleId);

    Auth get(int userId);

    void save(Auth auth);

    void update(Auth auth);

    void delete(int userId);




}
