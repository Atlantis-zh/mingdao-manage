package com.mingdao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.UserInfo;

/**
 * Created by ambitious on 2017/9/16.
 */

@Controller
@RequestMapping("user")
public class UserInfoController extends  BaseController{

    @Autowired
    IUserInfoBaseServiceItf  UserInfoBaseService;


    @RequestMapping("users")
    public String getUserInfo(Model model,HttpServletRequest request){
        UserInfo user = new UserInfo();
        String name =  request.getParameter("search_userName");
        String code =  request.getParameter("search_userCode");
        if(!StringUtils.isEmpty(name)){
            user.setUserName(name);
        }
        if(!StringUtils.isEmpty(code)){
            user.setUserCode(code);
        }
        Pager<UserInfo> listUser =  UserInfoBaseService.getUserInfo(user);
        model.addAttribute("datas", listUser);
        return "user/list";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String goToAddUser(UserInfo userInfo,HttpServletRequest request){
        JSONObject result = new JSONObject();
		super.setTimeStampWithInsert(userInfo, request);
        UserInfo user = UserInfoBaseService.insertUserInfo(userInfo);
        if(user==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result.toString();
    }



    @RequestMapping(value="/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") String id){
        int pk =  Integer.valueOf(id);
        UserInfoBaseService.deleteUser(pk);
        return  "redirect:/user/users";
    }







}
