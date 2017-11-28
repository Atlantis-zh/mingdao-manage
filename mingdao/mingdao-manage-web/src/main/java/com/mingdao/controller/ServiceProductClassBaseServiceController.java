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
import com.mingdao.api.IServiceProductClassBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.ServiceProductClass;

/**
 *
 * <code>ServiceProductClassBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午2:46:11
 * @author libin
 */
@Controller
@RequestMapping("/serProdClassBaseSer")
public class ServiceProductClassBaseServiceController extends BaseController {

  @Autowired
  private IServiceProductClassBaseService spcBaseService;


  @RequestMapping("serviceProjectClasss")
  public String getServiceProductClass(Model model, HttpServletRequest request) {
      String name = request.getParameter("search_Name");
      String code = request.getParameter("search_Code");
      Map<String, Object> param = new HashMap<String, Object>();
      if (!StringUtils.isEmpty(name)) {
    	  param.put("name", name);
      }
      if (!StringUtils.isEmpty(code)) {
    	  param.put("code", code);
      }

		Pager<ServiceProductClass> list = spcBaseService.pageQueryByCondition(param);
      model.addAttribute("datas", list);
      return "servieProjectClass/list";
  }

  
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
  @RequestMapping(value = "/addServiceProductClass", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addServiceProductClass(HttpServletRequest request,
			@RequestBody ServiceProductClass neSpc) {
    ResultMessage result = new ResultMessage();
    super.setTimeStampWithInsert(neSpc, request);
    neSpc = spcBaseService.insert(neSpc);
    if (neSpc.getId() != null) {
      result.setSuccess(true);
      result.setResult(neSpc.getId());
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
  @RequestMapping(value = "/updateServiceProductClass", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateServiceProductClass(HttpServletRequest request,
			@RequestBody JSONObject jsonObj) {
    ResultMessage result = new ResultMessage();
    ServiceProductClass oldSpc = spcBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldSpc == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldSpc.setStoreId(jsonObj.getLong("storeId"));
    oldSpc.setCode(jsonObj.getString("code"));
    oldSpc.setName(jsonObj.getString("name"));
    oldSpc.setWorkTimeClassId(jsonObj.getLong("workTimeClassId"));
    oldSpc.setParentId(jsonObj.getLong("parentId"));
    super.setTimeStampWithUpdate(oldSpc, request);
    int updateRet = spcBaseService.update(oldSpc);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldSpc));
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
  @RequestMapping(value = "/deleteServiceProductClassById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteServiceProductClassById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = spcBaseService.deleteDocById(id);
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
  @RequestMapping(value = "/qryServiceProductClasses", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryServiceProductClasses(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    Long parentId = Long.valueOf(request.getParameter("parentId"));
    if (parentId != null) {
      param.put("parentId", parentId);
    }
    List<ServiceProductClass> list = spcBaseService.qryAllDoces(param);
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
   * 说明：分页查询所有
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryServiceProductClasses", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryServiceProductClasses(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    Long parentId = Long.valueOf(request.getParameter("parentId"));
    if (parentId != null) {
      param.put("parentId", parentId);
    }
    Pager<ServiceProductClass> opPager = spcBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<ServiceProductClass> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryServiceProductClassById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryProductClassById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    ServiceProductClass spc = spcBaseService.queryDocById(id);
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
