package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Permission;

public interface IPermissionBaseServiceItf {

	public Permission insertPermission(Permission permission);
	
	public Permission updatePermission(Permission permission,Long modifyUserId);

	public Pager<Permission> pageQueryPermissionByCondition(Map<String, Object> param);

		
}
