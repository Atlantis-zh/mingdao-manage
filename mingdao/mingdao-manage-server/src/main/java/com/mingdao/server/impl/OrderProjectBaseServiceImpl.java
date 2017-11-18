package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IOrderProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IOrderProjectDao;
import com.mingdao.domain.OrderProject;

/**
 *
 * <code>WeChetOrderInfoBaseServiceImpl<code> <strong></strong>
 * <p>
 * 
 * <li>预约管理</li>
 * </p>
 * 
 * @since
 * @version
 * @author libinf
 */
@Service("orderProjectBaseService")
public class OrderProjectBaseServiceImpl implements IOrderProjectBaseService{

	@Autowired
	private IOrderProjectDao dao;


	@Override
	public OrderProject insert(OrderProject t) {
		dao.insertVO(t);
		return t;
	}

	@Override
	public OrderProject update(OrderProject t) {
		dao.updateVO(t);
		return t;
	}

	@Override
	public Pager<OrderProject> pageQueryByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<OrderProject> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<OrderProject> pages = new Pager<OrderProject>(count, list);
		return pages;
	}

	@Override
	public OrderProject singleQryByCondtion(Map<String, Object> param) {
		return null;
	}

	@Override
	public List<OrderProject> qryAllDoces(Map<String, Object> param) {
		return null;
	}

	@Override
	public void deleteDocById(Long id) {
		dao.deleteDocById(id);
	}

}
