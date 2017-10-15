package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IExchangeGiftBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IExchangeGiftDao;
import com.mingdao.domain.ExchangeGift;

/**
 *
 * <code>ExchangeGiftBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 上午10:33:15
 * @author libinf
 */

@Service
public class ExchangeGiftBaseServiceImpl implements IExchangeGiftBaseService {

	@Autowired
	private IExchangeGiftDao dao;

	@Override
	public ExchangeGift insert(ExchangeGift t) {
		dao.insertVO(t);
		return t;
	}

	@Override
	public ExchangeGift update(ExchangeGift t, Long modifier) {
		t.setModifier(modifier);
		t.setModifiedTime(DateUtil.getCurrentDateTime().toString());
		dao.updateVO(t);
		return t;
	}

	@Override
	public Pager<ExchangeGift> pageQueryByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<ExchangeGift> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<ExchangeGift> pages = new Pager<ExchangeGift>(count, list);
		return pages;
	}

}
