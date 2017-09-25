package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IUserRoleRelationBaseServiceItf;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IUserRoleRelationDao;
import com.mingdao.domain.UserRoleRelation;

/**
 *
 * <code>UserRoleRelationBaseServiceItfImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月24日 下午5:17:23
 * @author libinf
 */

public class UserRoleRelationBaseServiceItfImpl implements IUserRoleRelationBaseServiceItf {

	@Autowired
	private IUserRoleRelationDao dao;

	@Override
	public UserRoleRelation insertUserRoleRelation(UserRoleRelation relation) {
		dao.insertVO(relation);
		return relation;
	}

	@Override
	public UserRoleRelation updateUserRoleRelation(UserRoleRelation relation, Long modifyUserId) {
		relation.setModifier(modifyUserId);
		relation.setModifiedTime(DateUtil.getCurrentDateTime().toString());
		dao.updateVO(relation);
		return relation;
	}

	@Override
	public Pager<UserRoleRelation> pageQueryUserRoleRelaByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<UserRoleRelation> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<UserRoleRelation> pages = new Pager<UserRoleRelation>(count, list);
		return pages;
	}

}
