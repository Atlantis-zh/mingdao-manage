package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IWeChetOrderBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IWeChatOrderDao;
import com.mingdao.domain.WeChatOrder;

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
 * @author wushzh
 */
@Service
public class WeChetOrderInfoBaseServiceImpl implements IWeChetOrderBaseService{

	@Autowired
	private IWeChatOrderDao dao;
	
	@Override
	public WeChatOrder insertWeChatInfo(WeChatOrder order) {
		dao.insertVO(order);
		return order;
	}

	@Override
	public WeChatOrder updateWeChatInfo(WeChatOrder order, Long modifyUserId) {
		order.setModifier(modifyUserId);
		order.setModifiedTime(DateUtil.getCurrentTimestamp());
		dao.updateVO(order);
		return order;
	}

	@Override
	public Pager<WeChatOrder> pageQueryWeChatInfoByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<WeChatOrder> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<WeChatOrder> pages = new Pager<WeChatOrder>(count, list);
		return pages;
	}

}
