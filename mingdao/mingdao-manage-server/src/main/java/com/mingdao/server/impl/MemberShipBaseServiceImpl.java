package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemberShipBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMemberShipDao;
import com.mingdao.domain.MemberShip;

/**
 *
 * <code>MemberShipBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午12:24:31
 * @author libin
 */
@Service
public class MemberShipBaseServiceImpl implements IMemberShipBaseService {
  @Autowired
  private IMemberShipDao dao;

  @Override
  public MemberShip insert(MemberShip t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(MemberShip t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<MemberShip> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<MemberShip> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<MemberShip> pages = new Pager<MemberShip>(count, list);
    return pages;
  }

  @Override
  public MemberShip singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<MemberShip> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

  @Override
  public MemberShip queryDocById(Long id) {
    return null;
  }

}
