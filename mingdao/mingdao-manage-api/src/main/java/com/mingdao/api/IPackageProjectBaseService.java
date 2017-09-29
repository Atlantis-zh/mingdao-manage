package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.PackageProject;

/**
 *
 * <code>IPackageProjectBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午2:29:27
 * @author libinf
 */

public interface IPackageProjectBaseService {

	public PackageProject insertPackageProject(PackageProject pp);

	public PackageProject updatePackageProject(PackageProject pp);

	public Pager<PackageProject> pageQueryPkgProjectByCondition(Map<String, Object> param);

}
