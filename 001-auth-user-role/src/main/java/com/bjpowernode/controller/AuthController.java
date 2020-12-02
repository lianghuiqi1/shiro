package com.bjpowernode.controller;

import com.bjpowernode.entity.Auth;
import com.bjpowernode.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("list")
    public List<Auth> list(){
        return authService.list();
    }

    @RequestMapping("add")
    public String add(Auth auth){

        auth.setAuthStatus(1);

        return "auth/edit";
    }

    @RequestMapping("save")
    public String save(Auth auth){

        authService.save(auth);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(Auth auth, int authId){

        BeanUtils.copyProperties(authService.get(authId),auth);

        return "auth/edit";
    }

    @RequestMapping("saveUpdate")
    public String saveUpdate(Auth auth){

        authService.update(auth);

        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int authId){

        authService.delete(authId);

        return "redirect:list";
    }
}
