package com.mingdao.api;

import java.util.Map;

import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.UserRoleRelation;

/**
 *
 * <code>IUserRoleRelationBaseServiceItf<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月24日 下午5:15:02
 * @author libinf
 */

public interface IUserRoleRelationBaseServiceItf {

	public UserRoleRelation insertUserRoleRelation(UserRoleRelation relation);

	public UserRoleRelation updateUserRoleRelation(UserRoleRelation relation, Long modifyUserId);

	public Pager<UserRoleRelation> pageQueryUserRoleRelaByCondition(Map<String, Object> param);

}
