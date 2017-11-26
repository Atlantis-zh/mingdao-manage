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
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.Role;

/**
 *
 * <code>RoleBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午4:04:45
 * @author libin
 */
@Controller
@RequestMapping("/roleBaseSer")
public class RoleBaseServiceController extends BaseController {

  @Autowired
  private IRoleBaseServiceItf roleBaseService;

  @RequestMapping("roles")
  public String getUserInfo(Model model,HttpServletRequest request){
      Role role = new Role();
      String name =  request.getParameter("search_RoleName");
      String code =  request.getParameter("search_RoleCode");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
        param.put("roleName", name);
      }
      if(!StringUtils.isEmpty(code)){
          param.put("roleCode", code);
      }

      Pager<Role> opPager = roleBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "role/list";
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
  @RequestMapping(value = "/addRole", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addRole(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    Role newPc = new Role();
    newPc.setRoleName(jsonObj.getString("roleName"));
    newPc.setRoleCode(jsonObj.getString("roleCode"));
    newPc.setRoleMemo(jsonObj.getString("roleMemo"));
    super.setTimeStampWithInsert(newPc, request);
    newPc = roleBaseService.insert(newPc);
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
  @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateRole(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    Role oldPc = roleBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldPc == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldPc.setRoleName(jsonObj.getString("roleName"));
    oldPc.setRoleCode(jsonObj.getString("roleCode"));
    oldPc.setRoleMemo(jsonObj.getString("roleMemo"));
    super.setTimeStampWithUpdate(oldPc, request);
    int updateRet = roleBaseService.update(oldPc);
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
  @RequestMapping(value = "/deleteRoleById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteRoleById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = roleBaseService.deleteDocById(id);
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
  @RequestMapping(value = "/pageQryRoles", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryRoles(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Map<String, Object> param = new HashMap<String, Object>();
    Pager<Role> opPager = roleBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<Role> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryRoleById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryRoleById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    Role pc = roleBaseService.queryDocById(id);
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
