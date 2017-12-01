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
import com.mingdao.api.IIntegralRuleBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.IntegralRule;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>IntegralRuleBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年12月2日 上午12:22:50
 * @author libin
 */
@Controller
@RequestMapping("/integralRuleBaseSer")
public class IntegralRuleBaseServiceController extends BaseController {

  @Autowired
  private IIntegralRuleBaseService spBaseService;

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
  @RequestMapping(value = "/addIntegralRule", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addIntegralRule(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    IntegralRule newsp = new IntegralRule();
    newsp.setStoreId(jsonObj.getLong("storeId"));
    newsp.setCardTypeId(jsonObj.getLong("cardTypeId"));
    newsp.setConsume(jsonObj.getDouble("consume"));
    newsp.setMemo(jsonObj.getString("memo"));
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
  @RequestMapping(value = "/updateIntegralRule", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateIntegralRule(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    IntegralRule oldSp = spBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldSp == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldSp.setStoreId(jsonObj.getLong("storeId"));
    oldSp.setCardTypeId(jsonObj.getLong("cardTypeId"));
    oldSp.setConsume(jsonObj.getDouble("consume"));
    oldSp.setMemo(jsonObj.getString("memo"));
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
  @RequestMapping(value = "/deleteIntegralRuleById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteIntegralRuleById(HttpServletRequest request) {
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
   * 说明：分页查询所有
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryIntegralRules", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryIntegralRules(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    if (!StringUtils.isEmpty(request.getParameter("cardTypeId"))) {
      param.put("cardTypeId", Long.valueOf(request.getParameter("cardTypeId")));
    }
    Pager<IntegralRule> opPager = spBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<IntegralRule> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryIntegralRuleById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryIntegralRuleById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    IntegralRule spc = spBaseService.queryDocById(id);
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
