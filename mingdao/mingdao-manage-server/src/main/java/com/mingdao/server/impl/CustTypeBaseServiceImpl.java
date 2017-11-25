package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustTypeBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustTypeDao;
import com.mingdao.domain.CustType;

/**
 *
 * <code>CustTypeBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午11:26:43
 * @author libinf
 */
@Service
public class CustTypeBaseServiceImpl implements ICustTypeBaseService {

  @Autowired
  private ICustTypeDao dao;

  @Override
  public CustType insert(CustType t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(CustType t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<CustType> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<CustType> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<CustType> pages = new Pager<CustType>(count, list);
    return pages;
  }

  @Override
  public CustType singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<CustType> qryAllDoces(Map<String, Object> param) {
    return dao.batchQueryByCondition(param);
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public CustType queryDocById(Long id) {
    return dao.queryById(id);
  }

}
