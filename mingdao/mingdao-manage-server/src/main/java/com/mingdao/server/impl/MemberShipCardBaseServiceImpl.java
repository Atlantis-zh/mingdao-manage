package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemberShipCardBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IMemberShipCardDao;
import com.mingdao.domain.MemberShipCard;

/**
 *
 * <code>MemberShipCardBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午11:17:54
 * @author libinf
 */

@Service
public class MemberShipCardBaseServiceImpl implements IMemberShipCardBaseService {

	@Autowired
	private IMemberShipCardDao dao;

	@Override
	public MemberShipCard insertMemShipCard(MemberShipCard msc) {
		dao.insertVO(msc);
		return msc;
	}

	@Override
	public MemberShipCard updateMemShipCard(MemberShipCard msc, Long modifyUserId) {
		msc.setModifier(modifyUserId);
		msc.setModifiedTime(DateUtil.getCurrentTimestamp());
		dao.updateVO(msc);
		return null;
	}

	@Override
	public Pager<MemberShipCard> pageQueryMemShipCardByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<MemberShipCard> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<MemberShipCard> pages = new Pager<MemberShipCard>(count, list);
		return pages;
	}

}
