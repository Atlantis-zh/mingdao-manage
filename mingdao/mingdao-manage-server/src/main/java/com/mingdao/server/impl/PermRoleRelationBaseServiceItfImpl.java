package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IPermRoleRelationBaseServiceItf;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IPermRoleRelationDao;
import com.mingdao.domain.PermRoleRelation;

/**
 *
 * <code>PermRoleRelationBaseServiceItfImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月24日 下午5:44:26
 * @author libinf
 */

public class PermRoleRelationBaseServiceItfImpl implements IPermRoleRelationBaseServiceItf {

	@Autowired
	private IPermRoleRelationDao dao;

	@Override
	public PermRoleRelation insertPermRoleRela(PermRoleRelation relation) {
		dao.insertVO(relation);
		return relation;
	}

	@Override
	public PermRoleRelation updatePermRoleRela(PermRoleRelation relation, Long modifyUserId) {
		relation.setModifier(modifyUserId);
		relation.setModifiedTime(DateUtil.getCurrentDateTime().toString());
		dao.updateVO(relation);
		return relation;
	}

	@Override
	public Pager<PermRoleRelation> pageQueryPermRoleRelaByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<PermRoleRelation> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<PermRoleRelation> pages = new Pager<PermRoleRelation>(count, list);
		return pages;
	}

}
