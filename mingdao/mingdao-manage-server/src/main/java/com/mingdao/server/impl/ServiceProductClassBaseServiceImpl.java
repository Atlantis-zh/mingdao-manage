package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IServiceProductClassBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IServiceProductClassDao;
import com.mingdao.domain.ServiceProductClass;

/**
 *
 * <code>ServiceProductClassBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：服务产品分类服务
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月22日 下午10:04:40
 * @author libinf
 */

@Service("serviceProductClassBaseService")
public class ServiceProductClassBaseServiceImpl implements IServiceProductClassBaseService {

  @Autowired
  private IServiceProductClassDao dao;

  @Override
  public ServiceProductClass insert(ServiceProductClass t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public ServiceProductClass update(ServiceProductClass t) {
    dao.updateVO(t);
    return t;
  }

  @Override
  public Pager<ServiceProductClass> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<ServiceProductClass> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<ServiceProductClass> pages = new Pager<ServiceProductClass>(count, list);
    return pages;
  }

  @Override
  public ServiceProductClass singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<ServiceProductClass> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {
    dao.deleteDocById(id);
  }

  @Override
  public ServiceProductClass queryDocById(Long id) {
    return null;
  }

}
