package com.mingdao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mingdao.api.ICustomerBaseService;
import com.mingdao.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IOrderProjectBaseService;
import com.mingdao.domain.OrderProject;
import com.mingdao.domain.ResultMessage;
import com.mingdao.enumprop.OrderStatus;
import com.mingdao.enumprop.Source;

import java.util.HashMap;
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
@RequestMapping("/weixin/orderProjectBaseSer")
public class OrderProjectServiceForWXController extends BaseController {

	@Autowired
	private IOrderProjectBaseService orderProjectService;

	@Autowired
	private ICustomerBaseService custBaseService;

	@RequestMapping(value = "/addOrderProject", method = RequestMethod.POST)
	public @ResponseBody JSONObject addOrderProject(HttpServletRequest request, OrderProject op) {
		ResultMessage result = new ResultMessage();
		op.setSource(Source.WEIXIN);
		op.setStatus(OrderStatus.UNCOMFORM);
		Map<String, Object> param=new HashMap<String, Object>();
		param.put(Customer.PHONE, op.getLinkTel());
		Customer cust = custBaseService.singleQryByCondtion(param);
		HttpSession session= request.getSession();
		session.setAttribute("userId",cust.getId());//todo 这里后续要做处理
		super.setTimeStampWithInsert(op, request);
		orderProjectService.insert(op);
		if (op.getId() != null) {
			result.setSuccess(true);
			result.setResult(op.getId());
		} else {
			result.setSuccess(false);
			result.setResultMsg("预约失败，请检查日志！");
		}
		return result;
	}

}
