package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.CustType;

/**
 *
 * <code>ICustTypeBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午11:21:57
 * @author libinf
 */

public interface ICustTypeBaseService {

	public CustType insertCustType(CustType custtype);

	public CustType updateCustType(CustType custtype);

	public Pager<CustType> pageQueryCustTypeByCondition(Map<String, Object> param);


	public void deleteDocById(Long id);

}
