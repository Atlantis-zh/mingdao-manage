package com.mingdao.dao.base;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface IBaseDao<E> {
  public Long insertVO(E vo);

  /**
   * 
   * <p>
   * 说明：返回受影响的行数
   * <li></li>
   * </p>
   * 
   * @param vo
   * @return
   * @date 2017年11月25日 上午12:35:35
   * @since NC6.5
   */
  public int updateVO(E vo);

  public void deleteByIds(Long[] ids);

  public E queryById(Long id);

  public E singleQueryByCondition(Map<String, Object> param);

  public List<E> batchQueryByCondition(Map<String, Object> param);

  public List<E> pageQueryByCondition(Map<String, Object> param, PageBounds pageBounds);

  public List<E> queryByIds(String[] ids);

  public int getCountByCondition(Map<String, Object> param);

  /**
   * 
   * <p>
   * 说明：返回受影响的行数
   * <li></li>
   * </p>
   * 
   * @param vo
   * @return
   * @date 2017年11月25日 上午12:35:35
   * @since NC6.5
   */
  public int deleteDocById(Long id);
}
