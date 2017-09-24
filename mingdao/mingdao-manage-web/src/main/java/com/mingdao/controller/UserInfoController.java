package com.mingdao.controller;

import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mingdao.common.pageUtil.Pager;

/**
 * Created by ambitious on 2017/9/16.
 */

@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    IUserInfoBaseServiceItf  UserInfoBaseService;


    @RequestMapping("users")
    public String getUserInfo(Model model){
        UserInfo user = new UserInfo();
        Pager<UserInfo> listUser =  UserInfoBaseService.getUserInfo(user);
        model.addAttribute("datas", listUser);
        return "user/list";
    }

    @RequestMapping("addUser")
    public String goToAddUser(Model model){
        UserInfo user = new UserInfo();
        model.addAttribute("userInfo",user);
        return "user/add";
    }







}
