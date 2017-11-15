package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IPackageTypeBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IPackageTypeDao;
import com.mingdao.domain.PackageType;

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

	@Override
	public PackageType insertPkgType(PackageType packageType) {
		dao.insertVO(packageType);
		return packageType;
	}

	@Override
	public PackageType updatePkgType(PackageType packageType) {
		dao.updateVO(packageType);
		return packageType;
	}

	@Override
	public Pager<PackageType> pageQueryPkgTypeByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<PackageType> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<PackageType> pages = new Pager<PackageType>(count, list);
		return pages;
	}

	@Override
	public void deletePackageType(Long id) {
		dao.deleteDocById(id);
	}
}
