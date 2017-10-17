package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IPermissionBaseServiceItf;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IPermissionDao;
import com.mingdao.domain.Permission;

/**
 *
 * <code>PermissionBaseServiceItfImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月24日 下午4:50:21
 * @author libinf
 */

public class PermissionBaseServiceItfImpl implements IPermissionBaseServiceItf {

	@Autowired
	private IPermissionDao permissionDao;

	@Override
	public Permission insertPermission(Permission permission) {
		permissionDao.insertVO(permission);
		return permission;
	}

	@Override
	public Permission updatePermission(Permission permission, Long modifyUserId) {
		//permission.setModifier(modifyUserId);
		permission.setModifiedTime(DateUtil.getCurrentTimestamp());
		permissionDao.updateVO(permission);
		return permission;
	}


	@Override
	public Pager<Permission> pageQueryPermissionByCondition(Map<String, Object> param) {
		int count = permissionDao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<Permission> list = permissionDao.pageQueryByCondition(param, pageBounds);
		Pager<Permission> pages = new Pager<Permission>(count, list);
		return pages;
	}

}
