package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IExchangeGiftBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IExchangeGiftDao;
import com.mingdao.domain.ExchangeGift;

/**
 *
 * <code>ExchangeGiftBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 上午10:33:15
 * @author libinf
 */

@Service("exchangeGiftBaseService")
public class ExchangeGiftBaseServiceImpl implements IExchangeGiftBaseService {

  @Autowired
  private IExchangeGiftDao dao;

  @Override
  public ExchangeGift insert(ExchangeGift t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(ExchangeGift t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<ExchangeGift> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<ExchangeGift> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<ExchangeGift> pages = new Pager<ExchangeGift>(count, list);
    return pages;
  }

  @Override
  public ExchangeGift singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<ExchangeGift> qryAllDoces(Map<String, Object> param) {
    return dao.batchQueryByCondition(param);
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public ExchangeGift queryDocById(Long id) {
    return dao.queryById(id);
  }

}
