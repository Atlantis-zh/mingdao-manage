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
import com.mingdao.api.IAttachProjectBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.AttachProject;
import com.mingdao.domain.AttachProjectDTO;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>AttachProjectBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午3:23:32
 * @author libin
 */
@Controller
@RequestMapping("/attachProject")
public class AttachProjectBaseServiceController extends BaseController {
  @Autowired
  private IAttachProjectBaseService apBaseService;

  @RequestMapping("attachProjects")
  public String getCustTypesInfo(Model model,HttpServletRequest request){

      String name =  request.getParameter("search_Name");
      String code =  request.getParameter("search_Code");
      Map<String, Object> param = new HashMap<String, Object>();
      if(!StringUtils.isEmpty(name)){
          param.put("name",name);
      }
      if(!StringUtils.isEmpty(code)){
          param.put("code",code);
      }

      Pager<AttachProject> opPager = apBaseService.pageQueryByCondition(param);
      
      List<AttachProject> list = opPager.getDatas();
      List<AttachProjectDTO> dtos = new ArrayList<AttachProjectDTO>();
      for(AttachProject vo:list){
    	  dtos.add(vo.getDto());
      }
      Pager<AttachProjectDTO> pages = new Pager<AttachProjectDTO>(list.size(), dtos);

      model.addAttribute("datas", pages);
      return "attachProject/list";
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
  @RequestMapping(value = "/addAttachProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addAttachProject(HttpServletRequest request,
      @RequestBody AttachProject newap) {
    ResultMessage result = new ResultMessage();
//    newap.setStoreId(jsonObj.getLong("storeId"));
//    newap.setCode(jsonObj.getString("code"));
//    newap.setName(jsonObj.getString("name"));
//    newap.setPrice(jsonObj.getDouble("price"));
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
  @RequestMapping(value = "/updateAttachProject", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateAttachProject(HttpServletRequest request,
      @RequestBody AttachProject newap) {
    ResultMessage result = new ResultMessage();
//    JSONObject jsonObj = JSONObject.parseObject(inputData);
    AttachProject oldap = apBaseService.queryDocById(newap.getId());
    if (oldap == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldap.setStoreId(newap.getStoreId());
    oldap.setCode(newap.getCode());
    oldap.setName(newap.getName());
    oldap.setPrice(newap.getPrice());
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
  @RequestMapping(value = "/deleteAttachProjectById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteAttachProjectById(HttpServletRequest request) {
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
   * 说明：分页查询所有
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:14
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryAttachProjects", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryAttachProjects(HttpServletRequest request) {
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
    Pager<AttachProject> opPager = apBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<AttachProject> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryAttachProjectById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryAttachProjectById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    AttachProject spc = apBaseService.queryDocById(id);
    if (spc == null) {
      result.setSuccess(false);
      result.setResultMsg("查询数据不存在！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(spc.getDto()));
    }
    return result;
  }



}
