package com.mingdao.controller;

import com.mingdao.common.utils.DateUtil;
import com.mingdao.domain.SuperVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ambitious on 2017/9/28.
 */
public class BaseController {

    public void initTimeStamp(SuperVO vo,HttpServletRequest request){
        HttpSession session =  request.getSession();
        long userName = (long) session.getAttribute("userName");
        String date =  DateUtil.dateToStringWithTime();
        vo.setCreator(userName);
        vo.setCreateTime(date);
        vo.setModifier(userName);
        vo.setModifiedTime(date);
    }


    public void flushTimeStamp(SuperVO vo,HttpServletRequest request){
        HttpSession session =  request.getSession();
        long userName = (long) session.getAttribute("userName");
        String date =  DateUtil.dateToStringWithTime();
        vo.setModifier(userName);
        vo.setModifiedTime(date);
    }




}
