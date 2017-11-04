package com.mingdao.domain;

import com.mingdao.enumprop.Status;

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
	private String parentCode;
	private Boolean isLeafMenu;
	private Status status;
	private String path;
	private Long menuLevel;

	public static final String ID = "id";
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String PARENTID = "parentId";
	public static final String ISLEAFMENU = "isLeafMenu";
	public static final String STATUS = "status";

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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Boolean getIsLeafMenu() {
		return this.isLeafMenu;
	}

	public void setIsLeafMenu(Boolean isLeafMenu) {
		this.isLeafMenu = isLeafMenu;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Long menuLevel) {
		this.menuLevel = menuLevel;
	}
}
