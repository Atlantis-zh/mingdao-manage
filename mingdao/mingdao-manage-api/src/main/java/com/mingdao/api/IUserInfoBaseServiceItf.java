package com.mingdao.api;

import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.UserInfo;
import com.mingdao.common.pageUtil.Pager;

public interface IUserInfoBaseServiceItf {
	
	
	public ResultMessage insertUserInfo(UserInfo userInfo);

	public Pager<UserInfo> getUserInfo(UserInfo userInfo);



}
