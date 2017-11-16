package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustTypeBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.ICustTypeDao;
import com.mingdao.domain.CustType;

/**
 *
 * <code>CustTypeBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午11:26:43
 * @author libinf
 */
@Service
public class CustTypeBaseServiceImpl implements ICustTypeBaseService {

	@Autowired
	private ICustTypeDao dao;

	@Override
	public CustType insertCustType(CustType custtype) {
		dao.insertVO(custtype);
		return custtype;
	}

	@Override
	public CustType updateCustType(CustType custtype) {
		//custtype.setModifier(modifyUserId);
		//custtype.setModifiedTime(DateUtil.getCurrentTimestamp());
		dao.updateVO(custtype);
		return custtype;
	}

	@Override
	public Pager<CustType> pageQueryCustTypeByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<CustType> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<CustType> pages = new Pager<CustType>(count, list);
		return pages;
	}

}
