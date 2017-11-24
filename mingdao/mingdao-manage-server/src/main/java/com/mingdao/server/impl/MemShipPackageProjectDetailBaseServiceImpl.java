package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemShipPackageProjectDetailBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMemShipPackageProjectDetailDao;
import com.mingdao.domain.MemShipPackageProjectDetail;

/**
 *
 * <code>MemShipPackageProjectDetailBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午12:44:26
 * @author libin
 */
@Service
public class MemShipPackageProjectDetailBaseServiceImpl
    implements IMemShipPackageProjectDetailBaseService {
  @Autowired
  private IMemShipPackageProjectDetailDao dao;

  @Override
  public MemShipPackageProjectDetail insert(MemShipPackageProjectDetail t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(MemShipPackageProjectDetail t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<MemShipPackageProjectDetail> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<MemShipPackageProjectDetail> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<MemShipPackageProjectDetail> pages = new Pager<MemShipPackageProjectDetail>(count, list);
    return pages;
  }

  @Override
  public MemShipPackageProjectDetail singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<MemShipPackageProjectDetail> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public MemShipPackageProjectDetail queryDocById(Long id) {
    return null;
  }

}
