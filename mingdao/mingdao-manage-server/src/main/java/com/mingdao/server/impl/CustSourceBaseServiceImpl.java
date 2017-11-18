package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustSourceBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustSourceDao;
import com.mingdao.domain.CustSource;

/**
 *
 * <code>CustSourceBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午5:02:33
 * @author libin
 */
@Service
public class CustSourceBaseServiceImpl implements ICustSourceBaseService {
  @Autowired
  private ICustSourceDao dao;

  @Override
  public CustSource insert(CustSource t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public CustSource update(CustSource t) {
    dao.updateVO(t);
    return t;
  }

  @Override
  public Pager<CustSource> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<CustSource> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<CustSource> pages = new Pager<CustSource>(count, list);
    return pages;
  }

  @Override
  public CustSource singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<CustSource> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

}
