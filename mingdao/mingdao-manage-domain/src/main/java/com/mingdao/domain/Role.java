package com.mingdao.domain;

public class Role extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8945192045194575929L;
	
	private Long id;
	private String roleCode;
	private String roleName;
	private String roleMemo;
	private Long creator;
	private String createTime;
	private Long modifier;
	private String modifiedTime;
	
	public static final String ID="id";
	public static final String ROLECODE="roleCode";
	public static final String ROLENAME="roleName";
	public static final String ROLEMEMO="roleMemo";
	public static final String CREATOR="creator";
	public static final String CREATETIME="createTime";
	public static final String MODIFIER="modifier";
	public static final String MODIFIEDTIME="modifiedTime";
	
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
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getModifier() {
		return modifier;
	}
	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
