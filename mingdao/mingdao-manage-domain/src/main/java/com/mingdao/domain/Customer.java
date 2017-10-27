package com.mingdao.domain;

import com.mingdao.enumprop.Sex;
import com.mingdao.enumprop.Source;

/**
 *
 * <code>Customer<code> <strong></strong>
 * <p>
 * 说明：客户信息
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
	private String birthday;
	private String phone;
	private String identityId;
	private Source custSource;
	private Long custTypeId;
	private Boolean lpr;
	private Sex sex;
	private String address;

	public static final String ID = "id";
	public static final String STOREID = "storeId";
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String WXNICKNAME = "wxNickName";
	public static final String BIRTHDAY = "birthday";
	public static final String PHONE = "phone";
	public static final String IDENTITYID = "identityId";
	public static final String CUSTSOURCE = "custSource";
	public static final String CUSTTYPEID = "custTypeId";
	public static final String LPR = "lpr";
	public static final String SEX = "sex";
	public static final String ADDRESS = "address";
	public static final String SYSTEMTIME= "systemTime";



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

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
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

	public Source getCustSource() {
		return this.custSource;
	}

	public void setCustSource(Source custSource) {
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

}
