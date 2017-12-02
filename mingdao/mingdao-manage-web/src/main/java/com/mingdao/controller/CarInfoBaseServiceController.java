package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.mingdao.api.IServiceProjectBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.ServiceProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class CarInfoBaseServiceController extends BaseController {

	@Autowired
	private ICarInfoBaseService carInfoBaseService;

	@Autowired
	private ICustomerBaseService custBaseService;

	@Autowired
	private IServiceProjectBaseService ServiceProjectBaseService;

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
	public @ResponseBody ResultMessage addCarInfo(HttpServletRequest request) {
		ResultMessage result = new ResultMessage();
		CarInfo carInfo = new CarInfo();
		carInfo.setPhone(request.getParameter("phone"));
		carInfo.setPlatNumber(request.getParameter("platNumber"));
		carInfo.setVin(request.getParameter("vin"));

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Customer.PHONE, carInfo.getPhone());
		Customer cust = custBaseService.singleQryByCondtion(param);
		if (cust == null) {
			result.setSuccess(false);
			result.setResultMsg("用户暂未注册!");
			return result;
		}
		carInfo.setCustomerId(cust.getId());
		carInfo.setPlatNumber(carInfo.getPlatNumber());
		carInfo.setVin(carInfo.getVin());
		carInfo = carInfoBaseService.insert(carInfo);

		if (carInfo.getId() == null) {
			result.setSuccess(false);
			result.setResultMsg("绑定失败，请检查日志！");
		} else {
			result.setSuccess(true);
			result.setResult("绑定成功！");
		}
		return result;
	}


	@RequestMapping(value = "/qryAllServiceProject", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject qryAllServiceProject(HttpServletRequest request){
		String storeId =  request.getParameter("storeId");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("storeId",storeId);
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		try{
			Pager<ServiceProject> data = ServiceProjectBaseService.pageQueryByCondition(param);
			List<ServiceProject> list =  data.getDatas();
			for(int i=0;i<list.size();i++){
				ServiceProject project = list.get(i);
				JSONObject obj = new JSONObject();
				obj.put("id",project.getId());
				obj.put("name",project.getName());
				array.add(obj);
			}
			result.put("projrcts",array);
			result.put("success",true);
		}catch (Exception e){
			result.put("projrcts",null);
			result.put("success",false);
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


	@RequestMapping(value = "/getCarsPCByCustId", method = RequestMethod.GET)
	public String getCarsPCByCustId(Model model,HttpServletRequest request) {
		/*String phone = request.getParameter(Customer.PHONE);
		Map<String, Object> custParam = new HashMap<String, Object>();
		custParam.put(Customer.PHONE, phone);
		Customer cust = custBaseService.singleQryByCondtion(custParam);
		Map<String, Object> param = new HashMap<String, Object>();
		if(cust==null){
			param.put("customerId", -1L);
		}else{
			param.put("customerId", cust.getId());
		}*/

		Map<String, Object> param = new HashMap<String, Object>();
		Pager<CarInfo> data=null;
		try {
			data = carInfoBaseService.pageQueryByCondition(param);
		}catch (Exception e){
			e.printStackTrace();
		}
		model.addAttribute("datas",data);
		return "";
	}

	@RequestMapping(value = "/getCarsByCustId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getCarsByCustId(HttpServletRequest request){
		String phone =  request.getParameter(Customer.PHONE);
		Map<String, Object> custParam = new HashMap<String, Object>();
		custParam.put(Customer.PHONE, phone);
		Customer cust = custBaseService.singleQryByCondtion(custParam);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customerId",cust.getId());
		JSONObject result = new JSONObject();
		try{
			Pager<CarInfo> data = carInfoBaseService.pageQueryByCondition(param);
			List<CarInfo> list = data.getDatas();

			JSONArray array = new JSONArray();
			for(int i=0;i<list.size();i++){
				CarInfo carInfo = list.get(i);
				JSONObject obj = new JSONObject();
				obj.put("id",carInfo.getId());
				obj.put("platnumber",carInfo.getPlatNumber());
				array.add(obj);
			}
			result.put("cars",array);
			result.put("success",true);
		}catch(Exception e){
			result.put("cars",null);
			result.put("success",false);
		}

		return result;
	}


	@RequestMapping(value = "/getCustomerInfo", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getCustomerInfo(HttpServletRequest request){
		String phone =  request.getParameter(Customer.PHONE);
		Map<String, Object> custParam = new HashMap<String, Object>();
		custParam.put(Customer.PHONE, phone);
		JSONObject result = new JSONObject();
		try{
			Customer cust = custBaseService.singleQryByCondtion(custParam);
			result.put("id",cust.getId());
			result.put("name",cust.getName());
			result.put("storeId",cust.getStoreId());
			result.put("code",cust.getCode());
			result.put("phone",cust.getPhone());
			result.put("success",true);
		}catch (Exception e){
			result.put("success",false);
		}
		return result;
	}




}
