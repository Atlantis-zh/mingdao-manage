package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IProductClassBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IProductClassDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.AttachProject;
import com.mingdao.domain.AttachProjectDTO;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductClassDTO;
import com.mingdao.domain.Store;

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
  
  @Autowired
  private IStoreDao storedao;

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
    processDTO(list);
    Pager<ProductClass> pages = new Pager<ProductClass>(count, list);
    return pages;
  }

  @Override
  public ProductClass singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<ProductClass> qryAllDoces(Map<String, Object> param) {
    return dao.batchQueryByCondition(param);
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public ProductClass queryDocById(Long id) {
	  ProductClass vo = dao.queryById(id);
	  List<ProductClass> list = new ArrayList<ProductClass>();
	  list.add(vo);
	  processDTO(list);
    return vo;
  }
  
  private void processDTO(List<ProductClass> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  List<ProductClass> products = dao.batchQueryByCondition(param);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  Map<Long,ProductClass> pro_map =new HashMap<Long,ProductClass>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  
	  for(ProductClass vo : products){
		  pro_map.put(vo.getId(), vo);
	  }

	  for(ProductClass vo : list){
		  ProductClassDTO dto = vo.createDto();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  ProductClass parentvo = pro_map.get(vo.getParentId());
		  if(parentvo!=null){
			  dto.setParentCode(parentvo.getCode());
			  dto.setParentName(parentvo.getName());
		  }
		  vo.setDto(dto);
	  }
	  
  }

}
