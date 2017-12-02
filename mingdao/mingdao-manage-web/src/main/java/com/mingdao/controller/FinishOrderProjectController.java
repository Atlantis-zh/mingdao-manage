package com.mingdao.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.ICustomerBaseService;
import com.mingdao.api.IOrderProjectBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.Customer;
import com.mingdao.domain.OrderProject;
import com.mingdao.domain.ResultMessage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <code>OrderProjectServiceForWXController<code> <strong></strong>
 * <p>
 * 说明：项目预约管理controller
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月22日 下午7:22:02
 * @author libinf
 */

@Controller
@RequestMapping("/finishOrderProject")
public class FinishOrderProjectController extends BaseController {

  @Autowired
  private IOrderProjectBaseService orderProjectService;



  @RequestMapping(value = "/orderProjects", method = RequestMethod.GET)
  public String  queryOrderProjects(Model model, HttpServletRequest request) {
    String storeId =  request.getParameter("storeId");
    long pk = 0L;
    Map<String,Object> param = new HashMap<String,Object>();
    if(!org.springframework.util.StringUtils.isEmpty(storeId)){
        pk = Long.valueOf(storeId);
      param.put("storeId",storeId);
      param.put("status",1);
    }
    Pager<OrderProject> opPager = orderProjectService.pageQueryByCondition(param);
    model.addAttribute("datas",opPager);
    return "orderProject/dealList";
  }


}
