package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMeasdocBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMeasdocDao;
import com.mingdao.domain.Measdoc;

/**
 *
 * <code>MeasdocBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：计量单位基本服务实现类
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月23日 上午12:44:05
 * @author libinf
 */
@Service("measDocService")
public class MeasdocBaseServiceImpl implements IMeasdocBaseService {

  @Autowired
  private IMeasdocDao dao;

  @Override
  public Measdoc insert(Measdoc t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(Measdoc t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<Measdoc> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<Measdoc> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<Measdoc> pages = new Pager<Measdoc>(count, list);
    return pages;
  }

  @Override
  public Measdoc singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<Measdoc> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public Measdoc queryDocById(Long id) {
    return null;
  }

}
