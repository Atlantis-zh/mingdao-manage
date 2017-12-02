package com.mingdao.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IPackageTypeBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.PackageType;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>PackageTypeBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 下午8:48:56
 * @author libin
 */

@Controller
@RequestMapping("/packageTypeBaseSer")
public class PackageTypeBaseServiceController extends BaseController {

  @Autowired
  private IPackageTypeBaseService ptBaseService;



  @RequestMapping("packagetype")
  public String getPackagetype(Model model, HttpServletRequest request) {

    String name = request.getParameter("search_name");
    String code = request.getParameter("search_code");
    Map<String, Object> param = new HashMap<String, Object>();
    if (!StringUtils.isEmpty(name)) {
      param.put("name", name);
    }
    if (!StringUtils.isEmpty(code)) {
      param.put("code", code);
    }

    Pager<PackageType> opPager = ptBaseService.pageQueryByCondition(param);
    // List<MemberShipDTO> dtos = this.getDto(opPager.getDatas());
    // Pager<ProductClassDTO> dtoPager = new Pager<ProductClassDTO>(dtos.size(),dtos);

    model.addAttribute("datas", opPager);
    return "packagetype/list";
  }



  @RequestMapping("refpackagetype")
  public String getRefPackagetype(Model model, HttpServletRequest request) {

    String name = request.getParameter("search_name");
    String code = request.getParameter("search_code");
    Map<String, Object> param = new HashMap<String, Object>();
    if (!StringUtils.isEmpty(name)) {
      param.put("name", name);
    }
    if (!StringUtils.isEmpty(code)) {
      param.put("code", code);
    }

    Pager<PackageType> opPager = ptBaseService.pageQueryByCondition(param);
    // List<MemberShipDTO> dtos = this.getDto(opPager.getDatas());
    // Pager<ProductClassDTO> dtoPager = new Pager<ProductClassDTO>(dtos.size(),dtos);

    model.addAttribute("datas", opPager);
    return "packagetype/reflist";
  }

  /**
   * 
   * <p>
   * 说明：新增预约项目的接口
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @throws IOException
   * @date 2017年11月19日 下午4:30:35
   * @since NC6.5
   */
  @RequestMapping(value = "/addPackageType", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addPackageType(HttpServletRequest request) throws IOException {
    String inputData = getRequestBody(request);
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    PackageType op = new PackageType();
    op.setStoreId(jsonObj.getLong("storeId"));
    op.setCode(jsonObj.getString("code"));
    op.setName(jsonObj.getString("name"));
    op.setSalePrice(jsonObj.getDouble("salePrice"));
    op.setTotalCount(jsonObj.getInteger("totalCount"));
    op.setExpire(jsonObj.getInteger("expire"));
    op.setTimeUnit(jsonObj.getInteger("timeUnit"));
    op.setCost(jsonObj.getDouble("cost"));
    op.setShareToBranch(jsonObj.getBoolean("shareToBranch"));
    op.setSource(jsonObj.getInteger("source"));
    op.setStatus(jsonObj.getInteger("status"));
    op.setMemo(jsonObj.getString("memo"));
    super.setTimeStampWithInsert(op, request);
    op = ptBaseService.insert(op);
    if (op.getId() != null) {
      result.setSuccess(true);
      result.setResult(op.getId());
    } else {
      result.setSuccess(false);
      result.setResultMsg("新增预约项目失败，请检查日志！");
    }
    return result;
  }

  /**
   * 
   * <p>
   * 说明：查询预约项目，目前支持根据门店和所属状态来查以及根据客户id进行查询 其他的查询再说
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月19日 下午4:27:10
   * @since NC6.5
   */
  @RequestMapping(value = "/pageQryPackageTypes", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryPackageTypes(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    if (StringUtils.isEmpty(request.getParameter("storeId"))) {
      result.setSuccess(false);
      result.setResultMsg("请选择所属门店！");
      return result;
    }
    Long storeId = Long.valueOf(request.getParameter("storeId"));
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("storeId", storeId);
    if (!StringUtils.isEmpty(request.getParameter("status"))) {
      param.put("status", Integer.valueOf(request.getParameter("status")));
    }
    if (!StringUtils.isEmpty(request.getParameter("source"))) {
      param.put("source", Integer.valueOf(request.getParameter("source")));
    }
    Pager<PackageType> opPager = ptBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询预约项目失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<PackageType> list = opPager.getDatas();
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
   * 说明：更新档案
   * <li></li>
   * </p>
   * 
   * @param request
   * @param inputData
   * @return
   * @throws IOException
   * @date 2017年11月25日 下午9:01:31
   * @since NC6.5
   */
  @RequestMapping(value = "/updatePackageType", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updatePackageType(HttpServletRequest request)
      throws IOException {
    String inputData = getRequestBody(request);
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    PackageType oldOP = ptBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldOP == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldOP.setStoreId(jsonObj.getLong("storeId"));
    oldOP.setCode(jsonObj.getString("code"));
    oldOP.setName(jsonObj.getString("name"));
    oldOP.setSalePrice(jsonObj.getDouble("salePrice"));
    oldOP.setTotalCount(jsonObj.getInteger("totalCount"));
    oldOP.setExpire(jsonObj.getInteger("expire"));
    oldOP.setTimeUnit(jsonObj.getInteger("timeUnit"));
    oldOP.setCost(jsonObj.getDouble("cost"));
    oldOP.setShareToBranch(jsonObj.getBoolean("shareToBranch"));
    oldOP.setSource(jsonObj.getInteger("source"));
    oldOP.setStatus(jsonObj.getInteger("status"));
    oldOP.setMemo(jsonObj.getString("memo"));
    super.setTimeStampWithUpdate(oldOP, request);
    int updateRet = ptBaseService.update(oldOP);
    if (updateRet == 0) {
      result.setSuccess(false);
      result.setResultMsg("更新失败，请稍后重新尝试！");
    } else {
      result.setSuccess(true);
      result.setResult(DataUtil.superVOToJsonObject(oldOP));
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
  @RequestMapping(value = "/deletePackageTypeById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deletePackageTypeById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    int updateRet = ptBaseService.deleteDocById(id);
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
   * 说明：根据主键查询档案
   * <li></li>
   * </p>
   * 
   * @param request
   * @return
   * @date 2017年11月25日 上午1:42:30
   * @since NC6.5
   */
  @RequestMapping(value = "/qryPackageTypeById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryPackageTypeById(HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    PackageType spc = ptBaseService.queryDocById(id);
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
