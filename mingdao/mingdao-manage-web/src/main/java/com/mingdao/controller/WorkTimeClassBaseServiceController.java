package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IWorkTimeClassBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.WorkTimeClass;

/**
 *
 * <code>WorkTimeClassBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：工时分类的controller
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午1:51:06
 * @author libin
 */

@Controller
@RequestMapping("/wktBaseSer")
public class WorkTimeClassBaseServiceController extends BaseController {

  @Autowired
  private IWorkTimeClassBaseService wktBaseService;

  
  @RequestMapping("workTimeClasss")
  public String getWorkTimeClasss(Model model, HttpServletRequest request) {

      String name = request.getParameter("search_Name");
      String code = request.getParameter("search_Code");
      Map<String, Object> param = new HashMap<String, Object>();
      if (!StringUtils.isEmpty(name)) {
         
          param.put("name",name);
      }
      if (!StringUtils.isEmpty(code)) {
         
          param.put("code",code);
      }

      
      Pager<WorkTimeClass> opPager = wktBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "worktimeclass/list";
  }


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
  @RequestMapping(value = "/addWorkTimeClass", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addWorkTimeClass(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);

    WorkTimeClass newWkt = new WorkTimeClass();
    newWkt.setStoreId(jsonObj.getLong("storeId"));
    newWkt.setCode(jsonObj.getString("code"));
    newWkt.setName(jsonObj.getString("name"));
    newWkt.setMinutes(jsonObj.getInteger("minutes"));
    newWkt.setPrice(jsonObj.getDouble("price"));
    newWkt.setIsDefault(jsonObj.getBoolean("isDefault"));
    super.setTimeStampWithInsert(newWkt, request);
    newWkt = wktBaseService.insert(newWkt);
    if (newWkt.getId() != null) {
      result.setSuccess(true);
      result.setResult(newWkt.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增工时分类失败，请检查日志！");
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
  @RequestMapping(value = "/updateWorkTimeClass", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateWorkTimeClass(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    WorkTimeClass oldWkt = wktBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldWkt == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldWkt.setStoreId(jsonObj.getLong("storeId"));
    oldWkt.setCode(jsonObj.getString("code"));
    oldWkt.setName(jsonObj.getString("name"));
    oldWkt.setMinutes(jsonObj.getInteger("minutes"));
    oldWkt.setPrice(jsonObj.getDouble("price"));
    oldWkt.setIsDefault(jsonObj.getBoolean("isDefault"));
    super.setTimeStampWithUpdate(oldWkt, request);
    int updateRet = wktBaseService.update(oldWkt);
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
  @RequestMapping(value = "/deleteWorkTimeClass", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteWorkTimeClass(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = wktBaseService.deleteDocById(id);
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
  @RequestMapping(value = "/pageQryWorkTimeClasses", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryWorkTimeClasses(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    Pager<WorkTimeClass> opPager = wktBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询工时分类失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<WorkTimeClass> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryWorkTimeClassById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryWorkTimeClassById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    WorkTimeClass wkt = wktBaseService.queryDocById(id);
    if (wkt == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(wkt));
    }
    return result;
  }

}
