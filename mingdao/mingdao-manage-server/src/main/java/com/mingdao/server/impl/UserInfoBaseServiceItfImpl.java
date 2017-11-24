package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IUserInfoBaseServiceItf;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IUserInfoDao;
import com.mingdao.domain.UserInfo;

@Service
public class UserInfoBaseServiceItfImpl implements IUserInfoBaseServiceItf {
  public static Logger logger = LoggerFactory.getLogger(UserInfoBaseServiceItfImpl.class);


  @Autowired
  private IUserInfoDao dao;


  @Override
  public UserInfo insert(UserInfo t) {
    dao.insertVO(t);
    return t;
  }


  @Override
  public int update(UserInfo t) {
    return dao.updateVO(t);
  }


  @Override
  public Pager<UserInfo> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<UserInfo> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<UserInfo> pages = new Pager<UserInfo>(count, list);
    return pages;
  }


  @Override
  public UserInfo singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }


  @Override
  public List<UserInfo> qryAllDoces(Map<String, Object> param) {
    return null;
  }


  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }


  @Override
  public UserInfo queryDocById(Long id) {
    return dao.queryById(id);
  }

}
