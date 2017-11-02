package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.ICarInfoBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.dao.base.ICarInfoDao;
import com.mingdao.domain.CarInfo;

/**
 *
 * <code>CarInfoBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：车辆信息基本服务
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月15日 下午3:00:21
 * @author libinf
 */
@Service
public class CarInfoBaseServiceImpl implements ICarInfoBaseService {

	@Autowired
	private ICarInfoDao dao;

	@Override
	public CarInfo insert(CarInfo t) {
		dao.insertVO(t);
		return t;
	}

	@Override
	public CarInfo update(CarInfo t) {
		dao.updateVO(t);
		return t;
	}

	@Override
	public Pager<CarInfo> pageQueryByCondition(Map<String, Object> param) {
		int count = dao.getCountByCondition(param);
		PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
		List<CarInfo> list = dao.pageQueryByCondition(param, pageBounds);
		Pager<CarInfo> pages = new Pager<CarInfo>(count, list);
		return pages;
	}

	@Override
	public CarInfo singleQryByCondtion(Map<String, Object> param) {
		CarInfo carInfo = dao.singleQueryByCondition(param);
		return carInfo;
	}

	@Override
	public List<CarInfo> qryAllDoces(Map<String, Object> param) {
		return null;
	}

}
