package com.mingdao.controller;

import java.util.ArrayList;
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
import com.mingdao.api.IServiceProjectBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.ServiceProductClass;
import com.mingdao.domain.ServiceProductClassDTO;
import com.mingdao.domain.ServiceProject;
import com.mingdao.domain.ServiceProjectDTO;

/**
 *
 * <code>ServiceProjectBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午3:06:38
 * @author libin
 */
@Controller
@RequestMapping("/serProductBaseSer")
public class ServiceProjectBaseServiceController extends BaseController {
  @Autowired
  private IServiceProjectBaseService spBaseService;


  @RequestMapping("serviceProjects")
  public String getServiceProject(Model model, HttpServletRequest request) {

      String name = request.getParameter("search_Name");
      String code = request.getParameter("search_Code");
      Map<String, Object> param = new HashMap<String, Object>();

      if (!StringUtils.isEmpty(name)) {
    	  param.put("name", name);
      }
      if (!StringUtils.isEmpty(code)) {
    	  param.put("code", code);
      }
      Pager<ServiceProject> opPager = spBaseService.pageQueryByCondition(param);
      List<ServiceProjectDTO> dtos = this.getDto(opPager.getDatas());
      Pager<ServiceProjectDTO> dtoPager = new Pager<ServiceProjectDTO>(dtos.size(),dtos);

      model.addAttribute("datas", dtoPager);
      return "serviceProject/list";
  }
  
  @RequestMapping("refserviceProjects")
  public String getRefServiceProject(Model model, HttpServletRequest request) {

      String name = request.getParameter("search_Name");
      String code = request.getParameter("search_Code");
      Map<String, Object> param = new HashMap<String, Object>();

      if (!StringUtils.isEmpty(name)) {
    	  param.put("name", name);
      }
      if (!StringUtils.isEmpty(code)) {
    	  param.put("code", code);
      }
      Pager<ServiceProject> opPager = spBaseService.pageQueryByCondition(param);

      model.addAttribute("datas", opPager);
      return "serviceProject/refServiceproject";
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
  @RequestMapping(value = "/addServiceProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addServiceProduct(HttpServletRequest request,
      @RequestBody ServiceProject newsp) {
    ResultMessage result = new ResultMessage();
    
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
  @RequestMapping(value = "/updateServiceProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateServiceProject(HttpServletRequest request,
      @RequestBody ServiceProject newvo) {
    ResultMessage result = new ResultMessage();
    ServiceProject oldSp = spBaseService.queryDocById(newvo.getId());
    if (oldSp == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldSp.setStoreId(newvo.getStoreId());
    oldSp.setCode(newvo.getCode());
    oldSp.setName(newvo.getName());
    oldSp.setSpec(newvo.getSpec());
    oldSp.setSalePrice(newvo.getSalePrice());
    oldSp.setCost(newvo.getCost());
    oldSp.setWorkHours(newvo.getWorkHours());
    oldSp.setIsSelfHelp(newvo.getIsSelfHelp());
    oldSp.setUnit(newvo.getUnit());
    oldSp.setSerProdClassId(newvo.getSerProdClassId());
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
  @RequestMapping(value = "/deleteServiceProjectById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteServiceProjectById(HttpServletRequest request) {
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
	@RequestMapping(value = "/pageQryServiceProjects", method = RequestMethod.GET)
	public @ResponseBody ResultMessage pageQryServiceProjects(HttpServletRequest request) {
		ResultMessage result = new ResultMessage();
		Map<String, Object> param = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(request.getParameter("storeId"))) {
			Long storeId = Long.valueOf(request.getParameter("storeId"));
			if (storeId == null) {
				result.setSuccess(false);
				result.setResultMsg("所属门店不能为空！");
				return result;
			}
			param.put("storeId", storeId);
		}
		if (StringUtils.isNotBlank(request.getParameter("serProdClassId"))) {
			Long serProdClassId = Long.valueOf(request.getParameter("serProdClassId"));
			if (serProdClassId != null) {
				param.put("serProdClassId", serProdClassId);
			}
		}
		Pager<ServiceProject> opPager = spBaseService.pageQueryByCondition(param);
		if (opPager == null) {
			result.setSuccess(false);
			result.setResultMsg("查询失败，请稍后重试！");
			return result;
		}
		JSONObject obj = new JSONObject();
		obj.put(PageResultConst.PAGE, opPager.getOffset());
		obj.put(PageResultConst.PAGESIZE, opPager.getSize());
		obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
		List<ServiceProject> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryServiceProjectById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryServiceProjectById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    ServiceProject spc = spBaseService.queryDocById(id);
    if (spc == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(spc.getDto()));
    }
    return result;
  }
  
  private List<ServiceProjectDTO> getDto(List<ServiceProject> list){
	  List<ServiceProjectDTO> dtos = new ArrayList<ServiceProjectDTO>();
	  for(ServiceProject vo: list){
		  dtos.add(vo.getDto());
	  }
	  return dtos;
	  
  }



}
