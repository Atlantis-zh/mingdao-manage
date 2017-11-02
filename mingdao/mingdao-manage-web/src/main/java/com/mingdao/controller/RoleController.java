package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IRoleBaseServiceItf;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/28.
 */


@Controller
@RequestMapping("role")
public class RoleController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    IRoleBaseServiceItf RoleBaseServiceItfImpl;


    @RequestMapping("roles")
    public String getUserInfo(Model model,HttpServletRequest request){
        Role role = new Role();
        String name =  request.getParameter("search_RoleName");
        String code =  request.getParameter("search_RoleCode");
        if(!StringUtils.isEmpty(name)){
            role.setRoleName(name);
        }
        if(!StringUtils.isEmpty(code)){
            role.setRoleCode(code);
        }
        Map<String,Object> param = new HashMap<>();
        if(!StringUtils.isEmpty(role)){
            param.put("roleName",role.getRoleName());
            param.put("roleCode",role.getRoleCode());
        }

        Pager<Role> listRole =  RoleBaseServiceItfImpl.pageQueryRolesByCondition(param);
        model.addAttribute("datas", listRole);
        return "role/list";
    }


    @RequestMapping(value="/getRoleInfoByID")
    @ResponseBody
    public String getRoleInfoByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<Role> listUser =  RoleBaseServiceItfImpl.pageQueryRolesByCondition(param);
        JSONObject result = new JSONObject();
        JSONObject object = new JSONObject();
        if(!StringUtils.isEmpty(listUser) && !StringUtils.isEmpty(listUser.getDatas()) && !StringUtils.isEmpty(listUser.getDatas().get(0))){
            object =(JSONObject) JSONObject.toJSON(listUser.getDatas().get(0));
        }else{
            object=null;
        }
        result.put("result",object);
        return  result.toString();
    }



    @RequestMapping("addRole")
    @ResponseBody
    public String goToAddUser(Role role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = RoleBaseServiceItfImpl.updateRole(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = RoleBaseServiceItfImpl.insertRole(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result.toString();
    }



    @RequestMapping(value="/deleteRole/{id}")
    public String deleteUser(@PathVariable("id") String id){
        int pk =  Integer.valueOf(id);
        RoleBaseServiceItfImpl.deleteRole(pk);
        return  "redirect:/role/roles";
    }




}
