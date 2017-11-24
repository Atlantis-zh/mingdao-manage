package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IProductClassBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IProductClassDao;
import com.mingdao.domain.ProductClass;

/**
 *
 * <code>ProductClassBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午6:34:34
 * @author libin
 */
@Service
public class ProductClassBaseServiceImpl implements IProductClassBaseService {

  @Autowired
  private IProductClassDao dao;

  @Override
  public ProductClass insert(ProductClass t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(ProductClass t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<ProductClass> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<ProductClass> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<ProductClass> pages = new Pager<ProductClass>(count, list);
    return pages;
  }

  @Override
  public ProductClass singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<ProductClass> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public ProductClass queryDocById(Long id) {
    return dao.queryById(id);
  }

}
