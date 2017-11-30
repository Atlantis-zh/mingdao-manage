package com.mingdao.server.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IMemberShipBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICarInfoDao;
import com.mingdao.dao.base.ICustomerDao;
import com.mingdao.dao.base.IMemberShipDao;
import com.mingdao.dao.base.IStoreDao;
import com.mingdao.domain.CarInfo;
import com.mingdao.domain.Customer;
import com.mingdao.domain.Measdoc;
import com.mingdao.domain.MemberShip;
import com.mingdao.domain.MemberShipRefDTO;
import com.mingdao.domain.Product;
import com.mingdao.domain.ProductClass;
import com.mingdao.domain.ProductDTO;
import com.mingdao.domain.Store;

/**
 *
 * <code>MemberShipBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午12:24:31
 * @author libin
 */
@Service
public class MemberShipBaseServiceImpl implements IMemberShipBaseService {
  @Autowired
  private IMemberShipDao dao;
  @Autowired
  private ICarInfoDao carinfodao;
  
  @Autowired
  private ICustomerDao customerdao;
  
  @Autowired
  private IStoreDao storedao;

  @Override
  public MemberShip insert(MemberShip t) {
    dao.insertVO(t);
    return t;
  }

  @Override
  public int update(MemberShip t) {
    return dao.updateVO(t);
  }

  @Override
  public Pager<MemberShip> pageQueryByCondition(Map<String, Object> param) {
    int count = dao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<MemberShip> list = dao.pageQueryByCondition(param, pageBounds);
    processDTO(list);
    Pager<MemberShip> pages = new Pager<MemberShip>(count, list);
    return pages;
  }

  @Override
  public MemberShip singleQryByCondtion(Map<String, Object> param) {
    return dao.singleQueryByCondition(param);
  }

  @Override
  public List<MemberShip> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public int deleteDocById(Long id) {
    return dao.deleteDocById(id);
  }

  @Override
  public MemberShip queryDocById(Long id) {
    return dao.queryById(id);
  }
  
  private void processDTO(List<MemberShip> list){

	  Map<String, Object>  param = new HashMap<String, Object>();
	  int count = storedao.getCountByCondition(param);
	  PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
	  List<Store> stores = storedao.pageQueryByCondition(param, pageBounds);
	  
	  List<Customer> products = this.customerdao.batchQueryByCondition(param);
	  
	  List<CarInfo> carinfos = this.carinfodao.batchQueryByCondition(param);
	  
	  Map<Long,Store> map =new HashMap<Long,Store>();
	  Map<Long,Customer> cust_map =new HashMap<Long,Customer>();
	  Map<Long,CarInfo> car_map =new HashMap<Long,CarInfo>();
	  for(Store vo : stores){
		  map.put(vo.getId(), vo);
	  }
	  
	  for(Customer vo : products){
		  cust_map.put(vo.getId(), vo);
	  }
	  
	  for(CarInfo vo : carinfos){
		  car_map.put(vo.getId(), vo);
	  }


	  for(MemberShip vo : list){
		  MemberShipRefDTO dto = vo.getDto();
		  Store store = map.get(vo.getStoreId());
		  if(store!=null){
			  dto.setStoreCode(store.getCode());
			  dto.setStoreName(store.getName());
		  }
		  Customer parentvo = cust_map.get(vo.getCustomerId());
		  if(parentvo!=null){
			  dto.setCustName(parentvo.getCode());
			  dto.setCustPhone(parentvo.getPhone());
		  }
		  
		  CarInfo measdocvo = car_map.get(vo.getCarInfoId());
		  if(measdocvo!=null){
			  dto.setPlatNumber(measdocvo.getPlatNumber());
		  }
		  vo.setDto(dto);
	  }
	  
  }

}
