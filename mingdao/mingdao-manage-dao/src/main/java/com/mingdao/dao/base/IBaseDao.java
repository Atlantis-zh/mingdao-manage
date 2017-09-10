package com.mingdao.dao.base;

import java.util.List;

public interface IBaseDao<E> {
	public int insertVO(E entitie);
	public int insertVOs(E[] entities);
	public int updateVO(E head);
	public String[] nextIds(Object obj);
	public void deleteByIds(String[] ids);
	public E queryById(String id);
	public List<E> queryByIds(String[] ids);
}
