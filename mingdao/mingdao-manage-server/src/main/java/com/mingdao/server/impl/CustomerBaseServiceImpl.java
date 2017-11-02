package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustomerBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.ICustomerDao;
import com.mingdao.domain.Customer;

/**
 *
 * <code>CustomerBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月15日 下午3:25:24
 * @author libinf
 */

@Service
public class CustomerBaseServiceImpl implements ICustomerBaseService {

	@Autowired
	private ICustomerDao dao;

	@Override
	public Customer insert(Customer t) {
		dao.insertVO(t);
		return t;
	}

	@Override
	public Customer update(Customer t) {

		dao.updateVO(t);
		return t;
	}

	@Override
	public Pager<Customer> pageQueryByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<Customer> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<Customer> pages = new Pager<Customer>(count, list);
		return pages;
	}

	@Override
	public Customer singleQryByCondtion(Map<String, Object> param) {
		Customer resutl = dao.singleQueryByCondition(param);
		return resutl;
	}

	@Override
	public List<Customer> qryAllDoces(Map<String, Object> param) {
		return null;
	}

}
