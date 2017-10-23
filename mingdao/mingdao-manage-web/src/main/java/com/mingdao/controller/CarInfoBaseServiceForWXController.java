package com.mingdao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.ICarInfoBaseService;
import com.mingdao.api.ICustomerBaseService;
import com.mingdao.domain.CarInfo;
import com.mingdao.domain.Customer;
import com.mingdao.domain.ResultMessage;
import com.mingdao.web.consts.MingDaoHttpRequestConsts;

/**
 *
 * <code>CarInfoBaseServiceForWXController<code> <strong></strong>
 * <p>
 * 说明：车辆信息绑定的controller
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月19日 下午7:50:55
 * @author libinf
 */
@Controller
@RequestMapping("/weixin/carInfoBaseSer")
public class CarInfoBaseServiceForWXController extends BaseController {

	@Autowired
	private ICarInfoBaseService carInfoBaseService;

	@Autowired
	private ICustomerBaseService custBaseService;

	/**
	 * 
	 * <p>
	 * 说明：车辆绑定的controller
	 * <li></li>
	 * </p>
	 * 
	 * @param request
	 * @param inputData
	 * @return
	 * @date 2017年10月19日 下午8:29:56
	 * @since
	 */
	@RequestMapping(value = "/addCarInfo", method = RequestMethod.POST)
	public @ResponseBody ResultMessage addCarInfo(HttpServletRequest request, @RequestBody String inputData) {
		ResultMessage result = new ResultMessage();
		JSONObject jsonObj = JSONObject.parseObject(inputData);
		String phone = jsonObj.getString(MingDaoHttpRequestConsts.PHONE);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Customer.PHONE, phone);
		Customer cust = custBaseService.singleQryByCondtion(param);
		if (cust == null) {
			result.setSuccess(false);
			result.setResultMsg("用户暂未注册!");
			return result;
		}
		CarInfo carInfo = new CarInfo();
		carInfo.setCustomerId(cust.getId());
		carInfo.setPlatNumber(jsonObj.getString("carNo"));
		carInfo.setVin(jsonObj.getString("vin"));
		carInfo = carInfoBaseService.insert(carInfo);
		JSONObject val = new JSONObject();
		val.put("phone",phone);
		val.put("systemLongTime",System.currentTimeMillis());
		if (carInfo.getId() == null) {
			result.setSuccess(false);
			result.setResultMsg("绑定失败，请检查日志！");
		} else {
			result.setSuccess(true);
			result.setResult(val);
		}
		return result;
	}


	@RequestMapping(value = "/getSystemLongTime", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getSystemLongTime(){
		long longTime = System.currentTimeMillis();
		JSONObject result = new JSONObject();
		result.put("systemTime",longTime);
		return result;
	}

}
