package com.mingdao.domain;

/**
*
* <code>IWeChetInfoDao<code> <strong></strong>
* <p>

* <li>微信关注列表</li>
* </p>
* 
* @since
* @version 
* @author wushzh
*/

public class WeChatInfo extends SuperVO {

	private static final long serialVersionUID = -5101886125326986669L;

	private Long id;
	private String code;
	private String mnname;
	private Long storeId;
	
	private String tel;
	private String address;
	private boolean status;
	private String relationcust;
	private Sex sex;
	public String getMnname() {
		return mnname;
	}

	public void setMnname(String mnname) {
		this.mnname = mnname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRelationcust() {
		return relationcust;
	}

	public void setRelationcust(String relationcust) {
		this.relationcust = relationcust;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	private Long creator;
	private String createTime;
	private Long modifier;
	private String modifiedTime;

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

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getModifier() {
		return this.modifier;
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}

	public String getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
