package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IOrderFormOfServiceProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IOrderFormOfServiceProjectDao;
import com.mingdao.domain.OrderFormOfServiceProject;

/**
 *
 * <code>OrderFormOfServiceProjectBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午2:25:35
 * @author libin
 */
@Service
public class OrderFormOfServiceProjectBaseServiceImpl
    implements IOrderFormOfServiceProjectBaseService {
  @Autowired
  private IOrderFormOfServiceProjectDao dao;

  @Override
  public OrderFormOfServiceProject insert(OrderFormOfServiceProject t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(OrderFormOfServiceProject t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<OrderFormOfServiceProject> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<OrderFormOfServiceProject> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<OrderFormOfServiceProject> pages = new Pager<OrderFormOfServiceProject>(count, list);
    return pages;
  }

  @Override
  public OrderFormOfServiceProject singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<OrderFormOfServiceProject> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

  @Override
  public OrderFormOfServiceProject queryDocById(Long id) {
    return null;
  }

}
