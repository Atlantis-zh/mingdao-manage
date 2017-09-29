package com.mingdao.domain;

/**
 *
 * <code>PackageProject<code> <strong></strong>
 * <p>
 * 说明：套餐项目，价格问题需要处理 一致性保障
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午1:58:07
 * @author libinf
 */

public class PackageProject extends SuperVO{
	
	private static final long serialVersionUID = 8282430932091772169L;
	private Long id;
	private Long pkgTypeId;
	private Long pkgItemId;
	private Integer serviceCount;
	private Double price;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPkgTypeId() {
		return this.pkgTypeId;
	}

	public void setPkgTypeId(Long pkgTypeId) {
		this.pkgTypeId = pkgTypeId;
	}

	public Long getPkgItemId() {
		return this.pkgItemId;
	}

	public void setPkgItemId(Long pkgItemId) {
		this.pkgItemId = pkgItemId;
	}

	public Integer getServiceCount() {
		return this.serviceCount;
	}

	public void setServiceCount(Integer serviceCount) {
		this.serviceCount = serviceCount;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



}
