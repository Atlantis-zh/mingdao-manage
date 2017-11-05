package com.mingdao.controller;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IMenuBaseService;
import com.mingdao.api.IWorkTimeClassBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Menu;
import com.mingdao.domain.ServiceProject;
import com.mingdao.domain.WorkTimeClass;
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
 * Created by Administrator on 2017/11/5.
 */
@Controller
@RequestMapping("workTimeClass")
public class WorkTimeClassController  extends  BaseController {
        public static Logger logger = LoggerFactory.getLogger(WorkTimeClassController.class);

        @Qualifier("workTimeClassBaseService")
        @Autowired
        IWorkTimeClassBaseService workTimeClassBaseService;


        @RequestMapping("workTimeClasss")
        public String getMenusInfo(Model model, HttpServletRequest request) {
            WorkTimeClass user = new WorkTimeClass();
            String name = request.getParameter("search_Name");
            String code = request.getParameter("search_Code");
            Map<String,Object> param = new HashMap<String,Object>();
            if (!StringUtils.isEmpty(name)) {
                user.setName(name);
                param.put("name",name);
            }
            if (!StringUtils.isEmpty(code)) {
                user.setCode(code);
                param.put("code",code);
            }
            Pager<WorkTimeClass> listUser = workTimeClassBaseService.pageQueryByCondition(param);
            model.addAttribute("datas", listUser);
            return "worktimeclass/list";
        }


        @RequestMapping(value = "/getWorkTimeInfoByID")
        @ResponseBody
        public JSONObject getWorkTimeInfoByID(HttpServletRequest request) {
            String userId = request.getParameter("userId");
            Map<String,Object> param = new HashMap<>();
            Long pk = Long.valueOf(userId);
            param.put("id",pk);
            Pager<WorkTimeClass> listUser = workTimeClassBaseService.pageQueryByCondition(param);
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


        @RequestMapping("addWorkTime")
        @ResponseBody
        public JSONObject goToAddUser(WorkTimeClass userInfo, HttpServletRequest request) {
            JSONObject result = new JSONObject();
            if (!StringUtils.isEmpty(userInfo) && !StringUtils.isEmpty(userInfo.getId())) {
                super.setTimeStampWithUpdate(userInfo, request);
                userInfo = workTimeClassBaseService.update(userInfo);

            } else {
                super.setTimeStampWithInsert(userInfo, request);
                userInfo = workTimeClassBaseService.insert(userInfo);
            }
            if (userInfo == null) {
                result.put("status", "0");
            } else {
                result.put("status", "1");
            }
            return result;
        }


        @RequestMapping(value = "/deleteWorkTime/{id}")
        public String deleteWorkTime(@PathVariable("id") String id) {
            Long pk = Long.valueOf(id);
            workTimeClassBaseService.deleteDocById(pk);
            return "redirect:/workTimeClass/workTimeClasss";
        }


    }
