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

    public void initTimeStamp(SuperVO vo,HttpServletRequest request){
        HttpSession session =  request.getSession();
        long userName = (long) session.getAttribute("userName");
		Timestamp date = DateUtil.getCurrentTimestamp();
        vo.setCreator(userName);
        vo.setCreateTime(date);
        vo.setModifier(userName);
        vo.setModifiedTime(date);
    }


    public void flushTimeStamp(SuperVO vo,HttpServletRequest request){
        HttpSession session =  request.getSession();
        long userName = (long) session.getAttribute("userName");
		Timestamp date = DateUtil.getCurrentTimestamp();
        vo.setModifier(userName);
        vo.setModifiedTime(date);
    }




}
