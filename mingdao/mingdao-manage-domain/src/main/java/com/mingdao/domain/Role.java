package com.mingdao.domain;

public class Role extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8945192045194575929L;
	
	private String roleId;
	private String roleCode;
	private String roleName;
	private String roleMemo;
	private String creator;
	private String createTime;
	private String modifier;
	private String modifiedTime;
	
	public static final String ROLE_ID="role_id";
	public static final String ROLE_CODE="role_code";
	public static final String ROLE_NAME="role_name";
	public static final String ROLE_MEMO="role_memo";
	public static final String CREATOR="creator";
	public static final String CREATETIME="createTime";
	public static final String MODIFIER="modifier";
	public static final String MODIFIEDTIME="modifiedTime";
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleMemo() {
		return roleMemo;
	}
	public void setRoleMemo(String roleMemo) {
		this.roleMemo = roleMemo;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
