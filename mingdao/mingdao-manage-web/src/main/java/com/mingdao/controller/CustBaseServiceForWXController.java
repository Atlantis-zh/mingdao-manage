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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mingdao.api.ICustomerBaseService;
import com.mingdao.domain.Customer;
import com.mingdao.domain.ResultMessage;
import com.mingdao.enumprop.Sex;
import com.mingdao.web.consts.MingDaoHttpRequestConsts;

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
@RequestMapping("/weixin/customerBaseSer")
public class CustBaseServiceForWXController extends BaseController {

  @Autowired
  private ICustomerBaseService custBaseService;

  @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
  public @ResponseBody String addCustomer(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    String phone = jsonObj.getString(MingDaoHttpRequestConsts.PHONE);
    Map<String, Object> param = new HashMap<String, Object>();
    param.put(Customer.PHONE, phone);
    Customer cust = custBaseService.singleQryByCondtion(param);
    if (cust != null) {
      result.setSuccess(false);
      result.setResultMsg("手机号[" + phone + "]已经注册!");
      return result.toString();
    }
    cust = new Customer();
    cust.setPhone(phone);
    cust.setCode(phone);
    super.setTimeStampWithInsert(cust, request);
    custBaseService.insert(cust);
    if (cust.getId() != null) {
      result.setSuccess(true);
      result.setResult(cust.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("注册失败，请检查日志！");
    }
    return result.toString();
  }

  @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
  public @ResponseBody JSONObject updateCustomer(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String phone = request.getParameter(MingDaoHttpRequestConsts.PHONE);
    String field = request.getParameter(MingDaoHttpRequestConsts.FIELD);
    String value = request.getParameter(MingDaoHttpRequestConsts.VALUE);
    Map<String, Object> param = new HashMap<String, Object>();
    param.put(Customer.PHONE, phone);
    Customer cust = custBaseService.singleQryByCondtion(param);
    if (cust == null) {
      result.setSuccess(false);
      result.setResultMsg("手机号[" + phone + "]未注册!");
      return result;
    }
    if (field.equals(Customer.ADDRESS)) {
      cust.setAddress(value);
    } else if (field.equals(Customer.NAME)) {
      cust.setName(value);
    } else if (field.equals(Customer.SEX)) {
      cust.setSex(Sex.valueOf(value));
    } else if (field.equals(Customer.IDENTITYID)) {
      cust.setIdentityId(value);
    } else if (field.equals(Customer.WXNICKNAME)) {
      cust.setWxNickName(value);
    } else if (field.equals(Customer.PHONE)) {
      cust.setPhone(value);
    }
    cust = custBaseService.update(cust);
    if (cust == null) {
      result.setSuccess(false);
      result.setResultMsg("修改失败！");
      return result;
    }
    result.setSuccess(true);
    result.setResult("修改成功！");
    return result;
  }

  /**
   * 
   * <p>
   * 说明：需要对信息进行非对称加密
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年10月19日 下午2:05:35
   * @since
   */
  @RequestMapping(value = "/qryCustomerByPhone", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryCustomerByPhone(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String phone = request.getParameter(MingDaoHttpRequestConsts.PHONE);
    Map<String, Object> param = new HashMap<String, Object>();
    param.put(Customer.PHONE, phone);
    Customer cust = custBaseService.singleQryByCondtion(param);
    if (cust == null) {
      result.setSuccess(false);
      result.setResultMsg("手机号[" + phone + "]未注册!");
      return result;
    }
    ObjectMapper mapper = new ObjectMapper();
    try {

      // String json = mapper.writeValueAsString(cust);
      result.setSuccess(true);
      result.setResult(cust);
    } catch (Exception e) {
      result.setSuccess(false);
      result.setResultMsg("数据转换失败，原因：" + e.getMessage());
    } // 将对象转换成json
    return result;
  }

}
