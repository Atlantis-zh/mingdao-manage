package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IMeasdocBaseService;
import com.mingdao.api.IMemberShipCardBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Measdoc;
import com.mingdao.domain.MemberShipCard;
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
@RequestMapping("measdoc")
public class MeasDoCardController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(MeasDoCardController.class);

    @Autowired
    @Qualifier("measDocService")
    IMeasdocBaseService measDocService;


    @RequestMapping("measdocs")
    public String getMeasDoc(Model model,HttpServletRequest request){
        Measdoc role = new Measdoc();
        String code =  request.getParameter("search_Code");
        String name =  request.getParameter("search_Name");
        if(!StringUtils.isEmpty(code)){
            role.setCode(code);
        }
        if(!StringUtils.isEmpty(name)){
            role.setName(name);
        }
        Map<String,Object> param = new HashMap<>();
        if(!StringUtils.isEmpty(role)){
            param.put("id",role.getId());
            param.put("name",role.getName());
        }
        Pager<Measdoc> listRole =  measDocService.pageQueryByCondition(param);
        model.addAttribute("datas", listRole);
        return "measdoc/list";
    }


    @RequestMapping(value="/getMeasDocByID")
    @ResponseBody
    public JSONObject getMeasDocByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<Measdoc> listUser =  measDocService.pageQueryByCondition(param);
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



    @RequestMapping("addMeasDoc")
    @ResponseBody
    public JSONObject addMeasDoc(Measdoc role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = measDocService.update(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = measDocService.insert(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result;
    }



    @RequestMapping(value="/deleteMeasDoc/{id}")
    public String deleteMeasDoc(@PathVariable("id") String id){
        long pk =  Long.valueOf(id);
        measDocService.deleteDocById(pk);
        return  "redirect:/measdoc/measdocs";
    }




}
