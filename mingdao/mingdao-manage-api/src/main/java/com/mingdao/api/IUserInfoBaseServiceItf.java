package com.mingdao.api;

import com.mingdao.domain.UserInfo;
import com.mingdao.common.pageUtil.Pager;

public interface IUserInfoBaseServiceItf {
	
	
	public UserInfo insertUserInfo(UserInfo userInfo);

	public UserInfo updateUserInfo(UserInfo userInfo);

	public Pager<UserInfo> getUserInfo(UserInfo userInfo);

	public int deleteUser(int id);



}
