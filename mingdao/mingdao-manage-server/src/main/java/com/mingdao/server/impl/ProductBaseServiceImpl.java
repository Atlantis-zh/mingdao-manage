package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IProductBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IMeasdocDao;
import com.mingdao.dao.base.IProductClassDao;
import com.mingdao.dao.base.IProductDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.Measdoc;
import com.mingdao.domain.Product;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductClassDTO;
import com.mingdao.domain.ProductDTO;
import com.mingdao.domain.Store;

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
  
  @Autowired
  private IProductClassDao typedao;
  
  @Autowired
  private IStoreDao storedao;
  
  @Autowired
  private IMeasdocDao measdocdao;

  @Override
  public Product insert(Product t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(Product t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<Product> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<Product> list = dao.pageQueryByCondition(param, pageBounds);
    processDTO(list);
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
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public Product queryDocById(Long id) {
	  Product vo =dao.queryById(id);
	  List<Product> list = new ArrayList<Product>();
	  list.add(vo);
	  processDTO(list);
    return vo;
  }
  
  private void processDTO(List<Product> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  List<ProductClass> products = typedao.batchQueryByCondition(param);
	  
	  List<Measdoc> measdocs = measdocdao.batchQueryByCondition(param);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  Map<Long,ProductClass> pro_map =new HashMap<Long,ProductClass>();
	  Map<Long,Measdoc> measdoc_map =new HashMap<Long,Measdoc>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  
	  for(ProductClass vo : products){
		  pro_map.put(vo.getId(), vo);
	  }
	  
	  for(Measdoc vo : measdocs){
		  measdoc_map.put(vo.getId(), vo);
	  }


	  for(Product vo : list){
		  ProductDTO dto = vo.createDto();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  ProductClass parentvo = pro_map.get(vo.getProductClassId());
		  if(parentvo!=null){
			  dto.setProductClassCode(parentvo.getCode());
			  dto.setProductClassName(parentvo.getName());
		  }
		  
		  Measdoc measdocvo = measdoc_map.get(vo.getMeasdocId());
		  if(measdocvo!=null){
			  dto.setMeasdocCode(measdocvo.getCode());
			  dto.setMeasdocName(measdocvo.getName());
		  }
		  vo.setDto(dto);
	  }
	  
  }

}
