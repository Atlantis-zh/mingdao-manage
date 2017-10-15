package com.mingdao.domain;

import com.mingdao.enumprop.OrderResource;
import com.mingdao.enumprop.Sex;

/**
*
* <code>WeChatOrder<code> <strong></strong>
* <p>

* <li>预约管理</li>
* </p>
* 
* @since
* @version 
* @author wushzh
*/
public class WeChatOrder extends SuperVO {
	
	private Long id;
	private String code;
	private String name;
	private Long storeId;
	private String billno;
	private Long employee;
	private Long project;
	private String emplyeetime;
	private String platNumber;
	private Long cust;
	private Sex sex;
	private String tel;
	private OrderResource orderresource;
	private String meno;
	private OrderStatus status;

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

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}


}
