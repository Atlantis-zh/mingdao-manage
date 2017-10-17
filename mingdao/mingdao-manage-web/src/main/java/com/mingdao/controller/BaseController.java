package com.mingdao.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mingdao.common.utils.DateUtil;
import com.mingdao.domain.SuperVO;

/**
 * Created by ambitious on 2017/9/28.
 */
public class BaseController {

	private static final String USERID = "userId";


	public void setTimeStampWithInsert(SuperVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long userId = (long) session.getAttribute(USERID);
		Timestamp date = DateUtil.getCurrentTimestamp();
		vo.setCreator(userId);
		vo.setCreateTime(date);
	}

	public void setTimeStampWithUpdate(SuperVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long userId = (long) session.getAttribute(USERID);
		Timestamp date = DateUtil.getCurrentTimestamp();
		vo.setModifier(userId);
		vo.setModifiedTime(date);
	}

}
