package com.mingdao.domain;

import java.io.Serializable;

public class SuperVO implements Serializable{
	private Long creator;
	private java.sql.Timestamp createTime;
	private Long modifier;
	private java.sql.Timestamp modifiedTime;

	public Long getCreator() {
        return creator;
    }

	public void setCreator(Long creator) {
        this.creator = creator;
    }

	public Long getModifier() {
        return modifier;
    }

	public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public java.sql.Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(java.sql.Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


}
