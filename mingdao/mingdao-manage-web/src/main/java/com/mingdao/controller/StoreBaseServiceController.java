package com.mingdao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IStoreBaseService;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.OrderProject;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.Store;

/**
 *
 * <code>StoreBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：门店管理基本服务controller
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月24日 下午11:45:58
 * @author libin
 */


@Controller
@RequestMapping("/storeBaseSer")
public class StoreBaseServiceController extends BaseController {

  @Autowired
  private IStoreBaseService storeBaseService;


  /**
   * 
   * <p>
   * 说明：新增门店
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月25日 上午12:07:06
   * @since NC6.5
   */
  @RequestMapping(value = "/addStore", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addStore(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    Store store = new Store();
    store.setCode(jsonObj.getString("code"));
    store.setName(jsonObj.getString("name"));
    store.setTel1(jsonObj.getString("tel1"));
    store.setTel2(jsonObj.getString("tel2"));
    store.setTel3(jsonObj.getString("tel3"));
    store.setAddress(jsonObj.getString("address"));
    store.setWxPubAccId(jsonObj.getString("wxPubAccId"));
    store.setIsWxShow(jsonObj.getBoolean("isWxShow"));
    store.setIsWxDefault(jsonObj.getBoolean("isWxDefault"));
    store.setIsHeadStore(jsonObj.getBoolean("isHeadStore"));
    super.setTimeStampWithInsert(store, request);
    store = storeBaseService.insert(store);
    if (store.getId() != null) {
      result.setSuccess(true);
      result.setResult(store.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增预约项目失败，请检查日志！");
    }
    return result;
  }


  @RequestMapping(value = "/updateStore", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateStore(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    OrderProject oldOP = storeBaseService.queryOrderProjectById(jsonObj.getLong("id"));
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
