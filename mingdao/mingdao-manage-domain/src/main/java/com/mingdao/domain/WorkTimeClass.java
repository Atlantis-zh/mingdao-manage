package com.mingdao.domain;

/**
 *
 * <code>WorkTimeClass<code> <strong></strong>
 * <p>
 * 说明：工时分类
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月22日 下午8:26:12
 * @author libinf
 */

public class WorkTimeClass extends SuperVO {

	private static final long serialVersionUID = -146971081897573005L;

	private Long id;
	private Long storeId;
	private String code;
	private String name;
	private Integer minutes;
	private Double price;
	private Boolean isDefault;

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

	public Integer getMinutes() {
		return this.minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

}
