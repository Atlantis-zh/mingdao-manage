package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IRoleBaseServiceItf;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IRoleDao;
import com.mingdao.domain.Role;

@Service
public class RoleBaseServiceItfImpl implements IRoleBaseServiceItf {

  @Autowired
  private IRoleDao dao;

  @Override
  public Role insert(Role t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(Role t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<Role> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<Role> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<Role> pages = new Pager<Role>(count, list);
    return pages;
  }

  @Override
  public Role singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<Role> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public Role queryDocById(Long id) {
    return dao.queryById(id);
  }

}
