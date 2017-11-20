package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemShipPackageConsumerDetailBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMemShipPackageConsumerDetailDao;
import com.mingdao.domain.MemShipPackageConsumerDetail;

/**
 *
 * <code>MemShipPackageConsumerDetailBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午1:15:32
 * @author libin
 */
@Service
public class MemShipPackageConsumerDetailBaseServiceImpl
    implements IMemShipPackageConsumerDetailBaseService {

  @Autowired
  private IMemShipPackageConsumerDetailDao dao;

  @Override
  public MemShipPackageConsumerDetail insert(MemShipPackageConsumerDetail t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public MemShipPackageConsumerDetail update(MemShipPackageConsumerDetail t) {
    dao.updateVO(t);
    return t;
  }

  @Override
  public Pager<MemShipPackageConsumerDetail> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<MemShipPackageConsumerDetail> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<MemShipPackageConsumerDetail> pages =
        new Pager<MemShipPackageConsumerDetail>(count, list);
    return pages;
  }

  @Override
  public MemShipPackageConsumerDetail singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<MemShipPackageConsumerDetail> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

}
