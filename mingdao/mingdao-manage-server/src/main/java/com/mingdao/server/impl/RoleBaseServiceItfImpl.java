package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IRoleDao;
import com.mingdao.domain.Role;

public class RoleBaseServiceItfImpl implements IRoleBaseServiceItf{
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	public Role insertRole(Role role) {
		roleDao.insertVO(role);
		return role;
	}

	@Override
	public Role updateRole(Role role,Long modifyUserId) {
		role.setModifier(modifyUserId);
		role.setModifiedTime(DateUtil.getCurrentDateTime().toString());
		roleDao.updateVO(role);
		return role;
	}

	@Override
	public Pager<Role> pageQueryRolesByCondition(Map<String, Object> param) {
		int count =  roleDao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<Role> list=roleDao.pageQueryByCondition(param, pageBounds);
		Pager<Role> pages = new Pager<Role>(count,list);
		return pages;
	}

}
