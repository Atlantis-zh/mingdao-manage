package com.mingdao.dao.base;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface IBaseDao<E> {
	public Long insertVO(E vo);
	public int insertVOs(E[] vos);
	public Long updateVO(E vo);
	public void deleteByIds(String[] ids);
	public E queryById(String id);
	public E singleQueryByCondition(Map<String, Object> param);
	public List<E> batchQueryByCondition(Map<String,Object> param);
	public List<E> pageQueryByCondition(Map<String,Object> param,PageBounds pageBounds);
	public List<E> queryByIds(String[] ids);
	public int getCountByCondition(Map<String,Object> param);
	public void deleteDocById(Long id);
}
