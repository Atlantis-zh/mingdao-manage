package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IPackageProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IPackageProjectDao;
import com.mingdao.domain.PackageProject;

/**
 *
 * <code>PackageProjectBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午2:35:09
 * @author libinf
 */

@Service("packageProjectBaseService")
public class PackageProjectBaseServiceImpl implements IPackageProjectBaseService {

  @Autowired
  private IPackageProjectDao dao;

  @Override
  public PackageProject insert(PackageProject t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(PackageProject t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<PackageProject> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<PackageProject> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<PackageProject> pages = new Pager<PackageProject>(count, list);
    return pages;
  }

  @Override
  public PackageProject singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<PackageProject> qryAllDoces(Map<String, Object> param) {
    return dao.batchQueryByCondition(param);
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public PackageProject queryDocById(Long id) {
    return dao.queryById(id);
  }



}
