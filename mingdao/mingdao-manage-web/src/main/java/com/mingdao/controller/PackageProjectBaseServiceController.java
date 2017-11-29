package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IPackageProjectBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.PackageProject;
import com.mingdao.domain.PackageType;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>PackageProjectBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 下午9:42:16
 * @author libin
 */

@Controller
@RequestMapping("/packageProjectBaseSer")
public class PackageProjectBaseServiceController extends BaseController {
  @Autowired
  private IPackageProjectBaseService apBaseService;

  @RequestMapping("packageproject")
  public String getProductClass(Model model,HttpServletRequest request){

      String name =  request.getParameter("search_name");
      String code =  request.getParameter("search_code");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
    	  param.put("name", name);
      }
      if(!StringUtils.isEmpty(code)){
    	  param.put("code", code);
      }

      Pager<PackageProject> opPager = apBaseService.pageQueryByCondition(param);
//      List<MemberShipDTO> dtos = this.getDto(opPager.getDatas());
//      Pager<ProductClassDTO> dtoPager = new Pager<ProductClassDTO>(dtos.size(),dtos);

      model.addAttribute("datas", opPager);
      return "packageproject/list";
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
  @RequestMapping(value = "/addPackageProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addPackageProject(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    PackageProject newap = new PackageProject();
//    newap.setPkgTypeId(jsonObj.getLong("pkgTypeId"));
    newap.setServiceProjectId(jsonObj.getLong("serviceProjectId"));
    newap.setServiceCount(jsonObj.getInteger("serviceCount"));
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
  @RequestMapping(value = "/updatePackageProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updatePackageProject(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    PackageProject oldap = apBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldap == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
//    oldap.setPkgTypeId(jsonObj.getLong("pkgTypeId"));
    oldap.setServiceProjectId(jsonObj.getLong("serviceProjectId"));
    oldap.setServiceCount(jsonObj.getInteger("serviceCount"));
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
  @RequestMapping(value = "/deletePackageProjectById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deletePackageProjectById(HttpServletRequest request) {
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
  @RequestMapping(value = "/qryPackageProjects", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryPackageProjects(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long pkgTypeId = Long.valueOf(request.getParameter("pkgTypeId"));
    if (pkgTypeId == null) {
      result.setSuccess(false);
      result.setResultMsg("请求参数错误，套餐类型不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("pkgTypeId", pkgTypeId);
    List<PackageProject> list = apBaseService.qryAllDoces(param);
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
  @RequestMapping(value = "/pageQryPackageProjects", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryPackageProjects(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long pkgTypeId = Long.valueOf(request.getParameter("pkgTypeId"));
    if (pkgTypeId == null) {
      result.setSuccess(false);
      result.setResultMsg("请求参数错误，套餐类型不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("pkgTypeId", pkgTypeId);
    Pager<PackageProject> opPager = apBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<PackageProject> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryPackageProjectById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryPackageProjectById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    PackageProject spc = apBaseService.queryDocById(id);
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
