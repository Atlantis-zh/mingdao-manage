package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.ICustomerBaseService;
import com.mingdao.api.IOrderProjectBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.OrderProject;
import com.mingdao.domain.ResultMessage;

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
public class OrderProjectServiceController extends BaseController {

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
  public @ResponseBody ResultMessage addOrderProject(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    OrderProject op = new OrderProject();
    op.setStoreId(jsonObj.getLong("storeId"));
    op.setOrderPsnId(jsonObj.getLong("orderPsnId"));
    op.setServiceProjectId(jsonObj.getLong("serviceProjectId"));
    op.setOrderTime(jsonObj.getString("orderTime"));
    op.setCustomerId(jsonObj.getLong("customerId"));
    op.setCarInfoId(jsonObj.getLong("carInfoId"));
    op.setStatus(0);// 新增默认都是未确认
    op.setSource(jsonObj.getInteger("source"));
    op.setMeno(jsonObj.getString("meno"));
    super.setTimeStampWithInsert(op, request);
    op = orderProjectService.insert(op);
    if (op.getId() != null) {
      result.setSuccess(true);
      result.setResult(op.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增预约项目失败，请检查日志！");
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
    if (StringUtils.isEmpty(request.getParameter("storeId"))) {
      result.setSuccess(false);
      result.setResultMsg("请选择所属门店！");
      return result;
    }
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    if (!StringUtils.isEmpty(request.getParameter("status"))) {
      param.put("status", Integer.valueOf(request.getParameter("status")));
    }
    if (!StringUtils.isEmpty(request.getParameter("customerId"))) {
      param.put("customerId", Integer.valueOf(request.getParameter("customerId")));
    }
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

  @RequestMapping(value = "/updateOrderProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateOrderProject(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    OrderProject oldOP = orderProjectService.queryOrderProjectById(jsonObj.getLong("id"));
    if (oldOP == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldOP.setStoreId(jsonObj.getLong("storeId"));
    oldOP.setOrderPsnId(jsonObj.getLong("orderPsnId"));
    oldOP.setServiceProjectId(jsonObj.getLong("serviceProjectId"));
    oldOP.setCarInfoId(jsonObj.getLong("carInfoId"));
    oldOP.setMeno(jsonObj.getString("meno"));
    super.setTimeStampWithUpdate(oldOP, request);
    OrderProject newOP = orderProjectService.update(oldOP);
    if (newOP == null) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.ObjectToJsonObject(newOP));
    }
    return result;
  }

}
