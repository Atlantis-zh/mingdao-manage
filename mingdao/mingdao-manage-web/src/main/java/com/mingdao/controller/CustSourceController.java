package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IAttachProjectBaseService;
import com.mingdao.api.ICustSourceBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.AttachProject;
import com.mingdao.domain.CustSource;
import com.mingdao.domain.CustType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("custSource")
public class CustSourceController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(CustSourceController.class);

    @Autowired
    @Qualifier("custSourceBaseService")
    ICustSourceBaseService custSourceBaseService;


    @RequestMapping("custSources")
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

        Pager<CustSource> listRole =  custSourceBaseService.pageQueryByCondition(param);
        model.addAttribute("datas", listRole);
        return "custSource/list";
    }


    @RequestMapping(value="/getCustSourcesByID")
    @ResponseBody
    public JSONObject getCustSourcesByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<CustSource> listUser =  custSourceBaseService.pageQueryByCondition(param);
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



    @RequestMapping("addCustSource")
    @ResponseBody
    public JSONObject addCustSource(CustSource role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = custSourceBaseService.update(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = custSourceBaseService.insert(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result;
    }



    @RequestMapping(value="/deleteCustSource/{id}")
    public String deleteCustSource(@PathVariable("id") String id){
        long pk =  Long.valueOf(id);
        custSourceBaseService.deleteDocById(pk);
        return  "redirect:/custSource/custSources";
    }




}
