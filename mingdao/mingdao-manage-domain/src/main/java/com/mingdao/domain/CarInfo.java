package com.mingdao.domain;

import java.sql.Timestamp;

/**
 *
 * <code>CarInfo<code> <strong></strong>
 * <p>
 * 说明：车辆信息
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月15日 下午1:50:40
 * @author libinf
 */

public class CarInfo extends SuperVO {

	private static final long serialVersionUID = 209665535665458871L;

	private Long id;
	private Long customerId;
	private String platNumber;
	private Double carPrice;
	private Timestamp annualExpiration;
	private String addressOfPerson;
	private Double nextServiceCyc;
	private String vin;
	private Timestamp buyCarTime;
	private Long brandId;
	private String insureCompany;
	private Timestamp insureExpir;
	private Double preCyc;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPlatNumber() {
		return this.platNumber;
	}

	public void setPlatNumber(String platNumber) {
		this.platNumber = platNumber;
	}

	public Double getCarPrice() {
		return this.carPrice;
	}

	public void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	public Timestamp getAnnualExpiration() {
		return this.annualExpiration;
	}

	public void setAnnualExpiration(Timestamp annualExpiration) {
		this.annualExpiration = annualExpiration;
	}

	public String getAddressOfPerson() {
		return this.addressOfPerson;
	}

	public void setAddressOfPerson(String addressOfPerson) {
		this.addressOfPerson = addressOfPerson;
	}

	public Double getNextServiceCyc() {
		return this.nextServiceCyc;
	}

	public void setNextServiceCyc(Double nextServiceCyc) {
		this.nextServiceCyc = nextServiceCyc;
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Timestamp getBuyCarTime() {
		return this.buyCarTime;
	}

	public void setBuyCarTime(Timestamp buyCarTime) {
		this.buyCarTime = buyCarTime;
	}

	public Long getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getInsureCompany() {
		return this.insureCompany;
	}

	public void setInsureCompany(String insureCompany) {
		this.insureCompany = insureCompany;
	}

	public Timestamp getInsureExpir() {
		return this.insureExpir;
	}

	public void setInsureExpir(Timestamp insureExpir) {
		this.insureExpir = insureExpir;
	}

	public Double getPreCyc() {
		return this.preCyc;
	}

	public void setPreCyc(Double preCyc) {
		this.preCyc = preCyc;
	}



}
