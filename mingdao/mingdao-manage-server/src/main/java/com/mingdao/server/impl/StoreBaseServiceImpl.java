package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IStoreBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.Store;

/**
 *
 * <code>StoreBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月27日 上午9:56:20
 * @author libinf
 */
@Service
public class StoreBaseServiceImpl implements IStoreBaseService {

  @Autowired
  private IStoreDao dao;

  @Override
  public Store insert(Store t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(Store t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<Store> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<Store> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<Store> pages = new Pager<Store>(count, list);
    return pages;
  }

  @Override
  public Store singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<Store> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {
    dao.deleteDocById(id);
  }

  @Override
  public Store queryDocById(Long id) {
    return dao.queryById(id);
  }
}
