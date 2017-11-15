package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.MemberShipCard;

/**
 *
 * <code>IMemberShipCardBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午11:16:32
 * @author libinf
 */

public interface IMemberShipCardBaseService {

	public MemberShipCard insertMemShipCard(MemberShipCard msc);

	public MemberShipCard updateMemShipCard(MemberShipCard msc);

	public Pager<MemberShipCard> pageQueryMemShipCardByCondition(Map<String, Object> param);

	public void deleteMemShipCard(long id);

}
