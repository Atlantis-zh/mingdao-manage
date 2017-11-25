package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemberShipCardBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMemberShipCardDao;
import com.mingdao.domain.MemberShipCard;

/**
 *
 * <code>MemberShipCardBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午11:17:54
 * @author libinf
 */

@Service("memberShipCardBaseService")
public class MemberShipCardBaseServiceImpl implements IMemberShipCardBaseService {

  @Autowired
  private IMemberShipCardDao dao;

  @Override
  public MemberShipCard insert(MemberShipCard t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(MemberShipCard t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<MemberShipCard> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<MemberShipCard> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<MemberShipCard> pages = new Pager<MemberShipCard>(count, list);
    return pages;
  }

  @Override
  public MemberShipCard singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<MemberShipCard> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public MemberShipCard queryDocById(Long id) {
    return dao.queryById(id);
  }

}
