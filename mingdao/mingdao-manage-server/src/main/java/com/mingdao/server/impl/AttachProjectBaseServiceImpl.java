package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IAttachProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IAttachProjectDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.AttachProject;
import com.mingdao.domain.AttachProjectDTO;
import com.mingdao.domain.Store;

/**
 *
 * <code>AttachProjectBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午4:32:06
 * @author libin
 */

@Service("attachProjectBaseService")
public class AttachProjectBaseServiceImpl implements IAttachProjectBaseService {
  @Autowired
  private IAttachProjectDao dao;
  
  @Autowired
  private IStoreDao storedao;

  @Override
  public AttachProject insert(AttachProject t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(AttachProject t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<AttachProject> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<AttachProject> list = dao.pageQueryByCondition(param, pageBounds);
    List<AttachProjectDTO> dtos = processDTO(list);
    Pager<AttachProject> pages = new Pager<AttachProject>(count, list);
    return pages;
  }

  @Override
  public AttachProject singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<AttachProject> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public AttachProject queryDocById(Long id) {
	  AttachProject vo = dao.queryById(id);
	  Store store = this.storedao.queryById(vo.getStoreId());
	  AttachProjectDTO dto = vo.createDto();

	  if(store!=null){
		  dto.setStoreCode(store.getCode());
		  dto.setStoreName(store.getName());
		  vo.setDto(dto);
	  }
    return vo;
  }
  
  private List<AttachProjectDTO> processDTO(List<AttachProject> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  List<AttachProjectDTO> dtos = new ArrayList<AttachProjectDTO>();
	  for(AttachProject vo : list){
		  AttachProjectDTO dto = vo.createDto();
		  Store store = map.get(vo.getStoreId());
		  if(dto==null){
			  dtos.add(dto);
			  continue;
		  }
		  dto.setStoreCode(store.getCode());
		  dto.setStoreName(store.getName());
		  vo.setDto(dto);
		  dtos.add(dto);
	  }
	  
	  return dtos;
  }

}
