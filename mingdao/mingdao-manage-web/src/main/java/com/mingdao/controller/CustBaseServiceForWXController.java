package com.mingdao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingdao.api.ICustomerBaseService;
import com.mingdao.domain.Customer;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>CustomerBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月17日 下午7:05:13
 * @author libinf
 */
@Controller
@RequestMapping("customerBaseSer")
public class CustBaseServiceForWXController extends BaseController {

	@Autowired
	private ICustomerBaseService custBaseService;

	@RequestMapping("addCustomer")
	@ResponseBody
	public String addCustomer(Customer customer, HttpServletRequest request) {
		ResultMessage result = new ResultMessage();
		super.setTimeStampWithInsert(customer, request);
		custBaseService.insert(customer);
		if (customer.getId() != null) {
			result.setSuccess(true);
			result.setResult(customer.getId());
		} else {
			result.setSuccess(false);
			result.setResultMsg("插入错误，请检查日志！");
		}
		return result.toString();
	}

}
