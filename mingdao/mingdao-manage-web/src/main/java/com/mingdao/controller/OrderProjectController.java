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
@RequestMapping("/orderProjectBaseSer")
public class OrderProjectController extends BaseController {

  @Autowired
  private IOrderProjectBaseService orderProjectService;

  @Autowired
  private ICustomerBaseService custBaseService;



  /**
   * 
   * <p>
   * 说明：新增预约项目的接口
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月19日 下午4:30:35
   * @since NC6.5
   */
  @RequestMapping(value = "/addOrderProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addOrderProject(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String id = request.getParameter("id");
    String storeIdStr =  request.getParameter("storeId");
    String serviceProjectIdStr =  request.getParameter("serviceProjectId");
    String orderTimeStr =  request.getParameter("orderTime");
    String customerIdStr =  request.getParameter("customerId");
    String carInfoIdStr =  request.getParameter("carInfoId");

    OrderProject op = new OrderProject();
    if(!org.springframework.util.StringUtils.isEmpty(id)){
      long pk = Long.valueOf(id);
      op.setId(pk);
    }
    op.setStoreId(Long.valueOf(storeIdStr));
    //op.setOrderPsnId(jsonObj.getLong("orderPsnId"));
    op.setServiceProjectId(Long.valueOf(serviceProjectIdStr));
    op.setOrderTime(orderTimeStr);
    op.setCustomerId(Long.valueOf(customerIdStr));
    op.setCarInfoId(Long.valueOf(carInfoIdStr));
    op.setStatus(0);// 新增默认都是未确认
   /* op.setSource(jsonObj.getInteger("source"));
    op.setMeno(jsonObj.getString("meno"));*/
    int successCount = 0;
    if(op.getId()!=null && op.getId()!=0){
      super.setTimeStampWithUpdate(op, request);
      successCount = orderProjectService.update(op);
    }else{
      super.setTimeStampWithInsert(op, request);
      op = orderProjectService.insert(op);
    }

    if (op.getId() != null ||successCount>0) {
      result.setSuccess(true);
      result.setResult(op.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("保存预约项目失败，请检查日志！");
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：查询预约项目，目前支持根据门店和所属状态来查以及根据客户id进行查询 其他的查询再说
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月19日 下午4:27:10
   * @since NC6.5
   */
  @RequestMapping(value = "/qryOrderProjects", method = RequestMethod.GET)
  public @ResponseBody ResultMessage queryOrderProjects(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String phone = request.getParameter("phone");
    if (StringUtils.isEmpty(phone)) {
      result.setSuccess(false);
      result.setResultMsg("传入手机号码！！");
      return result;
    }
    Map<String, Object> param1 = new HashMap<String, Object>();
    param1.put("phone", phone);
    Pager<Customer> data = custBaseService.pageQueryByCondition(param1);
    Customer customer = new Customer();
    if(data!=null && data.getDatas()!=null ){
      List<Customer> list = data.getDatas();
      customer =  list.get(0);
    }else{
      result.setSuccess(false);
      result.setResultMsg("传入手机号码！！");
      return result;
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", customer.getStoreId());
    param.put("customerId", customer.getId());
    Pager<OrderProject> opPager = orderProjectService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询预约项目失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<OrderProject> list = opPager.getDatas();
    JSONArray array = new JSONArray();
    if (!CollectionUtils.isEmpty(list)) {
      array = DataUtil.list2JsonArray(list);
    }
    obj.put(PageResultConst.DATAS, array);
    result.setSuccess(true);
    result.setResult(obj);
    return result;
  }


  @RequestMapping(value = "/getOrderById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage getOrderById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String id = request.getParameter("id");
    if (StringUtils.isEmpty(id)) {
      result.setSuccess(false);
      result.setResultMsg("传入id！！");
      return result;
    }
    long pk = Long.valueOf(id);
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("id", pk);
    Pager<OrderProject> opPager = orderProjectService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询预约项目失败，请稍后重试！");
      return result;
    }
    List<OrderProject> list = opPager.getDatas();
    JSONObject obj = DataUtil.superVOToJsonObject(list.get(0));
    result.setSuccess(true);
    result.setResult(obj);
    return result;
  }


  @RequestMapping(value = "/getSystemMessage", method = RequestMethod.GET)
  public @ResponseBody ResultMessage getSystemMessage(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String phone = request.getParameter("phone");
    /***
     * 这里是根据手机号查询消息，暂时做的是假接口
     */
    JSONArray array = new JSONArray();
    JSONObject obj1 = new JSONObject();
    JSONObject obj2 = new JSONObject();
    JSONObject obj3 = new JSONObject();
    obj1.put("date","2017-11-29");
    obj1.put("title","维修明细单");
    obj1.put("content","王红丽女士，您好，您于2017-11-29日，于青岛名道汽修店消费480元，明细如下，换米其林轮胎一件480元，请知晓！！");

    obj2.put("date","2017-11-30");
    obj2.put("title","洗车明细单");
    obj2.put("content","王红丽女士，您好，您于2017-11-30日，于青岛名道汽修店消费50元，明细如下，自助洗车一次50元，请知晓！！");

    obj3.put("date","2017-11-30");
    obj3.put("title","保养明细单");
    obj3.put("content","王红丽女士，您好，您于2017-11-30日，于青岛名道汽修店消费1200元，明细如下，做保养一次1200元，请知晓！！");
    array.add(obj1);
    array.add(obj2);
    array.add(obj3);
    result.setSuccess(true);
    result.setResult(array);
    return result;
  }

  @RequestMapping(value = "/updateOrderProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateOrderProject(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String idStr =  request.getParameter("id");
    String storeIdStr =  request.getParameter("storeId");
    String serviceProjectIdStr =  request.getParameter("serviceProjectId");
    String orderTimeStr =  request.getParameter("orderTime");
    String customerIdStr =  request.getParameter("customerId");
    String carInfoIdStr =  request.getParameter("carInfoId");

    OrderProject oldOP = orderProjectService.queryDocById(Long.valueOf(idStr));
    if (oldOP == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }

    oldOP.setId(Long.valueOf(idStr));
    oldOP.setStoreId(Long.valueOf(storeIdStr));
    oldOP.setServiceProjectId(Long.valueOf(serviceProjectIdStr));
    oldOP.setOrderTime(orderTimeStr);
    oldOP.setCustomerId(Long.valueOf(customerIdStr));
    oldOP.setCarInfoId(Long.valueOf(carInfoIdStr));
    //oldOP.setMeno(jsonObj.getString("meno"));
    super.setTimeStampWithUpdate(oldOP, request);
    int updateRet = orderProjectService.update(oldOP);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult("更新成功！！");
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
  @RequestMapping(value = "/deleteOrderProjectById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteOrderProjectById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = orderProjectService.deleteDocById(id);
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
