package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IWorkTimeClassBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IWorkTimeClassDao;
import com.mingdao.domain.WorkTimeClass;

/**
 *
 * <code>WorkTimeClassBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月22日 下午8:38:35
 * @author libinf
 */

@Service("workTimeClassBaseService")
public class WorkTimeClassBaseServiceImpl implements IWorkTimeClassBaseService {

  @Autowired
  private IWorkTimeClassDao dao;

  @Override
  public WorkTimeClass insert(WorkTimeClass t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(WorkTimeClass t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<WorkTimeClass> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<WorkTimeClass> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<WorkTimeClass> pages = new Pager<WorkTimeClass>(count, list);
    return pages;
  }

  @Override
  public WorkTimeClass singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<WorkTimeClass> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public WorkTimeClass queryDocById(Long id) {
    return dao.queryById(id);
  }

}
