package com.mingdao.domain;

/**
 *
 * <code>Measdoc<code> <strong></strong>
 * <p>
 * 说明：计量单位
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月23日 上午12:37:40
 * @author libinf
 */

public class Measdoc extends SuperVO {

	private static final long serialVersionUID = 3333818191733141503L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;

	public static final String ID = "id";
	public static final String CODE = "code";
	public static final String NAME = "name";

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

}
