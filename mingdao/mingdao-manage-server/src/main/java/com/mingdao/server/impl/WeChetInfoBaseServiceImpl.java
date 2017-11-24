package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IWeChetInfoBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IWeChetInfoDao;
import com.mingdao.domain.WeChatInfo;

/**
 *
 * <code>IWeChetInfoDao<code> <strong></strong>
 * <p>
 * 
 * <li>微信关注列表</li>
 * </p>
 * 
 * @since
 * @version
 * @author libin
 */
@Service
public class WeChetInfoBaseServiceImpl implements IWeChetInfoBaseService {

  @Autowired
  private IWeChetInfoDao dao;

  @Override
  public WeChatInfo insert(WeChatInfo t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(WeChatInfo t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<WeChatInfo> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<WeChatInfo> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<WeChatInfo> pages = new Pager<WeChatInfo>(count, list);
    return pages;
  }

  @Override
  public WeChatInfo singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<WeChatInfo> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public WeChatInfo queryDocById(Long id) {
    return dao.queryById(id);
  }


}
