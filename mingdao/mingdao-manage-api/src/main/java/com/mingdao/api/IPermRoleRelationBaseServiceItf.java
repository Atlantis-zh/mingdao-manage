package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.PermRoleRelation;

/**
 *
 * <code>IPermRoleRelationBaseServiceItf<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月24日 下午5:42:46
 * @author libinf
 */

public interface IPermRoleRelationBaseServiceItf {

	public PermRoleRelation insertPermRoleRela(PermRoleRelation relation);

	public PermRoleRelation updatePermRoleRela(PermRoleRelation relation, Long modifyUserId);

	public Pager<PermRoleRelation> pageQueryPermRoleRelaByCondition(Map<String, Object> param);

}
