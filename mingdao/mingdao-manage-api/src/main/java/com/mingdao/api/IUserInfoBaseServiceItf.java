package com.mingdao.api;

import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.UserInfo;
import com.mingdao.util.Pager;

import java.util.List;

public interface IUserInfoBaseServiceItf {
	
	
	public ResultMessage insertUserInfo(UserInfo userInfo);

	public Pager<UserInfo> getUserInfo(UserInfo userInfo);



}
