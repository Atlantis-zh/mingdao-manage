package com.mingdao.domain;

import java.sql.Timestamp;

/**
 *
 * <code>Store<code> <strong></strong>
 * <p>
 * 说明：门店实体
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午10:57:03
 * @author libinf
 */

public class Store extends SuperVO {

	private static final long serialVersionUID = 2155405917909038177L;

	private Long id;
	private String code;
	private String name;
	private String tel1;
	private String tel2;
	private String tel3;
	private String address;
	private Boolean isWxShow;
	private Boolean isWxDefault;
	private Boolean isHeadStore;


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
	public String getTel1() {
		return this.tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return this.tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return this.tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getIsWxShow() {
		return this.isWxShow;
	}
	public void setIsWxShow(Boolean isWxShow) {
		this.isWxShow = isWxShow;
	}
	public Boolean getIsWxDefault() {
		return this.isWxDefault;
	}
	public void setIsWxDefault(Boolean isWxDefault) {
		this.isWxDefault = isWxDefault;
	}
	public Boolean getIsHeadStore() {
		return this.isHeadStore;
	}
	public void setIsHeadStore(Boolean isHeadStore) {
		this.isHeadStore = isHeadStore;
	}


	


}
