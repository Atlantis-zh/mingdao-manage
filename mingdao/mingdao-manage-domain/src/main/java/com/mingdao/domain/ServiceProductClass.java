package com.mingdao.domain;

/**
 *
 * <code>ServiceProductClass<code> <strong></strong>
 * <p>
 * 说明：服务产品分类
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 下午1:13:30
 * @author libinf
 */

public class ServiceProductClass extends SuperVO {

	private static final long serialVersionUID = -861453484901531638L;

	private Long id;
	private Long storeId;
	private String code;
	private String name;
	private Long workTimeClassId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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

	public Long getWorkTimeClassId() {
		return this.workTimeClassId;
	}

	public void setWorkTimeClassId(Long workTimeClassId) {
		this.workTimeClassId = workTimeClassId;
	}


}
