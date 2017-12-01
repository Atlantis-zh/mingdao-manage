package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IPermissionBaseServiceItf;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IPermissionDao;
import com.mingdao.domain.Permission;

/**
 *
 * <code>PermissionBaseServiceItfImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月24日 下午4:50:21
 * @author libinf
 */
@Service
public class PermissionBaseServiceItfImpl implements IPermissionBaseServiceItf {

  @Autowired
  private IPermissionDao dao;

  @Override
  public Permission insert(Permission t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(Permission t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<Permission> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<Permission> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<Permission> pages = new Pager<Permission>(count, list);
    return pages;
  }

  @Override
  public Permission singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<Permission> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public Permission queryDocById(Long id) {
    return dao.queryById(id);
  }


}
