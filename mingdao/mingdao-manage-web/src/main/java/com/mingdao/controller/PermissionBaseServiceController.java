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
import com.mingdao.api.IPermissionBaseServiceItf;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.Permission;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>PermissionBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年12月2日 上午12:55:32
 * @author libin
 */
@Controller
@RequestMapping("/permissionBaseSer")
public class PermissionBaseServiceController extends BaseController {

  @Autowired
  private IPermissionBaseServiceItf permissionBaseService;

  @RequestMapping("Permissions")
  public String getUserInfo(Model model, HttpServletRequest request) {
    Permission Permission = new Permission();
    String name = request.getParameter("search_PermissionName");
    String code = request.getParameter("search_PermissionCode");
    Map<String, Object> param = new HashMap<String, Object>();
    if (!StringUtils.isEmpty(name)) {
      param.put("PermissionName", name);
    }
    if (!StringUtils.isEmpty(code)) {
      param.put("PermissionCode", code);
    }

    Pager<Permission> opPager = permissionBaseService.pageQueryByCondition(param);

    model.addAttribute("datas", opPager);
    return "Permission/list";
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
  @RequestMapping(value = "/addPermission", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addPermission(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    Permission newPc = new Permission();
    newPc.setPermissionName(jsonObj.getString("permissionName"));
    newPc.setPermissionCode(jsonObj.getString("permissionCode"));
    newPc.setPermissionMemo(jsonObj.getString("permissionMemo"));
    super.setTimeStampWithInsert(newPc, request);
    newPc = permissionBaseService.insert(newPc);
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
  @RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updatePermission(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    Permission oldPc = permissionBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldPc == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldPc.setPermissionName(jsonObj.getString("permissionName"));
    oldPc.setPermissionCode(jsonObj.getString("permissionCode"));
    oldPc.setPermissionMemo(jsonObj.getString("permissionMemo"));
    super.setTimeStampWithUpdate(oldPc, request);
    int updateRet = permissionBaseService.update(oldPc);
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
  @RequestMapping(value = "/deletePermissionById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deletePermissionById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = permissionBaseService.deleteDocById(id);
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
  @RequestMapping(value = "/pageQryPermissions", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryPermissions(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Map<String, Object> param = new HashMap<String, Object>();
    Pager<Permission> opPager = permissionBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<Permission> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryPermissionById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryPermissionById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    Permission pc = permissionBaseService.queryDocById(id);
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
