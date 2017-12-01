package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IMemShipPackageConsumerDetailBaseService;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.MemShipPackageConsumerDetail;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>MemShipPackageConsumerDetailBaseSerController<code> <strong></strong>
 * <p>
 * 说明：会员套餐消费明细表controller
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年12月1日 下午11:57:20
 * @author libin
 */
@Controller
@RequestMapping("/memShipPackageComBaseSer")
public class MemShipPackageConsumerDetailBaseSerController extends BaseController {
  @Autowired
  private IMemShipPackageConsumerDetailBaseService spBaseService;

  /**
   * 
   * <p>
   * 说明：新增
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月25日 上午12:07:06
   * @since NC6.5
   */
  @RequestMapping(value = "/addMemShipPackageConsumerDetail", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addMemShipPackageConsumerDetail(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemShipPackageConsumerDetail newsp = new MemShipPackageConsumerDetail();
    newsp.setMemberShipId(jsonObj.getLong("memberShipId"));
    newsp.setOrderFormId(jsonObj.getLong("orderFormId"));
    newsp.setCost(jsonObj.getDouble("cost"));
    newsp.setIsPackagePay(jsonObj.getBoolean("isPackagePay"));
    newsp.setServiceType(jsonObj.getInteger("serviceType"));
    super.setTimeStampWithInsert(newsp, request);
    newsp = spBaseService.insert(newsp);
    if (newsp.getId() != null) {
      result.setSuccess(true);
      result.setResult(newsp.getId());
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
  @RequestMapping(value = "/updateMemShipPackageConsumerDetail", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateMemShipPackageConsumerDetail(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemShipPackageConsumerDetail oldSp = spBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldSp == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldSp.setMemberShipId(jsonObj.getLong("memberShipId"));
    oldSp.setOrderFormId(jsonObj.getLong("orderFormId"));
    oldSp.setCost(jsonObj.getDouble("cost"));
    oldSp.setIsPackagePay(jsonObj.getBoolean("isPackagePay"));
    oldSp.setServiceType(jsonObj.getInteger("serviceType"));
    super.setTimeStampWithUpdate(oldSp, request);
    int updateRet = spBaseService.update(oldSp);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldSp));
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
  @RequestMapping(value = "/deleteMemShipPackageConsumerDetailById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteMemShipPackageConsumerDetailById(
      HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = spBaseService.deleteDocById(id);
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
   * 说明：根据条件查询满足的所有档案
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/qryMemShipPackageConsumerDetails", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryMemShipPackageConsumerDetails(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long memberShipId = Long.valueOf(request.getParameter("memberShipId"));
    if (memberShipId == null) {
      result.setSuccess(false);
      result.setResultMsg("请求参数错误，会员id不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("memberShipId", memberShipId);
    List<MemShipPackageConsumerDetail> list = spBaseService.qryAllDoces(param);
    JSONArray array = new JSONArray();
    if (!CollectionUtils.isEmpty(list)) {
      array = DataUtil.list2JsonArray(list);
    }
    result.setSuccess(true);
    result.setResult(array);
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
  @RequestMapping(value = "/qryMemShipPackageConsumerDetailById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryMemShipPackageConsumerDetailById(
      HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    MemShipPackageConsumerDetail spc = spBaseService.queryDocById(id);
    if (spc == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(spc));
    }
    return result;
  }



}
