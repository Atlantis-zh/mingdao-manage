package com.mingdao.dao.base;

import java.util.List;

public interface IBaseDao<E> {
	public int insertVO(E vo);
	public int insertVOs(E[] vos);
	public int updateVO(E vo);
	public void deleteByIds(String[] ids);
	public E queryById(String id);
	public List<E> queryByIds(String[] ids);
}
