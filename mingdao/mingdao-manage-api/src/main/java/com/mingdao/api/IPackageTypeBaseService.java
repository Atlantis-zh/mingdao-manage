package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.PackageType;

/**
 *
 * <code>IPackageTypeBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午1:52:04
 * @author libinf
 */

public interface IPackageTypeBaseService {

	public PackageType insertPkgType(PackageType packageType);

	public PackageType updatePkgType(PackageType packageType, Long modifyUserId);

	public Pager<PackageType> pageQueryPkgTypeByCondition(Map<String, Object> param);

}
