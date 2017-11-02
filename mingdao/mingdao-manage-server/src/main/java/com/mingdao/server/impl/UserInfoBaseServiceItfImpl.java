package com.mingdao.server.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.mingdao.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.dao.base.IUserInfoDao;
import com.mingdao.domain.ResultMessage;
import com.mingdao.domain.UserInfo;
import org.springframework.util.StringUtils;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoBaseServiceItfImpl implements IUserInfoBaseServiceItf{
	public static Logger logger = LoggerFactory.getLogger(UserInfoBaseServiceItfImpl.class);
	
	
	@Autowired
	private IUserInfoDao userInfoDao;

	@Override
	public UserInfo insertUserInfo(UserInfo userInfo) {
		userInfoDao.insertVO(userInfo);
		return userInfo;
	}

	@Override
	public UserInfo updateUserInfo(UserInfo userInfo) {
		userInfoDao.updateVO(userInfo);
		return userInfo;
	}


	@Override
	public Pager<UserInfo> getUserInfo(UserInfo userInfo) {
		Map<String,Object> param = new HashMap<>();
		if(!StringUtils.isEmpty(userInfo)){
			param.put("usercode",userInfo.getUserCode());
			param.put("username",userInfo.getUserName());
			param.put("id",userInfo.getId());
		}
		int count =  userInfoDao.getCountUser(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<UserInfo> list = userInfoDao.getUserInfo(param,pageBounds);
		Pager<UserInfo> pages = new Pager<UserInfo>(count,list);
		return pages;
	}

	@Override
	public int deleteUser(int id) {
		return userInfoDao.deleteUser(id);
	}
}
