package com.mingdao.domain;

/**
 *
 * <code>PermRoleRelation<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月24日 下午5:21:44
 * @author libinf
 */

public class PermRoleRelation  extends SuperVO{

	private static final long serialVersionUID = 1349672910967428196L;
	
	private Long id;
	private Long permissionId;
	private Long roleId;
	private Long creator;
	private String createTime;
	private Long modifier;
	private String modifiedTime;

	public static final String ID = "id";
	public static final String PERMISSIONID = "permissionId";
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

	public Long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
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
