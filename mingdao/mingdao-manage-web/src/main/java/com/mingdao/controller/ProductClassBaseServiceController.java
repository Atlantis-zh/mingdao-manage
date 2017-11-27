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
import com.mingdao.api.IProductClassBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>ProductClassBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午2:17:26
 * @author libin
 */
@Controller
@RequestMapping("/productClassBaseSer")
public class ProductClassBaseServiceController extends BaseController {

  @Autowired
  private IProductClassBaseService pcBaseService;


  @RequestMapping("productclass")
  public String getProductClass(Model model,HttpServletRequest request){

      String name =  request.getParameter("search_StoreName");
      String code =  request.getParameter("search_StoreCode");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<ProductClass> opPager = pcBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "product/productclass";
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
  @RequestMapping(value = "/addProductClass", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addProductClass(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    ProductClass newPc = new ProductClass();
    newPc.setStoreId(jsonObj.getLong("storeId"));
    newPc.setCode(jsonObj.getString("code"));
    newPc.setName(jsonObj.getString("name"));
    newPc.setParentId(jsonObj.getLong("parentId"));
    super.setTimeStampWithInsert(newPc, request);
    newPc = pcBaseService.insert(newPc);
    if (newPc.getId() != null) {
      result.setSuccess(true);
      result.setResult(newPc.getId());
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
  @RequestMapping(value = "/updateProductClass", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateProductClass(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    ProductClass oldPc = pcBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldPc == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldPc.setStoreId(jsonObj.getLong("storeId"));
    oldPc.setCode(jsonObj.getString("code"));
    oldPc.setName(jsonObj.getString("name"));
    oldPc.setParentId(jsonObj.getLong("parentId"));
    super.setTimeStampWithUpdate(oldPc, request);
    int updateRet = pcBaseService.update(oldPc);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldPc));
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
  @RequestMapping(value = "/deleteProductClassById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteProductClassById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = pcBaseService.deleteDocById(id);
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
  @RequestMapping(value = "/qryProductClasses", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryProductClasses(HttpServletRequest request) {
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
    List<ProductClass> list = pcBaseService.qryAllDoces(param);
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
  @RequestMapping(value = "/pageQryProductClasses", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryProductClasses(HttpServletRequest request) {
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
    Pager<ProductClass> opPager = pcBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<ProductClass> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryProductClassById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryProductClassById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    ProductClass pc = pcBaseService.queryDocById(id);
    if (pc == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(pc));
    }
    return result;
  }

}
