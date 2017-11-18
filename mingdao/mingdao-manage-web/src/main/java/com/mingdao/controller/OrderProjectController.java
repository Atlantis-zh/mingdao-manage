package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IOrderProjectBaseService;
import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.OrderProject;
import com.mingdao.domain.UserInfo;
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
 * Created by ambitious on 2017/9/16.
 */

@Controller
@RequestMapping("orderProject")
public class OrderProjectController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(OrderProjectController.class);

    @Autowired
    @Qualifier("orderProjectBaseService")
    IOrderProjectBaseService orderProjectBaseService;


    @RequestMapping("orderProjects")
    public String getOrderProjects(Model model,HttpServletRequest request){
        OrderProject user = new OrderProject();
        String search_car =  request.getParameter("search_car");
        String serviceprojectid =  request.getParameter("search_serviceprojectid");
        Map<String, Object> param = new HashMap<>();
        if(!StringUtils.isEmpty(search_car)){
            param.put("carno",search_car);
        }
        if(!StringUtils.isEmpty(serviceprojectid)){
            long pk_serviceprojectid = Long.valueOf(serviceprojectid);
            param.put("serviceprojectid", pk_serviceprojectid);
        }
        param.put("status",0);
        Pager<OrderProject> listUser =  orderProjectBaseService.pageQueryByCondition(param);
        model.addAttribute("datas", listUser);
        return "orderProject/dealList";
    }


    @RequestMapping(value="/getOrderProjectByID")
    @ResponseBody
    public JSONObject getOrderProjectByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String, Object> param = new HashMap<>();
        param.put("id",pk);
        Pager<OrderProject> listUser =  orderProjectBaseService.pageQueryByCondition(param);
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



    @RequestMapping("addOrderProject")
    @ResponseBody
    public String addOrderProject(OrderProject userInfo,HttpServletRequest request){
        JSONObject result = new JSONObject();
        OrderProject user = new OrderProject();
        if(!StringUtils.isEmpty(userInfo) && !StringUtils.isEmpty(userInfo.getId())){
            super.setTimeStampWithUpdate(userInfo, request);
            user = orderProjectBaseService.update(userInfo);

        }else{
            super.setTimeStampWithInsert(userInfo, request);
            user = orderProjectBaseService.insert(userInfo);
        }
		  if(user==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result.toString();
    }



    @RequestMapping(value="/deleteOrderProject/{id}")
    public String deleteOrderProject(@PathVariable("id") String id){
        long pk =  Long.valueOf(id);
        orderProjectBaseService.deleteDocById(pk);
        return  "redirect:/orderProject/orderProjects";
    }







}
