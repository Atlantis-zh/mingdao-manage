package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IMenuBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Menu;
import com.mingdao.enumprop.Status;
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
@RequestMapping("menu")
public class MenuController  extends  BaseController {
    public static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Qualifier("menuBaseService")
    @Autowired
    IMenuBaseService menuBaseService;


    @RequestMapping("menus")
    public String getMenusInfo(Model model, HttpServletRequest request) {
        Menu user = new Menu();
        String name = request.getParameter("search_Name");
        String code = request.getParameter("search_Code");
        String parentCode = request.getParameter("search_ParentCode");
        Map<String,Object> param = new HashMap<String,Object>();
        if (!StringUtils.isEmpty(name)) {
            user.setName(name);
            param.put("name",name);
        }
        if (!StringUtils.isEmpty(code)) {
            user.setCode(code);
            param.put("code",code);
        }
        if (!StringUtils.isEmpty(parentCode)) {
            user.setParentCode(parentCode);
            param.put("parentCode",parentCode);
        }
        Pager<Menu> listUser = menuBaseService.pageQueryByCondition(param);
        model.addAttribute("datas", listUser);
        return "menu/list";
    }


    @RequestMapping(value = "/getMenuInfoByID")
    @ResponseBody
    public JSONObject getMenuInfoByID(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        Map<String,Object> param = new HashMap<>();
        Long pk = Long.valueOf(userId);
        param.put("id",pk);
        Menu menu = menuBaseService.singleQryByCondtion(param);
        JSONObject result = new JSONObject();
        result.put("result", menu);
        return result;
    }


    @RequestMapping("addMenu")
    @ResponseBody
    public JSONObject goToAddUser(Menu userInfo, HttpServletRequest request) {
        JSONObject result = new JSONObject();
      //  Menu user = new Menu();
        String status1 = request.getParameter("status1");
        if(status1!=null){
            if("1".equals(status1)){
                userInfo.setStatus(Status.ENABLE);
            }else{
                userInfo.setStatus(Status.DISABLE);
            }

        }

        if (!StringUtils.isEmpty(userInfo) && !StringUtils.isEmpty(userInfo.getId())) {
            super.setTimeStampWithUpdate(userInfo, request);
            userInfo = menuBaseService.update(userInfo);

        } else {
            super.setTimeStampWithInsert(userInfo, request);
            userInfo = menuBaseService.insert(userInfo);
        }
        if (userInfo == null) {
            result.put("status", "0");
        } else {
            result.put("status", "1");
        }
        return result;
    }


    @RequestMapping(value = "/deleteMenu/{id}")
    public String deleteMenu(@PathVariable("id") String id) {
        Long pk = Long.valueOf(id);
        menuBaseService.deleteDocById(pk);
        return "redirect:/menu/menus";
    }


}