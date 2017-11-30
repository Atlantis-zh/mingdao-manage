package com.mingdao.domain;

public class MemberInfo extends SuperVO {

	  private static final long serialVersionUID = -4889307883072203606L;

	  private Long id;
	  /**
	   * 卡号
	   */
	  private String cardNo;
	  /**
	   * 所属门店
	   */
	  private Long storeId;
	  /**
	   * 客户
	   */
	  private Long customerId;
	  
	  /**
	   * 积分
	   */
	  private Integer points;
	  /**
	   * 余额
	   */
	  private Double remaining;
	  /**
	   * 总剩余次数
	   */
	  private Integer totalRemainCount;

	  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Double getRemaining() {
		return remaining;
	}

	public void setRemaining(Double remaining) {
		this.remaining = remaining;
	}

	public Integer getTotalRemainCount() {
		return totalRemainCount;
	}

	public void setTotalRemainCount(Integer totalRemainCount) {
		this.totalRemainCount = totalRemainCount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	   * 备注
	   */
	  private String memo;
}
