package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IServiceProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IServiceProjectDao;
import com.mingdao.domain.ServiceProject;

/**
 *
 * <code>ServiceProjectBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月23日 上午12:23:56
 * @author libinf
 */

@Service
public class ServiceProjectBaseServiceImpl implements IServiceProjectBaseService {

	@Autowired
	private IServiceProjectDao dao;

	@Override
	public ServiceProject insert(ServiceProject t) {
		dao.insertVO(t);
		return t;
	}

	@Override
	public ServiceProject update(ServiceProject t) {
		dao.updateVO(t);
		return t;
	}

	@Override
	public Pager<ServiceProject> pageQueryByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<ServiceProject> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<ServiceProject> pages = new Pager<ServiceProject>(count, list);
		return pages;
	}

	@Override
	public ServiceProject singleQryByCondtion(Map<String, Object> param) {
		return null;
	}

	@Override
	public List<ServiceProject> qryAllDoces(Map<String, Object> param) {
		return null;
	}



	@Override
	public void deleteDocById(Long id) {
		dao.deleteDocById(id);
	}
}
