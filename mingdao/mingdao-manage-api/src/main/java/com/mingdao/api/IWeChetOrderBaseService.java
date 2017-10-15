package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.WeChatInfo;
import com.mingdao.domain.WeChatOrder;

/**
*
* <code>IWeChetOrderBaseService<code> <strong></strong>
* <p>

* <li>预约管理</li>
* </p>
* 
* @since
* @version 
* @author wushzh
*/
public interface IWeChetOrderBaseService {
	
	public WeChatOrder insertWeChatInfo(WeChatOrder order);

	public WeChatOrder updateWeChatInfo(WeChatOrder order, Long modifyUserId);

	public Pager<WeChatOrder> pageQueryWeChatInfoByCondition(Map<String, Object> param);

}
