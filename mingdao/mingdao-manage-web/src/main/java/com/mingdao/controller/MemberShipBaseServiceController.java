package com.mingdao.controller;

import java.util.ArrayList;
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
import com.mingdao.api.IMemberInfoBaseService;
import com.mingdao.api.IMemberShipBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.MemberInfo;
import com.mingdao.domain.MemberShip;
import com.mingdao.domain.MemberShipRefDTO;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>MemberShipBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月26日 上午1:32:24
 * @author libin
 */
@Controller
@RequestMapping("/memberShipBaseSer")
public class MemberShipBaseServiceController extends BaseController {

  @Autowired
  private IMemberShipBaseService spBaseService;
  
  @Autowired
  IMemberInfoBaseService memberInfoBaseService;

  
  @RequestMapping("member")
  public String getMemberShip(Model model,HttpServletRequest request){

      String name =  request.getParameter("search_name");
      String code =  request.getParameter("search_code");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<MemberShip> opPager = spBaseService.pageQueryByCondition(param);
//      List<MemberShipDTO> dtos = this.getDto(opPager.getDatas());
//      Pager<ProductClassDTO> dtoPager = new Pager<ProductClassDTO>(dtos.size(),dtos);

      model.addAttribute("datas", opPager);
      return "member/list";
  }
  
  @RequestMapping(value = "/refmembervos", method = RequestMethod.GET)
  public @ResponseBody ResultMessage  getRefMembervos(HttpServletRequest request){

	    ResultMessage result = new ResultMessage();
	    Map<String, Object> param = new HashMap<String, Object>();
	    Pager<MemberShip> opPager = spBaseService.pageQueryByCondition(param);
	    if (opPager == null) {
	      result.setSuccess(false);
	      result.setResultMsg("查询失败，请稍后重试！");
	      return result;
	    }
	    JSONObject obj = new JSONObject();
	    obj.put(PageResultConst.PAGE, opPager.getOffset());
	    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
	    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
	    List<MemberShip> list = opPager.getDatas();
	    List<MemberShipRefDTO> dtos = getDto(list);
	    JSONArray array = new JSONArray();
	    if (!CollectionUtils.isEmpty(dtos)) {
	      array = DataUtil.list2JsonArray(dtos);
	    }
	    obj.put(PageResultConst.DATAS, array);
	    result.setSuccess(true);
	    result.setResult(obj);
	    return result;
  }
  
  private List<MemberShipRefDTO> getDto(List<MemberShip> list){
	  List<MemberShipRefDTO> dtos = new ArrayList<MemberShipRefDTO>();
	  for(MemberShip vo: list){
		  dtos.add(vo.getDto());
	  }
	  return dtos;
	  
  }
  
  @RequestMapping("refmember")
  public String getRefMemberShip(Model model,HttpServletRequest request){

      String name =  request.getParameter("search_name");
      String code =  request.getParameter("search_code");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<MemberShip> opPager = spBaseService.pageQueryByCondition(param);
//      List<MemberShipDTO> dtos = this.getDto(opPager.getDatas());
//      Pager<ProductClassDTO> dtoPager = new Pager<ProductClassDTO>(dtos.size(),dtos);

      model.addAttribute("datas", opPager);
      return "member/list";
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
  @RequestMapping(value = "/addMemberShip", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addMemberShip(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemberShip newsp = new MemberShip();
    newsp.setStoreId(jsonObj.getLong("storeId"));
    newsp.setCardNo(jsonObj.getString("cardNo"));
    newsp.setCustomerId(jsonObj.getLong("customerId"));
    newsp.setCarInfoId(jsonObj.getLong("carInfoId"));
    newsp.setMemberShipCardId(jsonObj.getLong("memberShipCardId"));
    newsp.setPackageTypeId(jsonObj.getLong("packageTypeId"));
    newsp.setCrash(jsonObj.getDouble("crash"));
    newsp.setPoints(jsonObj.getInteger("points"));
    newsp.setRemaining(jsonObj.getDouble("remaining"));
    newsp.setTotalRemainCount(jsonObj.getInteger("totalRemainCount"));
    newsp.setPercentagePsnId(jsonObj.getLong("percentagePsnId"));
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
  @RequestMapping(value = "/updateMemberShip", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateMemberShip(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemberShip oldSp = spBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldSp == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldSp.setStoreId(jsonObj.getLong("storeId"));
    oldSp.setCardNo(jsonObj.getString("cardNo"));
    oldSp.setCustomerId(jsonObj.getLong("customerId"));
    oldSp.setCarInfoId(jsonObj.getLong("carInfoId"));
    oldSp.setMemberShipCardId(jsonObj.getLong("memberShipCardId"));
    oldSp.setPackageTypeId(jsonObj.getLong("packageTypeId"));
    oldSp.setCrash(jsonObj.getDouble("crash"));
    oldSp.setPoints(jsonObj.getInteger("points"));
    oldSp.setRemaining(jsonObj.getDouble("remaining"));
    oldSp.setTotalRemainCount(jsonObj.getInteger("totalRemainCount"));
    oldSp.setPercentagePsnId(jsonObj.getLong("percentagePsnId"));
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
  @RequestMapping(value = "/deleteMemberShipById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteMemberShipById(HttpServletRequest request) {
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
  @RequestMapping(value = "/pageQryMemberShips", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryMemberShips(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    Pager<MemberShip> opPager = spBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<MemberShip> list = opPager.getDatas();
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
   * 说明：分页查询所有
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryMemberinfo", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryMemberInfo(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    String phone = request.getParameter("phone");
    if (phone == null) {
      result.setSuccess(false);
      result.setResultMsg("手机号不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("phone", phone);
    MemberInfo vo  = memberInfoBaseService.singleQryByCondtion(param);
    List<MemberInfo> info = new ArrayList<MemberInfo>();
    info.add(vo);
    Pager<MemberInfo> pages = new Pager<MemberInfo>(1, info);
    if (vo == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, pages.getOffset());
    obj.put(PageResultConst.PAGESIZE, pages.getSize());
    obj.put(PageResultConst.TOTALCOUNT, pages.getTotal());
    List<MemberInfo> list = pages.getDatas();
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
  @RequestMapping(value = "/qryMemberShipById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryMemberShipById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    MemberShip spc = spBaseService.queryDocById(id);
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
