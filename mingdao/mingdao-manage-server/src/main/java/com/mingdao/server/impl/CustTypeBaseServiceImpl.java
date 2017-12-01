package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICustTypeBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustTypeDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.CustType;
import com.mingdao.domain.CustTypeDTO;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductClassDTO;
import com.mingdao.domain.Store;

/**
 *
 * <code>CustTypeBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午11:26:43
 * @author libinf
 */
@Service
public class CustTypeBaseServiceImpl implements ICustTypeBaseService {

  @Autowired
  private ICustTypeDao dao;
  
  @Autowired
  private IStoreDao storedao;

  @Override
  public CustType insert(CustType t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(CustType t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<CustType> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<CustType> list = dao.pageQueryByCondition(param, pageBounds);
    processDTO(list);
    Pager<CustType> pages = new Pager<CustType>(count, list);
    return pages;
  }

  @Override
  public CustType singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<CustType> qryAllDoces(Map<String, Object> param) {
    return dao.batchQueryByCondition(param);
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public CustType queryDocById(Long id) {
	  CustType vo = dao.queryById(id);
	  List<CustType> list = new ArrayList<CustType>();
	  list.add(vo);
	  processDTO(list);
    return vo;
  }
  
  private void processDTO(List<CustType> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  List<CustType> products = dao.batchQueryByCondition(param);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  Map<Long,CustType> pro_map =new HashMap<Long,CustType>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  
	  for(CustType vo : products){
		  pro_map.put(vo.getId(), vo);
	  }

	  for(CustType vo : list){
		  CustTypeDTO dto = vo.getDto();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  CustType parentvo = pro_map.get(vo.getParentId());
		  if(parentvo!=null){
			  dto.setParentCode(parentvo.getCode());
			  dto.setParentName(parentvo.getName());
		  }
		  vo.setDto(dto);
	  }
	  
  }

}
