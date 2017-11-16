package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IIntegralRuleBaseService;
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.IntegralRule;
import com.mingdao.domain.Role;
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
@RequestMapping("integralRule")
public class IntegralRuleController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(IntegralRuleController.class);

    @Autowired
    @Qualifier("integralRuleBaseService")
    IIntegralRuleBaseService integralRuleBaseService;


    @RequestMapping("integralRules")
    public String getUserInfo(Model model,HttpServletRequest request){
        IntegralRule role = new IntegralRule();
        String id =  request.getParameter("search_ID");
        String CardTypeId =  request.getParameter("search_CardTypeId");
        if(!StringUtils.isEmpty(id)){
            long pk =  Long.valueOf(id);
            role.setId(pk);
        }
        if(!StringUtils.isEmpty(CardTypeId)){
            long typeId =  Long.valueOf(CardTypeId);
            role.setCardTypeId(typeId);
        }
        Map<String,Object> param = new HashMap<>();
        if(!StringUtils.isEmpty(role)){
            param.put("id",role.getId());
            param.put("cardtypeid",role.getCardTypeId());
        }

        Pager<IntegralRule> listRole =  integralRuleBaseService.pageQueryByCondition(param);
        model.addAttribute("datas", listRole);
        return "integralRule/list";
    }


    @RequestMapping(value="/getIntegralRuleByID")
    @ResponseBody
    public JSONObject getIntegralRuleByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<IntegralRule> listUser =  integralRuleBaseService.pageQueryByCondition(param);
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



    @RequestMapping("addIntegralRule")
    @ResponseBody
    public JSONObject addIntegralRule(IntegralRule role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = integralRuleBaseService.update(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = integralRuleBaseService.insert(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result;
    }



    @RequestMapping(value="/deleteIntegralRule/{id}")
    public String deleteIntegralRule(@PathVariable("id") String id){
        long pk =  Long.valueOf(id);
        integralRuleBaseService.deleteDocById(pk);
        return  "redirect:/integralRule/integralRules";
    }




}
