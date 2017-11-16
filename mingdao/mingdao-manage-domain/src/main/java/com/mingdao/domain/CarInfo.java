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
	/**
	 * 所属客户
	 */
	private Long customerId;
	/**
	 * 车牌号码
	 */
	private String platNumber;
	/**
	 * 汽车价格
	 */
	private Double carPrice;
	/**
	 * 年检到期
	 */
	private Timestamp annualExpiration;
	/**
	 * 所有人地址
	 */
	private String addressOfPerson;
	/**
	 * 下次保养里程
	 */
	private Double nextServiceCyc;
	/**
	 * 车架号
	 */
	private String vin;
	/**
	 * 购车时间
	 */
	private Timestamp buyCarTime;
	/**
	 * 品牌
	 */
	private Long brandId;
	/**
	 * 保险公司
	 */
	private String insureCompany;
	/**
	 * 保险到期
	 */
	private Timestamp insureExpir;
	/**
	 * 上次里程
	 */
	private Double preCyc;
	/**
	 * 客户电话
	 */
	private String phone;

	public static final String ID = "id";
	public static final String CUSTOMERID = "customerId";
	public static final String PLATNUMBER = "platNumber";
	public static final String CARPRICE = "carPrice";
	public static final String ANNUALEXPIRATION = "annualExpiration";
	public static final String ADDRESSOFPERSON = "addressOfPerson";
	public static final String NEXTSERVICECYC = "nextServiceCyc";
	public static final String BUYCARTIME = "buyCarTime";
	public static final String BRANDID = "brandId";
	public static final String INSURECOMPANY = "insureCompany";
	public static final String INSUREEXPIR = "insureExpir";
	public static final String PRECYC = "preCyc";

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
