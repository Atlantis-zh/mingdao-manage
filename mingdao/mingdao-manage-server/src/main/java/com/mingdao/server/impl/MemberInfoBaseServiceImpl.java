package com.mingdao.server.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingdao.api.IMemberInfoBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.ICustomerDao;
import com.mingdao.dao.base.ICustomerPointsDao;
import com.mingdao.dao.base.IMemberShipDao;
import com.mingdao.domain.Customer;
import com.mingdao.domain.CustomerPoints;
import com.mingdao.domain.MemberInfo;
import com.mingdao.domain.MemberShip;

@Service("memberInfoBaseService")
public class MemberInfoBaseServiceImpl implements IMemberInfoBaseService{

	  @Autowired
	  private IMemberShipDao dao;
	  
	  @Autowired
	  private ICustomerPointsDao pointdao;
	  
	  @Autowired
	  private ICustomerDao customerdao;
	  
	@Override
	public MemberInfo insert(MemberInfo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberInfo t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pager<MemberInfo> pageQueryByCondition(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberInfo singleQryByCondtion(Map<String, Object> param) {
		MemberInfo info = new MemberInfo();
		Customer cust = customerdao.singleQueryByCondition(param);
		if(cust==null)
			return info;
		info.setCustomerId(cust.getId());
		Map<String, Object> memberparam = new HashMap<String, Object>();
		memberparam.put("customerId", cust.getId());
		List<MemberShip>  list =   dao.batchQueryByCondition(param);
		
		if(list==null||list.get(0)==null)
			return info;
		MemberShip member= list.get(0);
		info.setRemaining(member.getRemaining());
		info.setTotalRemainCount(member.getTotalRemainCount());
		List<CustomerPoints>  points =pointdao.batchQueryByCondition(memberparam);
		 
		if(points==null||points.get(0)==null)
			return info;
		CustomerPoints point = points.get(0);
		info.setPoints(point.getPoints());
		return info;
	}

	@Override
	public List<MemberInfo> qryAllDoces(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDocById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberInfo queryDocById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
