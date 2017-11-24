package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMenuBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMenuDao;
import com.mingdao.domain.Menu;

/**
 *
 * <code>MenuBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月31日 上午11:28:41
 * @author libinf
 */
@Service("menuBaseService")
public class MenuBaseServiceImpl implements IMenuBaseService {
  @Autowired
  private IMenuDao dao;

  @Override
  public Menu insert(Menu t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(Menu t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<Menu> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<Menu> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<Menu> pages = new Pager<Menu>(count, list);
    return pages;
  }

  @Override
  public Menu singleQryByCondtion(Map<String, Object> param) {
    Menu resutl = dao.singleQueryByCondition(param);
    return resutl;
  }

  @Override
  public List<Menu> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public boolean isDocExist(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    if (count == 0) {
      return false;
    }
    return true;
  }

  @Override
  public void deleteDocById(Long id) {
    dao.deleteDocById(id);
  }

  @Override
  public Menu queryDocById(Long id) {
    return null;
  }

}
