package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IOrderFormOfAttachProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IOrderFormOfAttachProjectDao;
import com.mingdao.domain.OrderFormOfAttachProject;

/**
 *
 * <code>OrderFormOfAttachProjectBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午2:33:05
 * @author libin
 */
@Service
public class OrderFormOfAttachProjectBaseServiceImpl
    implements IOrderFormOfAttachProjectBaseService {
  @Autowired
  private IOrderFormOfAttachProjectDao dao;

  @Override
  public OrderFormOfAttachProject insert(OrderFormOfAttachProject t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(OrderFormOfAttachProject t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<OrderFormOfAttachProject> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<OrderFormOfAttachProject> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<OrderFormOfAttachProject> pages = new Pager<OrderFormOfAttachProject>(count, list);
    return pages;
  }

  @Override
  public OrderFormOfAttachProject singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<OrderFormOfAttachProject> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public OrderFormOfAttachProject queryDocById(Long id) {
    return null;
  }

}
