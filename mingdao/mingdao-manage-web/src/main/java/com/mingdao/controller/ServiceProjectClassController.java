package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IServiceProductClassBaseService;
import com.mingdao.api.IServiceProjectBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.ServiceProductClass;
import com.mingdao.domain.ServiceProject;
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
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("serviceProjectClass")
public class ServiceProjectClassController extends  BaseController {
    public static Logger logger = LoggerFactory.getLogger(ServiceProjectClassController.class);

    @Qualifier("serviceProductClassBaseService")
    @Autowired
    IServiceProductClassBaseService serviceProductClassBaseService;


    @RequestMapping("serviceProjectClasss")
    public String getUserInfo(Model model, HttpServletRequest request) {
        ServiceProductClass role = new ServiceProductClass();
        String name = request.getParameter("search_Name");
        String code = request.getParameter("search_Code");
        if (!StringUtils.isEmpty(name)) {
            role.setName(name);
        }
        if (!StringUtils.isEmpty(code)) {
            role.setCode(code);
        }
        Map<String, Object> param = new HashMap<>();
        if (!StringUtils.isEmpty(role)) {
            param.put("name", role.getName());
            param.put("code", role.getCode());
        }

        Pager<ServiceProductClass> listRole = serviceProductClassBaseService.pageQueryByCondition(param);
        model.addAttribute("datas", listRole);
        return "servieProjectClass/list";
    }


    @RequestMapping(value = "/getServiceProjectClassInfoByID")
    @ResponseBody
    public JSONObject getServiceProjectClassInfoByID(HttpServletRequest request) {
        String userId = request.getParameter("id");
        Long pk = Long.valueOf(userId);
        Map<String, Object> param = new HashMap<>();
        param.put("id", pk);
        Pager<ServiceProductClass> listUser = serviceProductClassBaseService.pageQueryByCondition(param);
        JSONObject result = new JSONObject();
        JSONObject object = new JSONObject();
        if (!StringUtils.isEmpty(listUser) && !StringUtils.isEmpty(listUser.getDatas()) && !StringUtils.isEmpty(listUser.getDatas().get(0))) {
            object = (JSONObject) JSONObject.toJSON(listUser.getDatas().get(0));
        } else {
            object = null;
        }
        result.put("result", object);
        return result;
    }


    @RequestMapping("addServiceProjectClass")
    @ResponseBody
    public JSONObject goToAddUser(ServiceProductClass role, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        if (!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())) {
            super.setTimeStampWithUpdate(role, request);
            role = serviceProductClassBaseService.update(role);

        } else {
            super.setTimeStampWithInsert(role, request);
            role = serviceProductClassBaseService.insert(role);
        }
        if (role == null) {
            result.put("status", "0");
        } else {
            result.put("status", "1");
        }
        return result;
    }


    @RequestMapping(value = "/deleteServiceProject/{id}")
    public String deleteServiceProject(@PathVariable("id") String id) {
        long pk = Integer.valueOf(id);
        serviceProductClassBaseService.deleteDocById(pk);
        return "redirect:/role/roles";
    }

}


