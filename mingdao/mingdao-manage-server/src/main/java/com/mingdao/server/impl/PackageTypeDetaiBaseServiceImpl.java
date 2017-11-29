package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IPackageTypeDetailBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IPackageTypeDetailDao;
import com.mingdao.domain.PackageTypeDetail;

@Service("packageTypeDetaiBaseService")
public class PackageTypeDetaiBaseServiceImpl  implements IPackageTypeDetailBaseService {

	 @Autowired
	  private IPackageTypeDetailDao dao;

	  @Override
	  public PackageTypeDetail insert(PackageTypeDetail t) {
	    dao.insertVO(t);
	    return t;
	  }

	  @Override
	  public int update(PackageTypeDetail t) {
	    return dao.updateVO(t);
	  }

	  @Override
	  public Pager<PackageTypeDetail> pageQueryByCondition(Map<String, Object> param) {
	    int count = dao.getCountByCondition(param);
	    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	    List<PackageTypeDetail> list = dao.pageQueryByCondition(param, pageBounds);
	    Pager<PackageTypeDetail> pages = new Pager<PackageTypeDetail>(count, list);
	    return pages;
	  }

	  @Override
	  public PackageTypeDetail singleQryByCondtion(Map<String, Object> param) {
	    return dao.singleQueryByCondition(param);
	  }

	  @Override
	  public List<PackageTypeDetail> qryAllDoces(Map<String, Object> param) {
	    return dao.batchQueryByCondition(param);
	  }

	  @Override
	  public int deleteDocById(Long id) {
	    return dao.deleteDocById(id);
	  }

	  @Override
	  public PackageTypeDetail queryDocById(Long id) {
	    return dao.queryById(id);
	  }



}
