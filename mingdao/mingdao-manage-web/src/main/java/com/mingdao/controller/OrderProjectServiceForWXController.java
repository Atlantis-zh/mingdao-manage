package com.mingdao.controller;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/addOrderProject", method = RequestMethod.POST)
	public @ResponseBody String addOrderProject(HttpServletRequest request, @RequestBody String inputData) {
		ResultMessage result = new ResultMessage();
		JSONObject jsonObj = JSONObject.parseObject(inputData);
		OrderProject op = new OrderProject();
		op.setStoreId(jsonObj.getLong("storeId"));
		op.setCustomerId(jsonObj.getLong("customerId"));
		op.setServiceProjectId(jsonObj.getLong("serviceProjectId"));
		op.setOrderUserId(jsonObj.getLong("orderUserId"));
		op.setOrderTime(jsonObj.getString("orderTime"));
		op.setMemo(jsonObj.getString("memo"));
		op.setCarNo(jsonObj.getString("carNo"));
		op.setLinkmanName(jsonObj.getString("linkmanName"));
		op.setLinkTel(jsonObj.getString("linkTel"));
		op.setSource(Source.WEIXIN);
		op.setStatus(OrderStatus.UNCOMFORM);
		super.setTimeStampWithInsert(op, request);
		orderProjectService.insert(op);
		if (op.getId() != null) {
			result.setSuccess(true);
			result.setResult(op.getId());
		} else {
			result.setSuccess(false);
			result.setResultMsg("预约失败，请检查日志！");
		}
		return result.toString();
	}

}
