package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IMemberShipCardBaseService;
import com.mingdao.api.IPackageTypeBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.MemberShipCard;
import com.mingdao.domain.PackageType;
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
 * Created by zhangfx5 on 2017/10/28.
 */


@Controller
@RequestMapping("memberShipCard")
public class MemberShipCardController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(MemberShipCardController.class);

    @Autowired
    @Qualifier("memberShipCardBaseService")
    IMemberShipCardBaseService memberShipCardBaseService;


    @RequestMapping("memberShipCards")
    public String getMSC(Model model,HttpServletRequest request){
        MemberShipCard role = new MemberShipCard();
        String id =  request.getParameter("search_ID");
        String name =  request.getParameter("search_Name");
        if(!StringUtils.isEmpty(id)){
            long pk = Long.valueOf(id);
            role.setId(pk);
        }
        if(!StringUtils.isEmpty(name)){
            role.setName(name);
        }
        Map<String,Object> param = new HashMap<>();
        if(!StringUtils.isEmpty(role)){
            param.put("id",role.getId());
            param.put("name",role.getName());
        }
        Pager<MemberShipCard> listRole =  memberShipCardBaseService.pageQueryMemShipCardByCondition(param);
        model.addAttribute("datas", listRole);
        return "memberShipCard/list";
    }


    @RequestMapping(value="/getMemberShipCardByID")
    @ResponseBody
    public JSONObject getMemberShipCardByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<MemberShipCard> listUser =  memberShipCardBaseService.pageQueryMemShipCardByCondition(param);
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



    @RequestMapping("addPackageType")
    @ResponseBody
    public JSONObject goToAddPackageType(MemberShipCard role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = memberShipCardBaseService.updateMemShipCard(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = memberShipCardBaseService.insertMemShipCard(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result;
    }



    @RequestMapping(value="/deleteMemShipCard/{id}")
    public String deleteUser(@PathVariable("id") String id){
        long pk =  Long.valueOf(id);
        memberShipCardBaseService.deleteMemShipCard(pk);
        return  "redirect:/memberShipCard/memberShipCards";
    }




}
