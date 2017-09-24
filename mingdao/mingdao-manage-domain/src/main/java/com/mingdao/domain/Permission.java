package com.mingdao.domain;

public class Permission extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1194971530318803102L;

	private Long id;
	private String perssionCode;
	private String perssionName;
	private String perssionMemo;
	private Long creator;
	private String createTime;
	private Long modifier;
	private String modifiedTime;
	
	public static final String ID="id";
	public static final String PERSSIONCODE="perssionCode";
	public static final String PERSSIONNAME="perssionName";
	public static final String PERSSIONMEMO="perssionMemo";
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
	public String getPerssionCode() {
		return perssionCode;
	}
	public void setPerssionCode(String perssionCode) {
		this.perssionCode = perssionCode;
	}
	public String getPerssionName() {
		return perssionName;
	}
	public void setPerssionName(String perssionName) {
		this.perssionName = perssionName;
	}
	public String getPerssionMemo() {
		return perssionMemo;
	}
	public void setPerssionMemo(String perssionMemo) {
		this.perssionMemo = perssionMemo;
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
	
}
