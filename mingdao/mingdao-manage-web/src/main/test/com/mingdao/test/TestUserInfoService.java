package com.mingdao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.domain.UserInfo;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-config.xml" })
public class TestUserInfoService {
	
	@Autowired
	private IUserInfoBaseServiceItf service;

	@Test
	@Rollback(false)
	public void testInsert()
	{
		UserInfo userInfo=new UserInfo();
		userInfo.setUserCode("0002");
		userInfo.setUserName("libinf");
		userInfo.setPassWord("123456");
		userInfo.setCreateTime(DateUtil.getCurrentTimestamp());
		service.insertUserInfo(userInfo);
	}
}
