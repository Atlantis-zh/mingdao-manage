package com.mingdao.domain;

import java.sql.Timestamp;

public class UserInfo extends  SuperVO{
	private static final long serialVersionUID = 8262248081835118056L;
	private Long id;
	private String passWord;
	private String userCode;
	private String userName;
	private String nickName;
	private String status;
	private String phone;
	private String email;
	private String shopId;


	
	public static final String ID="id";
	public static final String PASSWORD="passWord";
	public static final String USERCODE="userCode";
	public static final String USERNAME="userName";
	public static final String NICKNAME="nickName";
	public static final String STATUS="status";
	public static final String PHONE="phone";
	public static final String EMAIL="email";
	public static final String CREATOR="creator";
	public static final String CREARETIME="createTime";
	public static final String MODIFIER="modifier";
	public static final String MODIFIEDTIME="modifiedTime";
	public static final String SHOPID="shopId";
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}	
	
}
