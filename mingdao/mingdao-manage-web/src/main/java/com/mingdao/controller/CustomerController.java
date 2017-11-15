package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.ICustomerBaseService;
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Customer;
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
@RequestMapping("customer")
public class CustomerController extends  BaseController{
    public static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Qualifier("customerBaseService")
    @Autowired
    ICustomerBaseService customerBaseService;


    @RequestMapping("customers")
    public String getCustomerInfo(Model model,HttpServletRequest request){
        Customer role = new Customer();
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
            param.put("Name",role.getName());
            param.put("Code",role.getCode());
        }
        Pager<Customer> listRole =  customerBaseService.pageQueryByCondition(param);
        model.addAttribute("datas", listRole);
        return "customer/list";
    }


    @RequestMapping(value="/getCustomerInfoByID")
    @ResponseBody
    public JSONObject getCustomerInfoByID(HttpServletRequest request){
        String userId = request.getParameter("id");
        Long pk =  Long.valueOf(userId);
        Map<String,Object>  param = new HashMap<>();
        param.put("id",pk);
        Pager<Customer> listUser =  customerBaseService.pageQueryByCondition(param);
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



    @RequestMapping("addCustomer")
    @ResponseBody
    public JSONObject goToAddCustomer(Customer role,HttpServletRequest request){
        JSONObject result = new JSONObject();
        if(!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())){
            super.setTimeStampWithUpdate(role, request);
            role = customerBaseService.update(role);

        }else{
            super.setTimeStampWithInsert(role, request);
            role = customerBaseService.insert(role);
        }
        if(role==null){
            result.put("status","0");
        }else{
            result.put("status","1");
        }
        return result;
    }



    @RequestMapping(value="/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        long pk =  Long.parseLong(id);
        customerBaseService.deleteDocById(pk);
        return  "redirect:/customer/customers";
    }




}
