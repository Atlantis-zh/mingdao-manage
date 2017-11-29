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
import com.mingdao.api.IMeasdocBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.Measdoc;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>StoreBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：门店管理基本服务controller
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月27日
 * @author wushzh
 */


@Controller
@RequestMapping("/measdocBaseSer")
public class MeasdocBaseServiceController extends BaseController {

  @Autowired
  private IMeasdocBaseService measdocBaseService;

  
  @RequestMapping("measdoc")
  public String getStoreInfo(Model model,HttpServletRequest request){

      String name =  request.getParameter("search_name");
      String code =  request.getParameter("search_code");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<Measdoc> opPager = measdocBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "measdoc/list";
  }
  
  @RequestMapping("refmeasdoc")
  public String getRefmeasdoc(Model model,HttpServletRequest request){

      String name =  request.getParameter("search_name");
      String code =  request.getParameter("search_code");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<Measdoc> opPager = measdocBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "measdoc/refmeasdoc";
  }

  /**
   * 
   * <p>
   * 说明：新增计量单位
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月25日 上午12:07:06
   * @since NC6.5
   */
  @RequestMapping(value = "/addMeasdoc", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addMeasdoc(HttpServletRequest request,
			@RequestBody Measdoc measdoc) {
    ResultMessage result = new ResultMessage();
    super.setTimeStampWithInsert(measdoc, request);
    measdoc = measdocBaseService.insert(measdoc);
    if (measdoc.getId() != null) {
      result.setSuccess(true);
      result.setResult(measdoc.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增计量单位失败，请检查日志！");
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：更新计量单位
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @date 2017年11月25日 上午1:41:43
   * @since NC6.5
   */
  @RequestMapping(value = "/updateMeasdoc", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateMeasdoc(HttpServletRequest request,
			@RequestBody JSONObject jsonObj) {
    ResultMessage result = new ResultMessage();
    Measdoc oldMeasdoc = measdocBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldMeasdoc == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldMeasdoc.setCode(jsonObj.getString("code"));
    oldMeasdoc.setName(jsonObj.getString("name"));
    super.setTimeStampWithUpdate(oldMeasdoc, request);
    int updateRet = measdocBaseService.update(oldMeasdoc);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldMeasdoc));
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：根据主键删除计量单位
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:00
   * @since NC6.5
   */
  @RequestMapping(value = "/deleteMeasdoc", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteStore(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = measdocBaseService.deleteDocById(id);
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
   * 说明：分页查询所有计量单位
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryMeasdocs", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryStores(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Map<String, Object> param = new HashMap<String, Object>();
    Pager<Measdoc> opPager = measdocBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询所有计量单位失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<Measdoc> list = opPager.getDatas();
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
   * 说明：根据主键查询计量单位
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:30
   * @since NC6.5
   */
  @RequestMapping(value = "/qryMeasdocById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryStoreById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    Measdoc measdoc = measdocBaseService.queryDocById(id);
    if (measdoc == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(measdoc));
    }
    return result;
  }

}
