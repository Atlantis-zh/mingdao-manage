package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IPermissionBaseServiceItf;
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Permission;
import com.mingdao.domain.Role;
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
 * Created by Administrator on 2017/10/28.
 */


@Controller
@RequestMapping("permission")
public class PermissionController extends  BaseController {
    public static Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    IPermissionBaseServiceItf PermissionBaseServiceItfImpl;


    @RequestMapping("permissions")
    public String getPermissionsInfo(Model model, HttpServletRequest request) {
        Permission role = new Permission();
        String name = request.getParameter("search_PermissionName");
        String code = request.getParameter("search_PermissionCode");
        if (!StringUtils.isEmpty(name)) {
            role.setPermissionName(name);
        }
        if (!StringUtils.isEmpty(code)) {
            role.setPermissionCode(code);
        }
        Map<String, Object> param = new HashMap<>();
        if (!StringUtils.isEmpty(role)) {
            param.put("permissionName", role.getPermissionName());
            param.put("permissionCode", role.getPermissionCode());
        }
        Pager<Permission> listRole = PermissionBaseServiceItfImpl.pageQueryPermissionByCondition(param);
        model.addAttribute("datas", listRole);
        return "permission/list";
    }


    @RequestMapping(value = "/getPermissionsInfoByID")
    @ResponseBody
    public String getPermissionsInfoByID(HttpServletRequest request) {
        String userId = request.getParameter("id");
        Long pk = Long.valueOf(userId);
        Map<String, Object> param = new HashMap<>();
        param.put("id", pk);
        Pager<Permission> listUser = PermissionBaseServiceItfImpl.pageQueryPermissionByCondition(param);
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


    @RequestMapping("addPermission")
    @ResponseBody
    public String goToAddUser(Permission role, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        if (!StringUtils.isEmpty(role) && !StringUtils.isEmpty(role.getId())) {
            super.setTimeStampWithUpdate(role, request);
            role = PermissionBaseServiceItfImpl.updatePermission(role);

        } else {
            super.setTimeStampWithInsert(role, request);
            role = PermissionBaseServiceItfImpl.insertPermission(role);
        }
        if (role == null) {
            result.put("status", "0");
        } else {
            result.put("status", "1");
        }
        return result.toString();
    }


    @RequestMapping(value = "/deletePermission/{id}")
    public String deletePermission(@PathVariable("id") String id) {
        int pk = Integer.valueOf(id);
        PermissionBaseServiceItfImpl.deletePermission(pk);
        return "redirect:/permission/permissions";
    }

}
