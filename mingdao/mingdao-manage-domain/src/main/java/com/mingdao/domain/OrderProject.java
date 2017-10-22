package com.mingdao.domain;

import com.mingdao.enumprop.OrderStatus;
import com.mingdao.enumprop.Source;

/**
 *
 * <code>WeChatOrder<code> <strong></strong>
 * <p>
 * 
 * <li>预约项目订单实体定义</li>
 * </p>
 * 
 * @since
 * @version
 * @author libinf
 */
public class OrderProject extends SuperVO {
	
	private static final long serialVersionUID = -3005949063603134227L;
	private Long id;
	private Long storeId;
	private String billno;
	private Long orderUserId;
	private Long serviceProjectId;
	private String orderTime;
	private String carNo;
	private Long customerId;
	private Source source;
	private String memo;
	private OrderStatus status;

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

	public String getBillno() {
		return this.billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public Long getOrderUserId() {
		return this.orderUserId;
	}

	public void setOrderUserId(Long orderUserId) {
		this.orderUserId = orderUserId;
	}

	public Long getServiceProjectId() {
		return this.serviceProjectId;
	}

	public void setServiceProjectId(Long serviceProjectId) {
		this.serviceProjectId = serviceProjectId;
	}

	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getCarNo() {
		return this.carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public OrderStatus getStatus() {
		return this.status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}



}
