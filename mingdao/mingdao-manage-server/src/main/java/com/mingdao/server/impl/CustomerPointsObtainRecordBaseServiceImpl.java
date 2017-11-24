package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustomerPointsObtainRecordBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustomerPointsObtainRecordDao;
import com.mingdao.domain.CustomerPointsObtainRecord;

/**
 *
 * <code>CustomerPointsObtainRecordBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月21日 下午11:42:06
 * @author libin
 */
@Service
public class CustomerPointsObtainRecordBaseServiceImpl
    implements ICustomerPointsObtainRecordBaseService {

  @Autowired
  private ICustomerPointsObtainRecordDao dao;

  @Override
  public CustomerPointsObtainRecord insert(CustomerPointsObtainRecord t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(CustomerPointsObtainRecord t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<CustomerPointsObtainRecord> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<CustomerPointsObtainRecord> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<CustomerPointsObtainRecord> pages = new Pager<CustomerPointsObtainRecord>(count, list);
    return pages;
  }

  @Override
  public CustomerPointsObtainRecord singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<CustomerPointsObtainRecord> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public CustomerPointsObtainRecord queryDocById(Long id) {
    return null;
  }

}
