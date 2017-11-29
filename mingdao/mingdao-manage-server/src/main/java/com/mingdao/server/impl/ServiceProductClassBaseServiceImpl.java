package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IServiceProductClassBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IServiceProductClassDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.dao.base.IWorkTimeClassDao;
import com.mingdao.domain.Measdoc;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductClassDTO;
import com.mingdao.domain.ServiceProductClass;
import com.mingdao.domain.ServiceProductClassDTO;
import com.mingdao.domain.Store;
import com.mingdao.domain.WorkTimeClass;

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
  
  @Autowired
  private IStoreDao storedao;
  
  @Autowired
  private IWorkTimeClassDao worktimedao;

  @Override
  public ServiceProductClass insert(ServiceProductClass t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(ServiceProductClass t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<ServiceProductClass> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<ServiceProductClass> list = dao.pageQueryByCondition(param, pageBounds);
    processDTO(list);
    Pager<ServiceProductClass> pages = new Pager<ServiceProductClass>(count, list);
    return pages;
  }

  @Override
  public ServiceProductClass singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<ServiceProductClass> qryAllDoces(Map<String, Object> param) {
    return dao.batchQueryByCondition(param);
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public ServiceProductClass queryDocById(Long id) {
	  ServiceProductClass vo = dao.queryById(id);
	  List<ServiceProductClass> list = new ArrayList<ServiceProductClass>();
	  list.add(vo);
	  processDTO(list);
    return vo;
  }
  
  private void processDTO(List<ServiceProductClass> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  List<ServiceProductClass> products = dao.batchQueryByCondition(param);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  Map<Long,ServiceProductClass> pro_map =new HashMap<Long,ServiceProductClass>();
      List<WorkTimeClass> worktimes = worktimedao.batchQueryByCondition(param);
	  
	  Map<Long,WorkTimeClass> worktimes_map =new HashMap<Long,WorkTimeClass>();

	  for(WorkTimeClass vo : worktimes){
		  worktimes_map.put(vo.getId(), vo);
	  }
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  
	  for(ServiceProductClass vo : products){
		  pro_map.put(vo.getId(), vo);
	  }

	  for(ServiceProductClass vo : list){
		  ServiceProductClassDTO dto = vo.createDto();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  ServiceProductClass parentvo = pro_map.get(vo.getParentId());
		  if(parentvo!=null){
			  dto.setParentCode(parentvo.getCode());
			  dto.setParentName(parentvo.getName());
		  }
		  WorkTimeClass worktypevo = worktimes_map.get(vo.getWorkTimeClassId());
		  if(worktypevo!=null){
			  dto.setWorkTimeClassCode(worktypevo.getCode());
			  dto.setWorkTimeClassName(worktypevo.getName());
		  }
		  vo.setDto(dto);
	  }
	  
  }

}
