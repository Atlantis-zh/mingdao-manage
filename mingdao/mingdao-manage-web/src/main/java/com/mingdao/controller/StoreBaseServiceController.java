package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IStoreBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
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

  
  @RequestMapping("stores")
  public String getStoreInfo(Model model,HttpServletRequest request){
      Store role = new Store();
      String name =  request.getParameter("search_StoreName");
      String code =  request.getParameter("search_StoreCode");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<Store> opPager = storeBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "store/list";
  }

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
			@RequestBody Store store) {
    ResultMessage result = new ResultMessage();
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

  /**
   * 
   * <p>
   * 说明：更新门店
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月25日 上午1:41:43
   * @since NC6.5
   */
  @RequestMapping(value = "/updateStore", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateStore(HttpServletRequest request,
			@RequestBody JSONObject jsonObj) {
    ResultMessage result = new ResultMessage();
    Store oldStore = storeBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldStore == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldStore.setCode(jsonObj.getString("code"));
    oldStore.setName(jsonObj.getString("name"));
    oldStore.setTel1(jsonObj.getString("tel1"));
    oldStore.setTel2(jsonObj.getString("tel2"));
    oldStore.setTel3(jsonObj.getString("tel3"));
    oldStore.setAddress(jsonObj.getString("address"));
    oldStore.setWxPubAccId(jsonObj.getString("wxPubAccId"));
    oldStore.setIsWxShow(jsonObj.getBoolean("isWxShow"));
    oldStore.setIsWxDefault(jsonObj.getBoolean("isWxDefault"));
    oldStore.setIsHeadStore(jsonObj.getBoolean("isHeadStore"));
    super.setTimeStampWithUpdate(oldStore, request);
    int updateRet = storeBaseService.update(oldStore);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldStore));
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：根据主键删除门店
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:00
   * @since NC6.5
   */
  @RequestMapping(value = "/deleteStore", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteStore(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = storeBaseService.deleteDocById(id);
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
   * 说明：分页查询所有门店
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryStores", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryStores(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Map<String, Object> param = new HashMap<String, Object>();
    Pager<Store> opPager = storeBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询所有门店信息失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<Store> list = opPager.getDatas();
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
   * 说明：根据主键查询所有门店
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:30
   * @since NC6.5
   */
  @RequestMapping(value = "/qryStoreById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryStoreById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    Store store = storeBaseService.queryDocById(id);
    if (store == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(store));
    }
    return result;
  }

}
