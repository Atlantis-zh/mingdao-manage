package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.ICustomerBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.Customer;
import com.mingdao.domain.ResultMessage;
import com.mingdao.web.consts.MingDaoHttpRequestConsts;

/**
 *
 * <code>CustomerBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：客户基本信息
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月17日 下午7:05:13
 * @author libinf
 */
@Controller
@RequestMapping("/customerBaseSer")
public class CustBaseServiceController extends BaseController {

  @Autowired
  private ICustomerBaseService custBaseService;


  /**
   * 
   * <p>
   * 说明：新增工时分类
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月25日 上午12:07:06
   * @since NC6.5
   */
  @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addCustomer(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    Customer newWkt = new Customer();
    newWkt.setStoreId(jsonObj.getLong("storeId"));
    newWkt.setCode(jsonObj.getString("code"));
    newWkt.setName(jsonObj.getString("name"));
    newWkt.setWxNickName(jsonObj.getString("wxNickName"));
    newWkt.setBirthday(jsonObj.getString("birthday"));
    newWkt.setPhone(jsonObj.getString("phone"));
    newWkt.setIdentityId(jsonObj.getString("identityId"));
    newWkt.setCustSourceId(jsonObj.getLong("custSourceId"));
    newWkt.setCustTypeId(jsonObj.getLong("custTypeId"));
    newWkt.setLpr(jsonObj.getBoolean("lpr"));
    newWkt.setSex(jsonObj.getInteger("sex"));
    newWkt.setAddress(jsonObj.getString("address"));
    super.setTimeStampWithInsert(newWkt, request);
    newWkt = custBaseService.insert(newWkt);
    if (newWkt.getId() != null) {
      result.setSuccess(true);
      result.setResult(newWkt.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增失败，请检查日志！");
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：更新
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月25日 上午1:41:43
   * @since NC6.5
   */
  @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateCustomer(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    Customer oldWkt = custBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldWkt == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldWkt.setStoreId(jsonObj.getLong("storeId"));
    oldWkt.setCode(jsonObj.getString("code"));
    oldWkt.setName(jsonObj.getString("name"));
    oldWkt.setWxNickName(jsonObj.getString("wxNickName"));
    oldWkt.setBirthday(jsonObj.getString("birthday"));
    oldWkt.setPhone(jsonObj.getString("phone"));
    oldWkt.setIdentityId(jsonObj.getString("identityId"));
    oldWkt.setCustSourceId(jsonObj.getLong("custSourceId"));
    oldWkt.setCustTypeId(jsonObj.getLong("custTypeId"));
    oldWkt.setLpr(jsonObj.getBoolean("lpr"));
    oldWkt.setSex(jsonObj.getInteger("sex"));
    oldWkt.setAddress(jsonObj.getString("address"));
    super.setTimeStampWithUpdate(oldWkt, request);
    int updateRet = custBaseService.update(oldWkt);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldWkt));
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：根据主键删除
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:00
   * @since NC6.5
   */
  @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteCustomer(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = custBaseService.deleteDocById(id);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("删除数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult("删除成功！");
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：分页查询所有
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryCustomers", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryCustomers(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
		Map<String, Object> param = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(request.getParameter("storeId"))) {
			Long storeId = Long.valueOf(request.getParameter("storeId"));
			if (storeId == null) {
				result.setSuccess(false);
				result.setResultMsg("所属门店不能为空！");
			}
			param.put("storeId", storeId);
    }
    Pager<Customer> opPager = custBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询工时分类失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<Customer> list = opPager.getDatas();
    JSONArray array = new JSONArray();
    if (!CollectionUtils.isEmpty(list)) {
      array = DataUtil.list2JsonArray(list);
    }
    obj.put(PageResultConst.DATAS, array);
    result.setSuccess(true);
    result.setResult(obj);
    return result;
  }

  /**
   * 
   * <p>
   * 说明：根据主键查询档案
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:30
   * @since NC6.5
   */
  @RequestMapping(value = "/qryCustomerById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryWorkTimeClassById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    Customer wkt = custBaseService.queryDocById(id);
    if (wkt == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(wkt));
    }
    return result;
  }



  @RequestMapping(value = "/weixin/addCustomer", method = RequestMethod.POST)
  public @ResponseBody String addCustomerForWX(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    String phone = jsonObj.getString("phone");
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
    cust.setName(jsonObj.getString("name"));
    cust.setCode("wx" + phone);
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

  @RequestMapping(value = "/weixin/updateCustomer", method = RequestMethod.POST)
  public @ResponseBody JSONObject updateCustomerForWX(HttpServletRequest request) {
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
      cust.setSex(Integer.valueOf(value));
    } else if (field.equals(Customer.IDENTITYID)) {
      cust.setIdentityId(value);
    } else if (field.equals(Customer.WXNICKNAME)) {
      cust.setWxNickName(value);
    } else if (field.equals(Customer.PHONE)) {
      cust.setPhone(value);
    }
    int updateRet = custBaseService.update(cust);
    if (updateRet == 0) {
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
  @RequestMapping(value = "/weixin/qryCustomerByPhone", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryCustomerByPhoneForWX(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String phone = request.getParameter(MingDaoHttpRequestConsts.PHONE);
    Map<String, Object> param = new HashMap<String, Object>();
    param.put(Customer.PHONE, phone);
    Customer cust = custBaseService.singleQryByCondtion(param);
    if (cust == null) {
      result.setSuccess(false);
      result.setResultMsg("手机号[" + phone + "]未注册!");
      return result;
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(cust));
    }
    return result;
  }



  /**=======================================================================================================***/
  @RequestMapping(value = "/addPCCustomer", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addProduct(HttpServletRequest request,
                                                @RequestBody Customer customer) {
    ResultMessage result = new ResultMessage();
    super.setTimeStampWithInsert(customer, request);
    customer = custBaseService.insert(customer);
    if (customer.getId() != null) {
      result.setSuccess(true);
      result.setResult(customer.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增失败，请检查日志！");
    }
    return result;
  }


  @RequestMapping(value = "/updatePCustomer", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateProduct(HttpServletRequest request,
                                                   @RequestBody Customer newvo) {
    ResultMessage result = new ResultMessage();

    Customer oldPc = custBaseService.queryDocById(newvo.getId());
    if (oldPc == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }

    super.setTimeStampWithUpdate(oldPc, request);
    int updateRet = custBaseService.update(newvo);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult("更新成功");
    }
    return result;
  }



  @RequestMapping("qryProductById")
  @ResponseBody
  public JSONObject qryProductById(Model model,HttpServletRequest request){
    JSONObject result = new JSONObject();
    String id =  request.getParameter("id");
    Long pk = Long.valueOf(id);
    Customer customer= custBaseService.queryDocById(pk);
    JSONObject object = (JSONObject) JSONObject.toJSON(customer);
    result.put("result",object);
    result.put("success",true);
    result.put("resultMsg","获取成功！！");
    return result;
  }

  @RequestMapping("queryPCCustomer")
  public String getProduct(Model model,HttpServletRequest request){

    String name =  request.getParameter("search_name");
    String code =  request.getParameter("search_code");
    Map<String, Object> param = new HashMap<String, Object>();
    if(!StringUtils.isEmpty(name)){
      param.put("name", name);
    }
    if(!StringUtils.isEmpty(code)){
      param.put("code", code);
    }

    Pager<Customer> opPager = custBaseService.pageQueryByCondition(param);
    model.addAttribute("datas", opPager);
    return "customer/list";
  }


  /**
   *
   * <p>
   * 说明：根据主键删除
   * <li></li>
   * </p>
   *
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:00
   * @since NC6.5
   */
  @RequestMapping(value = "/deletePCCustomerById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteProductClassById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = custBaseService.deleteDocById(id);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("删除数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult("删除成功！");
    }
    return result;
  }
}




