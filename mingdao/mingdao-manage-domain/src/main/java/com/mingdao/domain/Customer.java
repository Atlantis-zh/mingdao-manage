package com.mingdao.domain;

import java.sql.Timestamp;

import com.mingdao.enumprop.CustomerSource;
import com.mingdao.enumprop.Sex;

/**
 *
 * <code>Customer<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午7:16:03
 * @author libinf
 */

public class Customer extends SuperVO {

	private static final long serialVersionUID = -4687082890840731804L;

	private Long id;
	private Long storeId;
	private String name;
	private String code;
	private String wxNickName;
	private Timestamp birthday;
	private String phone;
	private String identityId;
	private CustomerSource custSource;
	private Long custTypeId;
	private Boolean lpr;
	private Sex sex;
	private String address;
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
	private String creator;
	private String createTime;
	private String modifier;
	private String modifiedTime;

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWxNickName() {
		return this.wxNickName;
	}

	public void setWxNickName(String wxNickName) {
		this.wxNickName = wxNickName;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentityId() {
		return this.identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public CustomerSource getCustSource() {
		return this.custSource;
	}

	public void setCustSource(CustomerSource custSource) {
		this.custSource = custSource;
	}

	public Long getCustTypeId() {
		return this.custTypeId;
	}

	public void setCustTypeId(Long custTypeId) {
		this.custTypeId = custTypeId;
	}

	public Boolean getLpr() {
		return this.lpr;
	}

	public void setLpr(Boolean lpr) {
		this.lpr = lpr;
	}

	public Sex getSex() {
		return this.sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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
