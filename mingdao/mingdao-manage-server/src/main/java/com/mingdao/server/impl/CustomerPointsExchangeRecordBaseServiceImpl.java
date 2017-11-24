package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustomerPointsExchangeRecordBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustomerPointsExchangeRecordDao;
import com.mingdao.domain.CustomerPointsExchangeRecord;

/**
 *
 * <code>CustomerPointsExchangeRecordBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月21日 下午11:59:47
 * @author libin
 */
@Service
public class CustomerPointsExchangeRecordBaseServiceImpl
    implements ICustomerPointsExchangeRecordBaseService {
  @Autowired
  private ICustomerPointsExchangeRecordDao dao;

  @Override
  public CustomerPointsExchangeRecord insert(CustomerPointsExchangeRecord t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(CustomerPointsExchangeRecord t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<CustomerPointsExchangeRecord> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<CustomerPointsExchangeRecord> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<CustomerPointsExchangeRecord> pages =
        new Pager<CustomerPointsExchangeRecord>(count, list);
    return pages;
  }

  @Override
  public CustomerPointsExchangeRecord singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<CustomerPointsExchangeRecord> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public CustomerPointsExchangeRecord queryDocById(Long id) {
    return null;
  }

}
