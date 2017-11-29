package com.mingdao.server.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IPackageTypeBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IPackageTypeDao;
import com.mingdao.dao.base.IPackageTypeDetailDao;
import com.mingdao.domain.PackageType;
import com.mingdao.domain.PackageTypeDetail;
import com.mingdao.domain.Store;

/**
 *
 * <code>PackageTypeBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：套餐类型服务类
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午1:53:45
 * @author libinf
 */

@Service("packageTypeBaseService")
public class PackageTypeBaseServiceImpl implements IPackageTypeBaseService {

  @Autowired
  private IPackageTypeDao dao;
  
  @Autowired
  private IPackageTypeDetailDao detaildao;

  @Override
  public PackageType insert(PackageType t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(PackageType t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<PackageType> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<PackageType> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<PackageType> pages = new Pager<PackageType>(count, list);
    return pages;
  }

  @Override
  public PackageType singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<PackageType> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public PackageType queryDocById(Long id) {
	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = detaildao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<PackageTypeDetail> body = detaildao.pageQueryByCondition(param, pageBounds);
    return dao.queryById(id);
  }

}
