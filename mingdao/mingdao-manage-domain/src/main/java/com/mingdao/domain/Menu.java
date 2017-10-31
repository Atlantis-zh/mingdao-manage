package com.mingdao.domain;

/**
 *
 * <code>Menu<code> <strong></strong>
 * <p>
 * 说明：菜单注册
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月31日 上午11:20:01
 * @author libinf
 */

public class Menu extends SuperVO {

	private static final long serialVersionUID = -5977406820543630911L;

	private Long id;
	private String code;
	private String name;
	private Long parentId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
