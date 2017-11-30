package com.mingdao.domain;

import java.sql.Timestamp;

public class MemberShipRefDTO extends SuperVO {

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
	  
	  private String storeName;
	  
	  private String storeCode;
	  /**
	   * 客户
	   */
	  private Long customerId;
	  
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

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getPlatNumber() {
		return platNumber;
	}

	public void setPlatNumber(String platNumber) {
		this.platNumber = platNumber;
	}

	public Double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	public Timestamp getAnnualExpiration() {
		return annualExpiration;
	}

	public void setAnnualExpiration(Timestamp annualExpiration) {
		this.annualExpiration = annualExpiration;
	}

	public String getAddressOfPerson() {
		return addressOfPerson;
	}

	public void setAddressOfPerson(String addressOfPerson) {
		this.addressOfPerson = addressOfPerson;
	}

	public Double getNextServiceCyc() {
		return nextServiceCyc;
	}

	public void setNextServiceCyc(Double nextServiceCyc) {
		this.nextServiceCyc = nextServiceCyc;
	}

	public Timestamp getBuyCarTime() {
		return buyCarTime;
	}

	public void setBuyCarTime(Timestamp buyCarTime) {
		this.buyCarTime = buyCarTime;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getInsureCompany() {
		return insureCompany;
	}

	public void setInsureCompany(String insureCompany) {
		this.insureCompany = insureCompany;
	}

	public Timestamp getInsureExpir() {
		return insureExpir;
	}

	public void setInsureExpir(Timestamp insureExpir) {
		this.insureExpir = insureExpir;
	}

	public Double getPreCyc() {
		return preCyc;
	}

	public void setPreCyc(Double preCyc) {
		this.preCyc = preCyc;
	}

	private String custName;
	  
	  private String custPhone;
	  
	  /**
	   * 车辆信息
	   */
	  private Long carInfoId;
	  
	  /**
		 * 车牌号码
		 */
		private String platNumber;
		/**
		 * 汽车价格
		 */
		private Double carPrice;
		/**
		 * 年检到期
		 */
		private Timestamp annualExpiration;
		/**
		 * 所有人地址
		 */
		private String addressOfPerson;
		/**
		 * 下次保养里程
		 */
		private Double nextServiceCyc;
		/**
		 * 车架号
		 */
		private String vin;
		/**
		 * 购车时间
		 */
		private Timestamp buyCarTime;
		/**
		 * 品牌
		 */
		private Long brandId;
		/**
		 * 保险公司
		 */
		private String insureCompany;
		/**
		 * 保险到期
		 */
		private Timestamp insureExpir;
		/**
		 * 上次里程
		 */
		private Double preCyc;
		
	  /**
	   * 会员卡种
	   */
	  private Long memberShipCardId;
	  /**
	   * 计次套餐
	   */
	  private Long packageTypeId;
	  /**
	   * 现金
	   */
	  private Double crash;
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
	  /**
	   * 提成人员
	   */
	  private Long percentagePsnId;
	  /**
	   * 备注
	   */
	  private String memo;

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

	  public Long getMemberShipCardId() {
	    return this.memberShipCardId;
	  }

	  public void setMemberShipCardId(Long memberShipCardId) {
	    this.memberShipCardId = memberShipCardId;
	  }

	  public Long getPackageTypeId() {
	    return this.packageTypeId;
	  }

	  public void setPackageTypeId(Long packageTypeId) {
	    this.packageTypeId = packageTypeId;
	  }

	  public Double getCrash() {
	    return this.crash;
	  }

	  public void setCrash(Double crash) {
	    this.crash = crash;
	  }

	  public Integer getPoints() {
	    return this.points;
	  }

	  public void setPoints(Integer points) {
	    this.points = points;
	  }

	  public Double getRemaining() {
	    return this.remaining;
	  }

	  public void setRemaining(Double remaining) {
	    this.remaining = remaining;
	  }

	  public Integer getTotalRemainCount() {
	    return this.totalRemainCount;
	  }

	  public void setTotalRemainCount(Integer totalRemainCount) {
	    this.totalRemainCount = totalRemainCount;
	  }

	  public Long getPercentagePsnId() {
	    return this.percentagePsnId;
	  }

	  public void setPercentagePsnId(Long percentagePsnId) {
	    this.percentagePsnId = percentagePsnId;
	  }

	  public String getMemo() {
	    return this.memo;
	  }

	  public void setMemo(String memo) {
	    this.memo = memo;
	  }

	  public String getCardNo() {
	    return this.cardNo;
	  }

	  public void setCardNo(String cardNo) {
	    this.cardNo = cardNo;
	  }

}
