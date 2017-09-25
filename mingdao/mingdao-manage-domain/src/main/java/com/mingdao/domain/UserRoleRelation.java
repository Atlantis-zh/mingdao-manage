package com.mingdao.domain;

/**
 *
 * <code>UserRoleRelation<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年9月24日 下午4:58:16
 * @author libinf
 */

public class UserRoleRelation extends SuperVO{

	private static final long serialVersionUID = -8921738091360156193L;

	private Long id;
	private Long userId;
	private Long roleId;
	private Long creator;
	private String createTime;
	private Long modifier;
	private String modifiedTime;

	public static final String ID = "id";
	public static final String USERID = "userId";
	public static final String ROLEID = "roleId";
	public static final String CREATOR = "creator";
	public static final String CREARETIME = "createTime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedTime";
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return this.roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getModifier() {
		return this.modifier;
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	public String getModifiedTime() {
		return this.modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	

}
