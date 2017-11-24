package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IOrderFormOfProductBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IOrderFormOfProductDao;
import com.mingdao.domain.OrderFormOfProduct;

/**
 *
 * <code>OrderFormOfProductBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午2:10:04
 * @author libin
 */
@Service
public class OrderFormOfProductBaseServiceImpl implements IOrderFormOfProductBaseService {
  @Autowired
  private IOrderFormOfProductDao dao;

  @Override
  public OrderFormOfProduct insert(OrderFormOfProduct t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public OrderFormOfProduct update(OrderFormOfProduct t) {
    dao.updateVO(t);
    return t;
  }

  @Override
  public Pager<OrderFormOfProduct> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<OrderFormOfProduct> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<OrderFormOfProduct> pages = new Pager<OrderFormOfProduct>(count, list);
    return pages;
  }

  @Override
  public OrderFormOfProduct singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<OrderFormOfProduct> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

  @Override
  public OrderFormOfProduct queryDocById(Long id) {
    return null;
  }

}
