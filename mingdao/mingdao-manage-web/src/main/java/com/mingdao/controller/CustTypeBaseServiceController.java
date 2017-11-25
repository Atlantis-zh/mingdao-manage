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
import com.mingdao.api.ICustTypeBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.CustType;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>CustTypeBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 下午8:12:00
 * @author libin
 */
@Controller
@RequestMapping("/custTypeBaseSer")
public class CustTypeBaseServiceController extends BaseController {
  @Autowired
  private ICustTypeBaseService apBaseService;

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
  @RequestMapping(value = "/addCustType", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addCustType(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    CustType newap = new CustType();
    newap.setStoreId(jsonObj.getLong("storeId"));
    newap.setCode(jsonObj.getString("code"));
    newap.setName(jsonObj.getString("name"));
    newap.setParentId(jsonObj.getLong("parentId"));
    super.setTimeStampWithInsert(newap, request);
    newap = apBaseService.insert(newap);
    if (newap.getId() != null) {
      result.setSuccess(true);
      result.setResult(newap.getId());
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
  @RequestMapping(value = "/updateCustType", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateCustType(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    CustType oldap = apBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldap == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldap.setStoreId(jsonObj.getLong("storeId"));
    oldap.setCode(jsonObj.getString("code"));
    oldap.setName(jsonObj.getString("name"));
    oldap.setParentId(jsonObj.getLong("parentId"));
    super.setTimeStampWithUpdate(oldap, request);
    int updateRet = apBaseService.update(oldap);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldap));
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
  @RequestMapping(value = "/deleteCustTypeById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteCustTypeById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = apBaseService.deleteDocById(id);
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
  @RequestMapping(value = "/qryCustTypes", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryCustTypes(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    if (!StringUtils.isEmpty(request.getParameter("parentId"))) {
      param.put("parentId", Long.valueOf(request.getParameter("parentId")));
    }
    List<CustType> list = apBaseService.qryAllDoces(param);
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
  @RequestMapping(value = "/pageQryCustTypes", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryCustTypes(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    if (!StringUtils.isEmpty(request.getParameter("parentId"))) {
      param.put("parentId", Long.valueOf(request.getParameter("parentId")));
    }
    Pager<CustType> opPager = apBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<CustType> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryCustTypeById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryCustTypeById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    CustType spc = apBaseService.queryDocById(id);
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
