package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemberShipReChargeCardComDetailBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMemberShipReChargeCardComDetailDao;
import com.mingdao.domain.MemberShipReChargeCardComDetail;

/**
 *
 * <code>MemberShipReChargeCardComDetailBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午1:25:55
 * @author libin
 */
@Service
public class MemberShipReChargeCardComDetailBaseServiceImpl
    implements IMemberShipReChargeCardComDetailBaseService {
  @Autowired
  private IMemberShipReChargeCardComDetailDao dao;

  @Override
  public MemberShipReChargeCardComDetail insert(MemberShipReChargeCardComDetail t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(MemberShipReChargeCardComDetail t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<MemberShipReChargeCardComDetail> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<MemberShipReChargeCardComDetail> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<MemberShipReChargeCardComDetail> pages =
        new Pager<MemberShipReChargeCardComDetail>(count, list);
    return pages;
  }

  @Override
  public MemberShipReChargeCardComDetail singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<MemberShipReChargeCardComDetail> qryAllDoces(Map<String, Object> param) {
    return dao.batchQueryByCondition(param);
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public MemberShipReChargeCardComDetail queryDocById(Long id) {
    return null;
  }

}
