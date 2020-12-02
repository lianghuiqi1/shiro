package com.bjpowernode.controller;

import com.bjpowernode.entity.Auth;
import com.bjpowernode.entity.Role;
import com.bjpowernode.service.AuthService;
import com.bjpowernode.service.RoleAuthService;
import com.bjpowernode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    AuthService authService;


    @Autowired
    RoleAuthService roleAuthService;

    @RequestMapping("list")
    public List<Role> list(){
        return roleService.list();
    }

    @RequestMapping("add")
    public String add(Role role,Model model){

        //查询所有的权限
        role.setRoleStatus(1);
        model.addAttribute("authList",authService.list());

        return "role/edit";
    }

    @RequestMapping("save")
    public String save(Role role,int[] authIds){

        //向角色表写值
        roleService.save(role);
        //根据名称编码查询role,主要是要自动生成的主键
        Role roleDB = roleService.findRole(role);
        //向角色权限表写值
        roleAuthService.save(roleDB.getRoleId(),authIds);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(int roleId,Model model){

        //查询角色信息
        Role role = roleService.get(roleId);
        model.addAttribute("role",role);

        //查询所有的权限
        model.addAttribute("authList",authService.list());

        //查询当前用户已拥有的权限
        //* User user = (User)session.getAttribute("loginUser");
        //map.put("onwerAuthList",authService.list(user.getUserId()));

        //查询当前角色已拥有的权限
        List<Auth> onwerAuthList = authService.listByRole(roleId);

        List<Integer> authIds = new ArrayList<>();

        for(Auth auth : onwerAuthList){

            authIds.add(auth.getAuthId());
        }
        role.setAuthIds(authIds);

        return "role/edit";
    }


    @RequestMapping("saveUpdate")
    public String saveUpdate(Role role,int[] authIds){

        //更新角色表
        roleService.update(role);

        //向角色权限表重新写值
        roleAuthService.save(role.getRoleId(),authIds);

        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int roleId){

        roleService.delete(roleId);

        return "redirect:list";
    }


}
