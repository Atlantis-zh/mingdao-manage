package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IOrderFormBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IOrderFormDao;
import com.mingdao.domain.OrderForm;

/**
 *
 * <code>OrderFormBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午1:48:26
 * @author libin
 */
@Service
public class OrderFormBaseServiceImpl implements IOrderFormBaseService {
  @Autowired
  private IOrderFormDao dao;

  @Override
  public OrderForm insert(OrderForm t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(OrderForm t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<OrderForm> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<OrderForm> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<OrderForm> pages = new Pager<OrderForm>(count, list);
    return pages;
  }

  @Override
  public OrderForm singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<OrderForm> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

  @Override
  public OrderForm queryDocById(Long id) {
    return null;
  }

}
