package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Store;

/**
 *
 * <code>IStoreBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月27日 上午9:55:15
 * @author libinf
 */

public interface IStoreBaseService {

	public Store insertStore(Store store);

	public Store updateStore(Store store, Long modifyUserId);

	public Pager<Store> pageQueryStoreByCondition(Map<String, Object> param);

}
