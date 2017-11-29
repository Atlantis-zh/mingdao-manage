package com.mingdao.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IOrderFormBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustomerDao;
import com.mingdao.dao.base.IMeasdocDao;
import com.mingdao.dao.base.IMemberShipDao;
import com.mingdao.dao.base.IOrderFormDao;
import com.mingdao.dao.base.IProductClassDao;
import com.mingdao.dao.base.IProductDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.Customer;
import com.mingdao.domain.Measdoc;
import com.mingdao.domain.MemberShip;
import com.mingdao.domain.OrderForm;
import com.mingdao.domain.OrderFormDTO;
import com.mingdao.domain.Product;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductDTO;
import com.mingdao.domain.Store;

/**
 *
 * <code>OrderFormBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午1:48:26
 * @author libin
 */
@Service
public class OrderFormBaseServiceImpl implements IOrderFormBaseService {
  @Autowired
  private IOrderFormDao dao;
  
  @Autowired
  private IProductDao productdao;
  
  @Autowired
  private ICustomerDao typedao;
  
  @Autowired
  private IStoreDao storedao;
  
  @Autowired
  private IMemberShipDao memberdao;

  @Override
  public OrderForm insert(OrderForm t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(OrderForm t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<OrderForm> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<OrderForm> list = dao.pageQueryByCondition(param, pageBounds);
    processDTO(list);
    Pager<OrderForm> pages = new Pager<OrderForm>(count, list);
    return pages;
  }

  @Override
  public OrderForm singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<OrderForm> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public OrderForm queryDocById(Long id) {
	  OrderForm vo = dao.queryById(id);
	  List<OrderForm> list = new ArrayList<OrderForm>();
	  list.add(vo);
	  processDTO(list);
    return vo;
  }
  
  private void processDTO(List<OrderForm> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  List<Customer> customers = typedao.batchQueryByCondition(param);
	  
	  List<MemberShip> measdocs = memberdao.batchQueryByCondition(param);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  Map<Long,Customer> cust_map =new HashMap<Long,Customer>();
	  Map<Long,MemberShip> measdoc_map =new HashMap<Long,MemberShip>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  
	  for(Customer vo : customers){
		  cust_map.put(vo.getId(), vo);
	  }
	  
	  for(MemberShip vo : measdocs){
		  measdoc_map.put(vo.getCustomerId(), vo);
	  }


	  for(OrderForm vo : list){
		  OrderFormDTO dto = vo.createDTO();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  Customer custvo = cust_map.get(vo.getCustomerId());
		  if(custvo!=null){
			  dto.setCustomerName(custvo.getName());;
//			  dto.setCarInfoId(custvo.getStoreId());
		  }
		  
		  MemberShip membervo = measdoc_map.get(vo.getCustomerId());
		  if(membervo!=null){
			  dto.setCardNo(membervo.getCardNo());
//			  dto.setMeasdocName(measdocvo.getName());
		  }
		  vo.setDto(dto);
	  }
	  
  }

}
