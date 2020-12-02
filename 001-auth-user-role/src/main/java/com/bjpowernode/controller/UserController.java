package com.bjpowernode.controller;

import com.bjpowernode.entity.Auth;
import com.bjpowernode.entity.Role;
import com.bjpowernode.entity.User;
import com.bjpowernode.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;//用户服务

    @Autowired
    AuthService authService;//权限服务

    @Autowired
    RoleService roleService;//角色服务

    @Autowired
    UserAuthService userAuthService;//用户权限服务


    @Autowired
    UserRoleService userRoleService;//用户角色服务

    @RequestMapping("list")
    public List<User> list(){
        return userService.list();
    }

    @RequestMapping("add")
    public String add(User user){

        return "user/edit";
    }

    @RequestMapping("save")
    public String save(User user){

        userService.save(user);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(User user, int userId){

        BeanUtils.copyProperties(userService.get(userId),user);

        return "user/edit";
    }

    @RequestMapping("saveUpdate")
    public String saveUpdate(User user){

        userService.update(user);

        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int userId){

        userService.delete(userId);

        return "redirect:list";
    }


    @RequestMapping("auth")
    public String auth(int userId, Model model){

        //用户的年龄、性别等详细信息
        User user =  userService.get(userId);

        //查询所有的权限
        model.addAttribute("authList",authService.list());

        //查询所有的角色
        model.addAttribute("roleList",roleService.list());

        //根据用户的id，多对多查询此用户拥有的权限
        List<Auth> authList = authService.listByUser(userId);
        Set<Integer> authIds = new HashSet<>();
        if(authList != null && authList.size() > 0){
            for(Auth auth : authList){
                authIds.add(auth.getAuthId());
            }
        }

        //根据用户的id，多对多查询此用户拥有的角色
        List<Role> roleList = roleService.listByUser(userId);
        List<Integer> roleIds = new ArrayList<>();
        if(roleList != null && roleList.size() > 0){
            for (Role role : roleList) {
                roleIds.add(role.getRoleId());
                //根据用户所拥有的角色的id，查询用户所拥有的权限
                List<Auth> auths = authService.listByRole(role.getRoleId());
                for (Auth auth : auths) {
                    authIds.add(auth.getAuthId());
                }
            }
        }
        user.setRoleIds(roleIds);
        user.setAuthIds(authIds);

        model.addAttribute("user",user);
        return "/user/auth";
    }


    @RequestMapping("saveAuth")
    public String saveAuth(User user,int[] authIds,int[] roleIds){

        //修改用户表的字段
        userService.update(user);


        //修改用户权限
        userAuthService.save(user.getUserId(), authIds);

        //修改用户角色
        userRoleService.save(user.getUserId(), roleIds);

        return "redirect:list";
    }


}
