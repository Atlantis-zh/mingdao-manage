package com.mingdao.api;

import java.util.Map;

/**
*
* <code>IWeChetBaseService<code> <strong></strong>
* <p>

* <li></li>
* </p>
* 
* @since
* @version 
* @author wushzh
*/

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.WeChatInfo;

public interface IWeChetBaseService {

	public WeChatInfo insertWeChatInfo(WeChatInfo weChatInfo);

	public WeChatInfo updateWeChatInfo(WeChatInfo weChatInfo, Long modifyUserId);

	public Pager<WeChatInfo> pageQueryWeChatInfoByCondition(Map<String, Object> param);
	
}
