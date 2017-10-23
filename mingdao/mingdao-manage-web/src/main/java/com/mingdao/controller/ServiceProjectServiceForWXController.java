package com.mingdao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.mingdao.api.IServiceProjectBaseService;
import com.mingdao.common.pageUtil.JacksonUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.ServiceProject;

/**
 *
 * <code>ServiceProjecServiceForWXController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月23日 上午12:50:42
 * @author libinf
 */
@Controller
@RequestMapping("/weixin/serviceProjecBaseSer")
public class ServiceProjectServiceForWXController {

	@Autowired
	private IServiceProjectBaseService spService;

	@RequestMapping(value = "/qryAllServiceProject", method = RequestMethod.GET)
	public @ResponseBody String qryAllServiceProject(HttpServletRequest request) {
		Long storeId = Long.valueOf(request.getParameter("storeId"));
		ResultMessage result = new ResultMessage();
		if (storeId == null) {
			result.setSuccess(false);
			result.setResultMsg("获取服务项目失败，门店不能为空！");
			return result.toString();
		}
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("storeId", storeId);
			Pager<ServiceProject> pages = spService.pageQueryByCondition(param);
			List<ServiceProject> list = pages.getDatas();
			JSONArray array = new JSONArray();
			if (!CollectionUtils.isEmpty(list)) {
				array = JSONArray.parseArray(JacksonUtil.toJSon(list));
			}
			result.setSuccess(true);
			result.setResult(array);
			return result.toString();
		} catch (Exception e) {
			result.setSuccess(false);
			result.setResultMsg("获取服务项目失败，原因：" + e.getMessage());
			return result.toString();
		}
	}

}
