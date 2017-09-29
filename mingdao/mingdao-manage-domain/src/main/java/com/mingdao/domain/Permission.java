package com.mingdao.domain;

public class Permission extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1194971530318803102L;

	private Long id;
	private String permissionCode;
	private String permissionName;
	private String permissionMemo;

	
	public static final String ID="id";
	public static final String PERMISSIONCODE = "permissionCode";
	public static final String PERMISSIONNAME = "permissionName";
	public static final String PERMISSIONMEMO = "permissionMemo";
	public static final String CREATOR="creator";
	public static final String CREATETIME="createTime";
	public static final String MODIFIER="modifier";
	public static final String MODIFIEDTIME="modifiedTime";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getPermissionCode() {
		return this.permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionMemo() {
		return this.permissionMemo;
	}

	public void setPermissionMemo(String permissionMemo) {
		this.permissionMemo = permissionMemo;
	}


	
}
