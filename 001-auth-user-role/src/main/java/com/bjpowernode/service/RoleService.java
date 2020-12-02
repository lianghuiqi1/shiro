package com.bjpowernode.service;

import com.bjpowernode.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> list();

    Role get(int userId);

    List<Role> listByUser(int userId);

    void save(Role role);

    void update(Role role);

    void delete(int roleId);


    Role findRole(Role role);
}
