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

@Service
public class PackageProjectBaseServiceImpl implements IPackageProjectBaseService {

	@Autowired
	private IPackageProjectDao dao;

	@Override
	public PackageProject insertPackageProject(PackageProject pp) {
		dao.insertVO(pp);
		return pp;
	}

	@Override
	public PackageProject updatePackageProject(PackageProject pp) {
		dao.updateVO(pp);
		return pp;
	}

	@Override
	public Pager<PackageProject> pageQueryPkgProjectByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<PackageProject> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<PackageProject> pages = new Pager<PackageProject>(count, list);
		return pages;
	}

}
