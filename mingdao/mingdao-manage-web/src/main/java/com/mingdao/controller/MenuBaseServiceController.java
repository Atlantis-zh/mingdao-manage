package com.mingdao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingdao.api.IMenuBaseService;
import com.mingdao.domain.Menu;
import com.mingdao.domain.ResultMessage;
import com.mingdao.enumprop.Status;

/**
 *
 * <code>MenuController<code> <strong></strong>
 * <p>
 * 说明：菜单注册controller
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月31日 上午11:30:33
 * @author libinf
 */

@Controller
@RequestMapping("/pc/menuBaseSer")
public class MenuBaseServiceController extends BaseController {

	@Autowired
	private IMenuBaseService baseService;

	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public @ResponseBody ResultMessage addMenu(HttpServletRequest request, @RequestBody String inputData) {
		ResultMessage result = new ResultMessage();
		JSONObject jsonObj = JSONObject.parseObject(inputData);
		String code = jsonObj.getString(Menu.CODE);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Menu.CODE, code);
		if (baseService.isDocExist(param)) {
			result.setSuccess(false);
			result.setResultMsg("编码为[" + code + "]已经注册!");
			return result;
		}
		Menu menu = new Menu();
		menu.setCode(code);
		menu.setName(jsonObj.getString(Menu.NAME));
		menu.setParentId(jsonObj.getLong(Menu.PARENTID));
		menu.setStatus(Status.valueOf(jsonObj.getString(Menu.STATUS)));
		menu.setIsLeafMenu(jsonObj.getBoolean(Menu.ISLEAFMENU));
		super.setTimeStampWithInsert(menu, request);
		baseService.insert(menu);
		if (menu.getId() != null) {
			result.setSuccess(true);
			result.setResult(menu.getId());
		} else {
			result.setSuccess(false);
			result.setResultMsg("注册失败，请检查日志！");
		}
		return result;
	}

	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public @ResponseBody ResultMessage updateMenu(HttpServletRequest request, @RequestBody String inputData) {
		ResultMessage result = new ResultMessage();
		JSONObject jsonObj = JSONObject.parseObject(inputData);
		Long id = jsonObj.getLong(Menu.ID);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Menu.ID, id);
		Menu menu = baseService.singleQryByCondtion(param);
		if (menu == null) {
			result.setSuccess(false);
			result.setResultMsg("节点未注册!");
			return result;
		}
		menu.setCode(jsonObj.getString(Menu.CODE));
		menu.setName(jsonObj.getString(Menu.NAME));
		menu.setIsLeafMenu(jsonObj.getBoolean(Menu.ISLEAFMENU));
		menu.setParentId(jsonObj.getLong(Menu.PARENTID));
		menu.setStatus(Status.valueOf(jsonObj.getString(Menu.STATUS)));
		super.setTimeStampWithUpdate(menu, request);
		menu = baseService.update(menu, null);
		if (menu == null) {
			result.setSuccess(false);
			result.setResultMsg("修改失败！");
			return result;
		}
		result.setSuccess(true);
		result.setResult("修改成功！");
		return result;
	}

	@RequestMapping(value = "/deleteMenu", method = RequestMethod.GET)
	public @ResponseBody ResultMessage deleteMenu(HttpServletRequest request) {
		ResultMessage result = new ResultMessage();
		Long id = Long.valueOf(request.getParameter(Menu.ID));
		if (id == null) {
			result.setSuccess(false);
			result.setResultMsg("删除主键不可为空!");
			return result;
		}
		baseService.deleteDocById(id);
		result.setSuccess(true);
		result.setResult("删除成功！");
		return result;
	}

}
