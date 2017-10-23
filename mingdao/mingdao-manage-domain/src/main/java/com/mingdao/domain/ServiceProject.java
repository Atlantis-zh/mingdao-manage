package com.mingdao.domain;

/**
 *
 * <code>ServiceProject<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月22日 下午10:08:34
 * @author libinf
 */

public class ServiceProject extends SuperVO {

	private static final long serialVersionUID = 5882267996069029800L;
	private Long id;
	private Long storeId;
	private String code;
	private String name;
	private String spec;
	private Double cost;
	private Integer workHours;
	private Double salePrice;
	private Boolean isSelfHelp;
	private Long unit;
	private Long serProdClassId;

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

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getWorkHours() {
		return this.workHours;
	}

	public void setWorkHours(Integer workHours) {
		this.workHours = workHours;
	}

	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Boolean getIsSelfHelp() {
		return this.isSelfHelp;
	}

	public void setIsSelfHelp(Boolean isSelfHelp) {
		this.isSelfHelp = isSelfHelp;
	}

	public Long getUnit() {
		return this.unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}

	public Long getSerProdClassId() {
		return this.serProdClassId;
	}

	public void setSerProdClassId(Long serProdClassId) {
		this.serProdClassId = serProdClassId;
	}

}
