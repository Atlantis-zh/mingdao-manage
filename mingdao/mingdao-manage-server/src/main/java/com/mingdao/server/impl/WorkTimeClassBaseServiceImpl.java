package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IWorkTimeClassBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.dao.base.IWorkTimeClassDao;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductClassDTO;
import com.mingdao.domain.Store;
import com.mingdao.domain.WorkTimeClass;
import com.mingdao.domain.WorkTimeClassDTO;

/**
 *
 * <code>WorkTimeClassBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月22日 下午8:38:35
 * @author libinf
 */

@Service("workTimeClassBaseService")
public class WorkTimeClassBaseServiceImpl implements IWorkTimeClassBaseService {

  @Autowired
  private IWorkTimeClassDao dao;
  
  @Autowired
  private IStoreDao storedao;

  @Override
  public WorkTimeClass insert(WorkTimeClass t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(WorkTimeClass t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<WorkTimeClass> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<WorkTimeClass> list = dao.pageQueryByCondition(param, pageBounds);
    processDTO(list);
    Pager<WorkTimeClass> pages = new Pager<WorkTimeClass>(count, list);
    return pages;
  }

  @Override
  public WorkTimeClass singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<WorkTimeClass> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public WorkTimeClass queryDocById(Long id) {
	  WorkTimeClass vo = dao.queryById(id);
	  List<WorkTimeClass> list = new ArrayList<WorkTimeClass>();
	  list.add(vo);
	  processDTO(list);
    return vo;
  }
  
  private void processDTO(List<WorkTimeClass> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  

	  for(WorkTimeClass vo : list){
		  WorkTimeClassDTO dto = vo.createDto();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  vo.setDto(dto);
	  }
	  
  }

}
