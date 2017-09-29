package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IWeChetBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IWeChetInfoDao;
import com.mingdao.domain.WeChatInfo;

/**
 *
 * <code>IWeChetInfoDao<code> <strong></strong>
 * <p>
 * 
 * <li>微信关注列表</li>
 * </p>
 * 
 * @since
 * @version
 * @author wushzh
 */
@Service
public class WeChetInfoBaseServiceImpl implements IWeChetBaseService{

	@Autowired
	private IWeChetInfoDao dao;
	
	@Override
	public WeChatInfo insertWeChatInfo(WeChatInfo weChatInfo) {
		dao.insertVO(weChatInfo);
		return weChatInfo;
	}

	@Override
	public WeChatInfo updateWeChatInfo(WeChatInfo weChatInfo, Long modifyUserId) {
		weChatInfo.setModifier(modifyUserId);
		weChatInfo.setModifiedTime(DateUtil.getCurrentDateTime().toString());
		dao.updateVO(weChatInfo);
		return weChatInfo;
	}

	@Override
	public Pager<WeChatInfo> pageQueryWeChatInfoByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<WeChatInfo> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<WeChatInfo> pages = new Pager<WeChatInfo>(count, list);
		return pages;
	}

}
