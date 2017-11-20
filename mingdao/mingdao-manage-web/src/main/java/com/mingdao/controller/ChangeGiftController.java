package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IExchangeGiftBaseService;
import com.mingdao.api.IPackageTypeBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.ExchangeGift;
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
@RequestMapping("changeGift")
public class ChangeGiftController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(ChangeGiftController.class);

    @Autowired
    @Qualifier("exchangeGiftBaseService")
    IExchangeGiftBaseService exchangeGiftBaseService;


    @RequestMapping("changeGifts")
    public String getChangeGifts(Model model,HttpServletRequest request){
        ExchangeGift role = new ExchangeGift();
        String id =  request.getParameter("search_ID");
        String name =  request.getParameter("search_Name");
        String points =  request.getParameter("search_points");
        if(!StringUtils.isEmpty(id)){
            long pk = Long.valueOf(id);
            role.setId(pk);
        }
        if(!StringUtils.isEmpty(name)){
            role.setName(name);
        }
        if(!StringUtils.isEmpty(points)){
            int pointss = Integer.valueOf(points);
            role.setPoints(pointss);
        }
        Map<String,Object> param = new HashMap<>();
        if(!StringUtils.isEmpty(role)){
            param.put("id",role.getId());
            param.put("name",role.getName());
            param.put("points",role.getPoints());
        }
        Pager<ExchangeGift> listRole =  exchangeGiftBaseService.pageQueryByCondition(param);
        model.addAttribute("datas", listRole);
        return "exchangeGift/list";
    }


    @RequestMapping(value="/getExchangeGiftByID")
    @ResponseBody
    public JSONObject getExchangeGiftByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<ExchangeGift> listUser =  exchangeGiftBaseService.pageQueryByCondition(param);
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



    @RequestMapping("addExchangeGift")
    @ResponseBody
    public JSONObject addExchangeGift(ExchangeGift role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = exchangeGiftBaseService.update(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = exchangeGiftBaseService.insert(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result;
    }



    @RequestMapping(value="/deletePackageType/{id}")
    public String deletePackageType(@PathVariable("id") String id){
        long pk =  Long.valueOf(id);
        exchangeGiftBaseService.deleteDocById(pk);
        return  "redirect:/changeGift/changeGifts";
    }




}
