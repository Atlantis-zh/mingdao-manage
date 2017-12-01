package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IMemShipPackageProjectDetailBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.MemShipPackageProjectDetail;
import com.mingdao.domain.ResultMessage;

/**
 *
 * <code>MemShipPackageProjectDetailBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：会员套餐明细子表controller
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月26日 下午12:19:12
 * @author libin
 */
@Controller
@RequestMapping("/memPkPDBaseSer")
public class MemShipPackageProjectDetailBaseServiceController extends BaseController {

  @Autowired
  private IMemShipPackageProjectDetailBaseService spBaseService;

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
  @RequestMapping(value = "/addMemShipPackageProjectDetail", method = RequestMethod.POST)
  public @ResponseBody ResultMessage addMemShipPackageProjectDetail(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemShipPackageProjectDetail newsp = new MemShipPackageProjectDetail();
    newsp.setPackageProjectId(jsonObj.getLong("packageProjectId"));
    newsp.setPackageTypeId(jsonObj.getLong("packageTypeId"));
    newsp.setMemberShipId(jsonObj.getLong("memberShipId"));
    newsp.setRemainSerCount(jsonObj.getInteger("remainSerCount"));
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
  @RequestMapping(value = "/updateMemShipPackageProjectDetail", method = RequestMethod.POST)
  public @ResponseBody ResultMessage updateMemShipPackageProjectDetail(HttpServletRequest request,
      @RequestBody String inputData) {
    ResultMessage result = new ResultMessage();
    JSONObject jsonObj = JSONObject.parseObject(inputData);
    MemShipPackageProjectDetail oldSp = spBaseService.queryDocById(jsonObj.getLong("id"));
    if (oldSp == null) {
      result.setSuccess(false);
      result.setResultMsg("更新数据不存在！");
      return result;
    }
    oldSp.setPackageProjectId(jsonObj.getLong("packageProjectId"));
    oldSp.setPackageTypeId(jsonObj.getLong("packageTypeId"));
    oldSp.setMemberShipId(jsonObj.getLong("memberShipId"));
    oldSp.setRemainSerCount(jsonObj.getInteger("remainSerCount"));
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
  @RequestMapping(value = "/deleteMemShipPackageProjectDetailById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage deleteMemShipPackageProjectDetailById(
      HttpServletRequest request) {
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
  @RequestMapping(value = "/pageQryMemShipPackageProjectDetails", method = RequestMethod.GET)
  public @ResponseBody ResultMessage pageQryMemShipPackageProjectDetails(
      HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long memberShipId = Long.valueOf(request.getParameter("memberShipId"));
    if (memberShipId == null) {
      result.setSuccess(false);
      result.setResultMsg("套餐明细不能为空！");
    }
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("memberShipId", memberShipId);
    Pager<MemShipPackageProjectDetail> opPager = spBaseService.pageQueryByCondition(param);
    if (opPager == null) {
      result.setSuccess(false);
      result.setResultMsg("查询失败，请稍后重试！");
      return result;
    }
    JSONObject obj = new JSONObject();
    obj.put(PageResultConst.PAGE, opPager.getOffset());
    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
    List<MemShipPackageProjectDetail> list = opPager.getDatas();
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
  @RequestMapping(value = "/qryMemShipPackageProjectDetailById", method = RequestMethod.GET)
  public @ResponseBody ResultMessage qryMemShipPackageProjectDetailById(
      HttpServletRequest request) {
    ResultMessage result = new ResultMessage();
    Long id = Long.valueOf(request.getParameter("id"));
    MemShipPackageProjectDetail spc = spBaseService.queryDocById(id);
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
