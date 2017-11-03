package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IStoreBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Role;
import com.mingdao.domain.Store;
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
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("store")
public class StoreController  extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    IStoreBaseService StoreBaseServiceImpl;


    @RequestMapping("stores")
    public String getStoreInfo(Model model,HttpServletRequest request){
        Store role = new Store();
        String name =  request.getParameter("search_StoreName");
        String code =  request.getParameter("search_StoreCode");
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

        Pager<Store> listRole =  StoreBaseServiceImpl.pageQueryStoreByCondition(param);
        model.addAttribute("datas", listRole);
        return "store/list";
    }


    @RequestMapping(value="/getStoreInfoByID")
    @ResponseBody
    public JSONObject getStoreInfoByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<Store> listUser =  StoreBaseServiceImpl.pageQueryStoreByCondition(param);
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



    @RequestMapping("addStore")
    @ResponseBody
    public String goToAddStore(Store store,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(store) && !StringUtils.isEmpty(store.getId())){
            super.setTimeStampWithUpdate(store, request);
            store = StoreBaseServiceImpl.updateStore(store);

        }else{
            super.setTimeStampWithInsert(store, request);
            store = StoreBaseServiceImpl.insertStore(store);
        }
        if(store==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result.toString();
    }



    @RequestMapping(value="/deleteStore/{id}")
    public String deleteUser(@PathVariable("id") String id){
        int pk =  Integer.valueOf(id);
        StoreBaseServiceImpl.deleteStore(pk);
        return  "redirect:/store/stores";
    }




}