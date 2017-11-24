package com.mingdao.api;

import java.util.List;
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

  public int update(T t);

  public Pager<T> pageQueryByCondition(Map<String, Object> param);

  public T singleQryByCondtion(Map<String, Object> param);

  public List<T> qryAllDoces(Map<String, Object> param);

  public int deleteDocById(Long id);

  public T queryDocById(Long id);

}
