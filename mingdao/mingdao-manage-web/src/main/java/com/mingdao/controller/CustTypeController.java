package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.ICustTypeBaseService;
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.CustType;
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
@RequestMapping("custType")
public class CustTypeController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(CustTypeController.class);

    @Autowired
    ICustTypeBaseService custTypeBaseService;


    @RequestMapping("custTypes")
    public String getCustTypesInfo(Model model,HttpServletRequest request){
        CustType role = new CustType();
        String name =  request.getParameter("search_Name");
        String code =  request.getParameter("search_Code");
        if(!StringUtils.isEmpty(name)){
            role.setName(name);
        }
        if(!StringUtils.isEmpty(code)){
            role.setCode(code);
        }
        Map<String,Object> param = new HashMap<>();
        if(!StringUtils.isEmpty(role)){
            param.put("name",role.getName());
            param.put("code",role.getCode());
        }

        Pager<CustType> listRole =  custTypeBaseService.pageQueryCustTypeByCondition(param);
        model.addAttribute("datas", listRole);
        return "role/list";
    }


    @RequestMapping(value="/getCustTypeByID")
    @ResponseBody
    public JSONObject getCustTypeByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<CustType> listUser =  custTypeBaseService.pageQueryCustTypeByCondition(param);
        JSONObject result = new JSONObject();
        JSONObject object = new JSONObject();
        if(!StringUtils.isEmpty(listUser) && !StringUtils.isEmpty(listUser.getDatas()) && !StringUtils.isEmpty(listUser.getDatas().get(0))){
            object =(JSONObject) JSONObject.toJSON(listUser.getDatas().get(0));
        }else{
            object=null;
        }
        result.put("result",object);
        return  result;
    }



    @RequestMapping("addCustType")
    @ResponseBody
    public JSONObject addCustType(CustType role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = custTypeBaseService.updateCustType(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = custTypeBaseService.insertCustType(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result;
    }



    @RequestMapping(value="/deleteRole/{id}")
    public String deleteUser(@PathVariable("id") String id){
        long pk =  Long.valueOf(id);
        custTypeBaseService.deleteDocById(pk);
        return  "redirect:/custType/custTypes";
    }




}
