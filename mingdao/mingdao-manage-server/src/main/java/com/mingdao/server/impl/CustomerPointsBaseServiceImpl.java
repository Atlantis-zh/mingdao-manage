package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustomerPointsBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustomerPointsDao;
import com.mingdao.domain.CustomerPoints;

/**
 *
 * <code>CustomerPointsBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月21日 下午11:14:01
 * @author libin
 */
@Service
public class CustomerPointsBaseServiceImpl implements ICustomerPointsBaseService {

  @Autowired
  private ICustomerPointsDao dao;

  @Override
  public CustomerPoints insert(CustomerPoints t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(CustomerPoints t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<CustomerPoints> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<CustomerPoints> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<CustomerPoints> pages = new Pager<CustomerPoints>(count, list);
    return pages;
  }

  @Override
  public CustomerPoints singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<CustomerPoints> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public CustomerPoints queryDocById(Long id) {
    return null;
  }

}
