package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.Role;

public interface IRoleBaseServiceItf {

	public Role insertRole(Role role);
	
	public Role updateRole(Role role);

	public Pager<Role> pageQueryRolesByCondition(Map<String, Object> param);

	public int deleteRole(int id);
		
}
