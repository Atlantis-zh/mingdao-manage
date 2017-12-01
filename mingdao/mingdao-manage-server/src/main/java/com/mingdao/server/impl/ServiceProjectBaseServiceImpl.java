package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IServiceProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IProductClassDao;
import com.mingdao.dao.base.IServiceProductClassDao;
import com.mingdao.dao.base.IServiceProjectDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductClassDTO;
import com.mingdao.domain.ServiceProductClass;
import com.mingdao.domain.ServiceProject;
import com.mingdao.domain.ServiceProjectDTO;
import com.mingdao.domain.Store;

/**
 *
 * <code>ServiceProjectBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月23日 上午12:23:56
 * @author libinf
 */

@Service("ServiceProjectBaseService")
public class ServiceProjectBaseServiceImpl implements IServiceProjectBaseService {

  @Autowired
  private IServiceProjectDao dao;
  
  @Autowired
  private IServiceProductClassDao typedao;
  
  @Autowired
  private IStoreDao storedao;

  @Override
  public ServiceProject insert(ServiceProject t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(ServiceProject t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<ServiceProject> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<ServiceProject> list = dao.pageQueryByCondition(param, pageBounds);
    processDTO(list);
    Pager<ServiceProject> pages = new Pager<ServiceProject>(count, list);
    return pages;
  }

  @Override
  public ServiceProject singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<ServiceProject> qryAllDoces(Map<String, Object> param) {
    return null;
  }



  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public ServiceProject queryDocById(Long id) {
	  ServiceProject vo = dao.queryById(id);
	  List<ServiceProject> list = new ArrayList<ServiceProject>();
	  processDTO(list);
    return vo;
  }
  
  private void processDTO(List<ServiceProject> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  List<ServiceProductClass> products = typedao.batchQueryByCondition(param);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  Map<Long,ServiceProductClass> type_map =new HashMap<Long,ServiceProductClass>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  
	  for(ServiceProductClass vo : products){
		  type_map.put(vo.getId(), vo);
	  }

	  for(ServiceProject vo : list){
		  ServiceProjectDTO dto = vo.getDto();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  ServiceProductClass typevo = type_map.get(vo.getSerProdClassId());
		  if(typevo!=null){
			  dto.setSerProdClassICode(typevo.getCode());
			  dto.setSerProdClassIName(typevo.getName());
		  }
		  vo.setDto(dto);
	  }
	  
  }
}
