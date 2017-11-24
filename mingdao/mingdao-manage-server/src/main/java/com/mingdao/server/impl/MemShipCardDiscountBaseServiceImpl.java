package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemShipCardDiscountBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMemShipCardDiscountDao;
import com.mingdao.domain.MemShipCardDiscount;

/**
 *
 * <code>MemShipCardDiscountBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午10:51:37
 * @author libin
 */
@Service
public class MemShipCardDiscountBaseServiceImpl implements IMemShipCardDiscountBaseService {
  @Autowired
  private IMemShipCardDiscountDao dao;

  @Override
  public MemShipCardDiscount insert(MemShipCardDiscount t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(MemShipCardDiscount t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<MemShipCardDiscount> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<MemShipCardDiscount> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<MemShipCardDiscount> pages = new Pager<MemShipCardDiscount>(count, list);
    return pages;
  }

  @Override
  public MemShipCardDiscount singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<MemShipCardDiscount> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

  @Override
  public MemShipCardDiscount queryDocById(Long id) {
    return null;
  }

}
