package com.bjpowernode.entity;

import java.util.List;
import java.util.Set;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private Integer userSex;

    private Integer userAge;

    //用于表示用户登录失败时的信息提示
    private String msg;
    //用于表示该用户所拥有的权限id
    private Set<Integer> AuthIds;
    //用于表示该用户所拥有的角色id
    private List<Integer> RoleIds;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Set<Integer> getAuthIds() {
        return AuthIds;
    }

    public void setAuthIds(Set<Integer> authIds) {
        AuthIds = authIds;
    }

    public List<Integer> getRoleIds() {
        return RoleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        RoleIds = roleIds;
    }
}