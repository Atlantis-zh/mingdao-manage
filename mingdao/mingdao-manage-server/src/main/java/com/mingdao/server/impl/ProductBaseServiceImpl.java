package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IProductBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IProductDao;
import com.mingdao.domain.Product;

/**
 *
 * <code>ProductBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午10:03:23
 * @author libin
 */
@Service
public class ProductBaseServiceImpl implements IProductBaseService {

  @Autowired
  private IProductDao dao;

  @Override
  public Product insert(Product t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public Product update(Product t) {
    dao.updateVO(t);
    return t;
  }

  @Override
  public Pager<Product> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<Product> list = dao.pageQueryByCondition(param, pageBounds);
    Pager<Product> pages = new Pager<Product>(count, list);
    return pages;
  }

  @Override
  public Product singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<Product> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

  @Override
  public Product queryDocById(Long id) {
    return null;
  }

}
