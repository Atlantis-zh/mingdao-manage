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
import com.mingdao.api.IMemberShipCardBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.MemberShipCard;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.Store;

/**
 *
 * <code>MemberShipCardBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li>会员卡种control</li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 下午10:05:10
 * @author libin
 */
@Controller
@RequestMapping("/memberShipCardBaseSer")
public class MemberShipCardBaseServiceController extends BaseController {
  @Autowired
  private IMemberShipCardBaseService spBaseService;

  @RequestMapping("membership")
  public String getStoreInfo(Model model,HttpServletRequest request){
	  
      String name =  request.getParameter("search_StoreName");
      String code =  request.getParameter("search_StoreCode");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<MemberShipCard> opPager = spBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "membership/list";
  }
  @RequestMapping("refcardtype")
  public String getRefInfo(Model model,HttpServletRequest request){
    
      String name =  request.getParameter("search_StoreName");
      String code =  request.getParameter("search_StoreCode");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
        param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
        param.put("code", code);
      }

      Pager<MemberShipCard> opPager = spBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "vip/reflist";
  }

  /**
   * 卡类型
   * @param model
   * @param request
   * @return
   */

  @RequestMapping("cardtype")
  public String getCardInfo(Model model,HttpServletRequest request){
    
      String name =  request.getParameter("search_StoreName");
      String code =  request.getParameter("search_StoreCode");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
        param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
        param.put("code", code);
      }

      Pager<MemberShipCard> opPager = spBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "vip/list";
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
  @RequestMapping(value = "/addMemberShipCard", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addMemberShipCard(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemberShipCard newsp = new MemberShipCard();
    newsp.setStoreId(jsonObj.getLong("storeId"));
    newsp.setCode(jsonObj.getString("code"));
    newsp.setName(jsonObj.getString("name"));
    newsp.setCardRecharge(jsonObj.getDouble("cardRecharge"));
    newsp.setCardDonate(jsonObj.getDouble("cardDonate"));
    newsp.setExpire(jsonObj.getInteger("expire"));
    newsp.setTimeUnit(jsonObj.getInteger("timeUnit"));
    newsp.setCardPicture(jsonObj.getString("cardPicture"));
    newsp.setShareToBranch(jsonObj.getBoolean("shareToBranch"));
    newsp.setSource(jsonObj.getInteger("source"));
    newsp.setBindPackage(jsonObj.getLong("bindPackage"));
    newsp.setStatus(jsonObj.getInteger("status"));
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
  @RequestMapping(value = "/updateMemberShipCard", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateMemberShipCard(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemberShipCard oldSp = spBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldSp == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldSp.setStoreId(jsonObj.getLong("storeId"));
    oldSp.setCode(jsonObj.getString("code"));
    oldSp.setName(jsonObj.getString("name"));
    oldSp.setCardRecharge(jsonObj.getDouble("cardRecharge"));
    oldSp.setCardDonate(jsonObj.getDouble("cardDonate"));
    oldSp.setExpire(jsonObj.getInteger("expire"));
    oldSp.setTimeUnit(jsonObj.getInteger("timeUnit"));
    oldSp.setCardPicture(jsonObj.getString("cardPicture"));
    oldSp.setShareToBranch(jsonObj.getBoolean("shareToBranch"));
    oldSp.setSource(jsonObj.getInteger("source"));
    oldSp.setBindPackage(jsonObj.getLong("bindPackage"));
    oldSp.setStatus(jsonObj.getInteger("status"));
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
  @RequestMapping(value = "/deleteMemberShipCardById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteMemberShipCardById(HttpServletRequest request) {
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
  @RequestMapping(value = "/pageQryMemberShipCards", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryMemberShipCards(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    Pager<MemberShipCard> opPager = spBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<MemberShipCard> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryMemberShipCardById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryMemberShipCardById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    MemberShipCard spc = spBaseService.queryDocById(id);
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
