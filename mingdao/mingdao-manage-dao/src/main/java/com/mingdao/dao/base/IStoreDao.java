package com.mingdao.dao.base;

import com.mingdao.domain.Store;

/**
 *
 * <code>IStoreDao<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月27日 上午9:53:59
 * @author libinf
 */

public interface IStoreDao extends IBaseDao<Store> {
    public int deleteStore(int id);

}
