package com.bjpowernode.controller;

import com.bjpowernode.entity.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public void login(){
    }

    @RequestMapping("saveLogin")
    public String saveLogin(User user, HttpSession session){

       User userDB  = userService.login(user);

        if(userDB != null){
            //登录成功，放入session中
            session.setAttribute("loginUser",userDB);
            return "redirect:/index";

        }else{
            //登录失败
            user.setMsg("登录失败请检查用户名或密码！");
            return "login";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){

        session.removeAttribute("loginUser");

        return "login";
    }
}
