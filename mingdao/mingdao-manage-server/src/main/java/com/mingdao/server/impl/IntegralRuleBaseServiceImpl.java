package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IIntegralRuleBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IIntegralRuleDao;
import com.mingdao.domain.IntegralRule;

/**
 *
 * <code>IntegralRuleBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 上午9:44:33
 * @author libinf
 */
@Service("integralRuleBaseService")
public class IntegralRuleBaseServiceImpl implements IIntegralRuleBaseService {
  @Autowired
  private IIntegralRuleDao dao;

  @Override
  public IntegralRule insert(IntegralRule t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(IntegralRule t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<IntegralRule> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<IntegralRule> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<IntegralRule> pages = new Pager<IntegralRule>(count, list);
    return pages;
  }

  @Override
  public IntegralRule singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<IntegralRule> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {
    dao.deleteDocById(id);
  }

  @Override
  public IntegralRule queryDocById(Long id) {
    return null;
  }

}
