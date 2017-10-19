package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;

/**
 *
 * <code>IDocBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 上午9:40:52
 * @author libinf
 */

public interface IDocBaseService<T> {

	public T insert(T t);

	public T update(T t, Long modifier);

	public Pager<T> pageQueryByCondition(Map<String, Object> param);

	public T singleQryByCondtion(Map<String, Object> param);

}
