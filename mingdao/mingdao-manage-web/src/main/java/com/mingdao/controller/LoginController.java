package com.mingdao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingdao.api.ICustomerBaseService;
import com.mingdao.domain.Customer;
import com.mingdao.domain.ResultMessage;
import com.mingdao.enumprop.Source;

/**
 * Created by ambitious on 2017/9/16.
 */

@Controller
@RequestMapping("/weixin/login")
public class LoginController extends BaseController {

	@Autowired
	private ICustomerBaseService custBaseService;

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId", 1);
        return "/admin/login";
    }

    @RequestMapping(value="login_copy",method = RequestMethod.GET)
    public String login_Copy(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId",1);
        return "admin/index";
    }


    @RequestMapping("index")
    public String goToIndex(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId",1L);
        return "admin/index";
    }

	@RequestMapping(value = "/sendSMS", method = RequestMethod.GET)
	public @ResponseBody ResultMessage sendSMS(HttpServletRequest request) {
		ResultMessage result = new ResultMessage();
		String phone = request.getParameter("phone");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Customer.PHONE, phone);
		Customer cust = custBaseService.singleQryByCondtion(param);
		if (cust == null) {
			cust = new Customer();
			cust.setPhone(phone);
			cust.setCode(phone);
			cust.setCustSource(Source.WEIXIN);
			super.setTimeStampWithInsert(cust, request);
			custBaseService.insert(cust);
			if (cust.getId() == null) {
				result.setSuccess(false);
				result.setResultMsg("用户注册失败，请检查日志！");
				return result;
			}
		}
		// TODO 实现发送短信的代码逻辑
		result.setSuccess(true);
		result.setResult("发送成功！");
		return result;

	}

	@RequestMapping(value = "/verifySMS", method = RequestMethod.GET)
	public @ResponseBody ResultMessage verifySMS(HttpServletRequest request) {
		ResultMessage result = new ResultMessage();
		String phone = request.getParameter("phone");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Customer.PHONE, phone);
		Customer cust = custBaseService.singleQryByCondtion(param);
		if (cust == null) {
			result.setSuccess(false);
			result.setResultMsg("用户暂未注册!");
			return result;
		}
		String verifycode = request.getParameter("verifycode");
		// TODO 加上短信验证的逻辑
		if (verifycode.equals("123456")) {
			result.setSuccess(true);
			result.setResult("验证成功！");
		} else {
			result.setSuccess(false);
			result.setResultMsg("短信验证码错误!");
		}
		return result;
	}


}
