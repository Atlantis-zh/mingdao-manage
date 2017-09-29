package com.mingdao.domain;

/**
 *
 * <code>CustType<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午10:51:23
 * @author libinf
 */

public class CustType extends SuperVO {

	private static final long serialVersionUID = -5101886125326986669L;

	private Long id;
	private String code;
	private String name;
	private Long storeId;


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

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}



}
