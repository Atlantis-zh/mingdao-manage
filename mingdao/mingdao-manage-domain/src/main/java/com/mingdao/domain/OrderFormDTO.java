package com.mingdao.domain;

public class OrderFormDTO extends SuperVO {

	  private static final long serialVersionUID = -1120052443970480562L;

	  private Long id;
	  /**
	   * 所属门店
	   */
	  private Long storeId;
	  
	  private String storeName;
	  
	  private String storeCode;
	  /**
	   * 单据号
	   */
	  private String billNo;
	  /**
	   * 客户
	   */
	  private Long customerId;
	  private String customerCode;
	  private String customerName;
	  
	  /**
	   * 会员卡号
	   */
	  private Long memberShipId;
	  private String cardNo;
	  /**
	   * 车辆信息
	   */
	  private Long carInfoId;
	  private String carInfoNO;
	  /**
	   * 维护顾问
	   */
	  private Long maintenancePsnId;
	  public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getMemberShipId() {
		return memberShipId;
	}

	public void setMemberShipId(Long memberShipId) {
		this.memberShipId = memberShipId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCarInfoNO() {
		return carInfoNO;
	}

	public void setCarInfoNO(String carInfoNO) {
		this.carInfoNO = carInfoNO;
	}

	/**
	   * 合计金额
	   */
	  private Double totalMount;
	  /**
	   * 是否使用消费卡
	   */
	  private Boolean isUserCosumerCard;

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

	  public String getBillNo() {
	    return this.billNo;
	  }

	  public void setBillNo(String billNo) {
	    this.billNo = billNo;
	  }

	  public Long getCustomerId() {
	    return this.customerId;
	  }

	  public void setCustomerId(Long customerId) {
	    this.customerId = customerId;
	  }

	  public Long getCarInfoId() {
	    return this.carInfoId;
	  }

	  public void setCarInfoId(Long carInfoId) {
	    this.carInfoId = carInfoId;
	  }

	  public Long getMaintenancePsnId() {
	    return this.maintenancePsnId;
	  }

	  public void setMaintenancePsnId(Long maintenancePsnId) {
	    this.maintenancePsnId = maintenancePsnId;
	  }

	  public Double getTotalMount() {
	    return this.totalMount;
	  }

	  public void setTotalMount(Double totalMount) {
	    this.totalMount = totalMount;
	  }

	  public Boolean getIsUserCosumerCard() {
	    return this.isUserCosumerCard;
	  }

	  public void setIsUserCosumerCard(Boolean isUserCosumerCard) {
	    this.isUserCosumerCard = isUserCosumerCard;
	  }

}
