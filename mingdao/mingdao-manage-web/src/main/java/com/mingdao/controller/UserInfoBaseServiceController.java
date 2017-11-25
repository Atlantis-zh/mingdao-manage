package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.UserInfo;

/**
 *
 * <code>UserInfoBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午3:45:32
 * @author libin
 */
@Controller
@RequestMapping("/userInfoBaseSer")
public class UserInfoBaseServiceController extends BaseController {

  @Autowired
  private IUserInfoBaseServiceItf uiBaseService;

  
  @RequestMapping("users")
  public String getUserInfo(Model model,HttpServletRequest request){
      UserInfo user = new UserInfo();
      String name =  request.getParameter("search_userName");
      String code =  request.getParameter("search_userCode");

      Map<String, Object> param = new HashMap<String, Object>();
      

      if(!StringUtils.isEmpty(name)){

          param.put("userName", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("userCode", code);
      }
      
      Pager<UserInfo> opPager = uiBaseService.pageQueryByCondition(param);
      model.addAttribute("datas", opPager);
      return "user/list";
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
  @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addUserInfo(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    UserInfo userInfo = new UserInfo();
    userInfo.setStoreId(jsonObj.getLong("storeId"));
    userInfo.setUserCode(jsonObj.getString("userCode"));
    userInfo.setUserName(jsonObj.getString("userName"));
    userInfo.setPassWord(jsonObj.getString("passWord"));
    userInfo.setNickName(jsonObj.getString("nickName"));
    userInfo.setPhone(jsonObj.getString("phone"));
    userInfo.setEmail(jsonObj.getString("email"));
    userInfo.setStatus(1);
    super.setTimeStampWithInsert(userInfo, request);
    userInfo = uiBaseService.insert(userInfo);
    if (userInfo.getId() != null) {
      result.setSuccess(true);
      result.setResult(userInfo.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增档案失败，请检查日志！");
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
  @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateUserInfo(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    UserInfo oldui = uiBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldui == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldui.setStoreId(jsonObj.getLong("storeId"));
    oldui.setUserName(jsonObj.getString("userName"));
    oldui.setPassWord(jsonObj.getString("passWord"));
    oldui.setNickName(jsonObj.getString("nickName"));
    oldui.setEmail(jsonObj.getString("email"));
    super.setTimeStampWithUpdate(oldui, request);
    int updateRet = uiBaseService.update(oldui);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldui));
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
  @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteUserInfo(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = uiBaseService.deleteDocById(id);
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
  @RequestMapping(value = "/pageQryUserInfos", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryUserInfos(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    if (storeId == null) {
      result.setSuccess(false);
      result.setResultMsg("所属门店不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    Integer status = Integer.valueOf(request.getParameter("status"));
    if (status == null) {
      param.put("status", status);
    }

    Pager<UserInfo> opPager = uiBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询所有门店信息失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<UserInfo> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryUserInfoById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryUserInfoById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    UserInfo store = uiBaseService.queryDocById(id);
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
