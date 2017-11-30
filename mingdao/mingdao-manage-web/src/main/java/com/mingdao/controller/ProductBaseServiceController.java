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
import com.mingdao.api.IProductBaseService;
import com.mingdao.common.consts.PageResultConst;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DataUtil;
import com.mingdao.domain.Product;
import com.mingdao.domain.ProductDTO;
import com.mingdao.domain.ResultMessage;

@Controller
@RequestMapping("/productBaseSer")
public class ProductBaseServiceController extends BaseController {

	  @Autowired
	  private IProductBaseService pcBaseService;


	  @RequestMapping("product")
	  public String getProduct(Model model,HttpServletRequest request){

	      String name =  request.getParameter("search_name");
	      String code =  request.getParameter("search_code");
	      Map<String, Object> param = new HashMap<String, Object>();
	      if(!StringUtils.isEmpty(name)){
	    	  param.put("name", name);
	      }
	      if(!StringUtils.isEmpty(code)){
	    	  param.put("code", code);
	      }

	      Pager<Product> opPager = pcBaseService.pageQueryByCondition(param);
	      List<ProductDTO> dtos = this.getDto(opPager.getDatas());
	      Pager<ProductDTO> dtoPager = new Pager<ProductDTO>(dtos.size(),dtos);

	      model.addAttribute("datas", dtoPager);
	      return "product/list";
	  }
	  
	  @RequestMapping("refProduct")
	  public String getRefProduct(Model model,HttpServletRequest request){

	      String name =  request.getParameter("search_name");
	      String code =  request.getParameter("search_code");
	      Map<String, Object> param = new HashMap<String, Object>();
	      if(!StringUtils.isEmpty(name)){
	    	  param.put("name", name);
	      }
	      if(!StringUtils.isEmpty(code)){
	    	  param.put("code", code);
	      }

	      Pager<Product> opPager = pcBaseService.pageQueryByCondition(param);
	      List<ProductDTO> dtos = this.getDto(opPager.getDatas());
	      Pager<ProductDTO> dtoPager = new Pager<ProductDTO>(dtos.size(),dtos);

	      model.addAttribute("datas", dtoPager);
	      return "product/refProduct";
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
	  @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	  public @ResponseBody ResultMessage addProduct(HttpServletRequest request,
	      @RequestBody Product newPc) {
	    ResultMessage result = new ResultMessage();
//	    JSONObject jsonObj = JSONObject.parseObject(inputData);
//	    Product newPc = new Product();
//	    newPc.setStoreId(jsonObj.getLong("storeId"));
//	    newPc.setCode(jsonObj.getString("code"));
//	    newPc.setName(jsonObj.getString("name"));
//	    newPc.setParentId(jsonObj.getLong("parentId"));
	    super.setTimeStampWithInsert(newPc, request);
	    newPc = pcBaseService.insert(newPc);
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
	  @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	  public @ResponseBody ResultMessage updateProduct(HttpServletRequest request,
	      @RequestBody Product newvo) {
	    ResultMessage result = new ResultMessage();

	    Product oldPc = pcBaseService.queryDocById(newvo.getId());
	    if (oldPc == null) {
	      result.setSuccess(false);
	      result.setResultMsg("更新数据不存在！");
	      return result;
	    }
	    oldPc.setStoreId(newvo.getStoreId());
	    oldPc.setCode(newvo.getCode());
	    oldPc.setName(newvo.getName());
	    oldPc.setMncode(newvo.getMncode());
	    oldPc.setAdapteCarType(newvo.getAdapteCarType());
	    oldPc.setMeasdocId(newvo.getMeasdocId());
	    oldPc.setMemo(newvo.getMemo());
	    oldPc.setProductClassId(newvo.getProductClassId());
	    oldPc.setSalePrice(newvo.getSalePrice());
	    oldPc.setShareToBranch(newvo.getShareToBranch());
	    oldPc.setSpec(newvo.getSpec());
	    oldPc.setStatus(newvo.getStatus());
	    super.setTimeStampWithUpdate(oldPc, request);
	    int updateRet = pcBaseService.update(oldPc);
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
	  @RequestMapping(value = "/deleteProductById", method = RequestMethod.GET)
	  public @ResponseBody ResultMessage deleteProductById(HttpServletRequest request) {
	    ResultMessage result = new ResultMessage();
	    Long id = Long.valueOf(request.getParameter("id"));
	    int updateRet = pcBaseService.deleteDocById(id);
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
	  @RequestMapping(value = "/qryProductes", method = RequestMethod.GET)
	  public @ResponseBody ResultMessage qryProductes(HttpServletRequest request) {
	    ResultMessage result = new ResultMessage();
	    Long storeId = Long.valueOf(request.getParameter("storeId"));
	    if (storeId == null) {
	      result.setSuccess(false);
	      result.setResultMsg("所属门店不能为空！");
	    }
	    Map<String, Object> param = new HashMap<String, Object>();
	    param.put("storeId", storeId);
	    Long parentId = Long.valueOf(request.getParameter("parentId"));
	    if (parentId != null) {
	      param.put("parentId", parentId);
	    }
	    List<Product> list = pcBaseService.qryAllDoces(param);
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
	  @RequestMapping(value = "/pageQryProductes", method = RequestMethod.GET)
	  public @ResponseBody ResultMessage pageQryProductes(HttpServletRequest request) {
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
		if (StringUtils.isNotBlank(request.getParameter("parentId"))) {
			Long parentId = Long.valueOf(request.getParameter("parentId"));
			if (parentId != null) {
				param.put("parentId", parentId);
			}
		}
	    Pager<Product> opPager = pcBaseService.pageQueryByCondition(param);
	    if (opPager == null) {
	      result.setSuccess(false);
	      result.setResultMsg("查询失败，请稍后重试！");
	      return result;
	    }
	    JSONObject obj = new JSONObject();
	    obj.put(PageResultConst.PAGE, opPager.getOffset());
	    obj.put(PageResultConst.PAGESIZE, opPager.getSize());
	    obj.put(PageResultConst.TOTALCOUNT, opPager.getTotal());
	    List<Product> list = opPager.getDatas();
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
	  @RequestMapping(value = "/qryProductById", method = RequestMethod.GET)
	  public @ResponseBody ResultMessage qryProductById(HttpServletRequest request) {
	    ResultMessage result = new ResultMessage();
	    Long id = Long.valueOf(request.getParameter("id"));
	    Product pc = pcBaseService.queryDocById(id);
	    ProductDTO dto = pc.getDto();
	    
	    if (pc == null) {
	      result.setSuccess(false);
	      result.setResultMsg("查询数据不存在！");
	    } else {
	      result.setSuccess(true);
	      result.setResult(DataUtil.superVOToJsonObject(dto));
	    }
	    return result;
	  }
	  
	  private List<ProductDTO> getDto(List<Product> list){
		  List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		  for(Product vo: list){
			  dtos.add(vo.getDto());
		  }
		  return dtos;
		  
	  }
}
