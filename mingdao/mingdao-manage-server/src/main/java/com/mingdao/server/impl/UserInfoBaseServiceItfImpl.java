package com.mingdao.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.dao.base.IUserInfoDao;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.UserInfo;

@Service
public class UserInfoBaseServiceItfImpl implements IUserInfoBaseServiceItf{
	
	
	@Autowired
	private IUserInfoDao userInfoDao;

	@Override
	public ResultMessage insertUserInfo(UserInfo userInfo) {
		int result=userInfoDao.insertVO(userInfo);
		ResultMessage resultMsg=new ResultMessage();
		resultMsg.setResult(Integer.valueOf(result));
		return resultMsg;
	}

}
