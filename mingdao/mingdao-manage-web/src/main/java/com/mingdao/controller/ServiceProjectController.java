package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.api.IServiceProjectBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Role;
import com.mingdao.domain.ServiceProject;
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
@RequestMapping("serviceProject")
public class ServiceProjectController extends  BaseController {
    public static Logger logger = LoggerFactory.getLogger(ServiceProjectController.class);

    @Autowired
    IServiceProjectBaseService ServiceProjectBaseServiceImpl;


    @RequestMapping("serviceProjects")
    public String getUserInfo(Model model, HttpServletRequest request) {
        ServiceProject role = new ServiceProject();
        String name = request.getParameter("search_RoleName");
        String code = request.getParameter("search_RoleCode");
        if (!StringUtils.isEmpty(name)) {
            role.setName(name);
        }
        if (!StringUtils.isEmpty(code)) {
            role.setCode(code);
        }
        Map<String, Object> param = new HashMap<>();
        if (!StringUtils.isEmpty(role)) {
            param.put("roleName", role.getName());
            param.put("roleCode", role.getCode());
        }

        Pager<ServiceProject> listRole = ServiceProjectBaseServiceImpl.pageQueryByCondition(param);
        model.addAttribute("datas", listRole);
        return "role/list";
    }


    @RequestMapping(value = "/getServiceProjectInfoByID")
    @ResponseBody
    public String getServiceProjectInfoByID(HttpServletRequest request) {
        String userId = request.getParameter("id");
        Long pk = Long.valueOf(userId);
        Map<String, Object> param = new HashMap<>();
        param.put("id", pk);
        Pager<ServiceProject> listUser = ServiceProjectBaseServiceImpl.pageQueryByCondition(param);
        JSONObject result = new JSONObject();
        JSONObject object = new JSONObject();
        if (!StringUtils.isEmpty(listUser) && !StringUtils.isEmpty(listUser.getDatas()) && !StringUtils.isEmpty(listUser.getDatas().get(0))) {
            object = (JSONObject) JSONObject.toJSON(listUser.getDatas().get(0));
        } else {
            object = null;
        }
        result.put("result", object);
        return result.toString();
    }


    @RequestMapping("addServiceProject")
    @ResponseBody
    public String goToAddUser(ServiceProject role, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        if (!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())) {
            super.setTimeStampWithUpdate(role, request);
            role = ServiceProjectBaseServiceImpl.update(role);

        } else {
            super.setTimeStampWithInsert(role, request);
            role = ServiceProjectBaseServiceImpl.insert(role);
        }
        if (role == null) {
            result.put("status", "0");
        } else {
            result.put("status", "1");
        }
        return result.toString();
    }


    @RequestMapping(value = "/deleteServiceProject/{id}")
    public String deleteServiceProject(@PathVariable("id") String id) {
        long pk = Integer.valueOf(id);
        ServiceProjectBaseServiceImpl.deleteDocById(pk);
        return "redirect:/role/roles";
    }

}


