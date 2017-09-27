package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IStoreBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.Store;

/**
 *
 * <code>StoreBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月27日 上午9:56:20
 * @author libinf
 */
@Service
public class StoreBaseServiceImpl implements IStoreBaseService {

	@Autowired
	private IStoreDao dao;

	@Override
	public Store insertStore(Store store) {
		dao.insertVO(store);
		return store;
	}

	@Override
	public Store updateStore(Store store, Long modifyUserId) {
		store.setModifier(modifyUserId);
		store.setModifiedTime(DateUtil.getCurrentTimestamp());
		dao.updateVO(store);
		return store;
	}

	@Override
	public Pager<Store> pageQueryStoreByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<Store> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<Store> pages = new Pager<Store>(count, list);
		return pages;
	}

}
