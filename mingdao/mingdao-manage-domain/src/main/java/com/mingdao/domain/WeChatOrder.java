package com.mingdao.domain;

import com.mingdao.enumprop.Source;
import com.mingdao.enumprop.OrderStatus;
import com.mingdao.enumprop.Sex;

/**
 *
 * <code>WeChatOrder<code> <strong></strong>
 * <p>
 * 
 * <li>预约管理</li>
 * </p>
 * 
 * @since
 * @version
 * @author wushzh
 */
public class WeChatOrder extends SuperVO {
	
	private static final long serialVersionUID = -3005949063603134227L;
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
	private Source orderresource;
	private String memo;
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

	public String getBillno() {
		return this.billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public Long getEmployee() {
		return this.employee;
	}

	public void setEmployee(Long employee) {
		this.employee = employee;
	}

	public Long getProject() {
		return this.project;
	}

	public void setProject(Long project) {
		this.project = project;
	}

	public String getEmplyeetime() {
		return this.emplyeetime;
	}

	public void setEmplyeetime(String emplyeetime) {
		this.emplyeetime = emplyeetime;
	}

	public String getPlatNumber() {
		return this.platNumber;
	}

	public void setPlatNumber(String platNumber) {
		this.platNumber = platNumber;
	}

	public Long getCust() {
		return this.cust;
	}

	public void setCust(Long cust) {
		this.cust = cust;
	}

	public Sex getSex() {
		return this.sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Source getOrderresource() {
		return this.orderresource;
	}

	public void setOrderresource(Source orderresource) {
		this.orderresource = orderresource;
	}


	public OrderStatus getStatus() {
		return this.status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}



}
