package com.mingdao.domain;

public class WorkTimeClassDTO extends SuperVO {

	  private static final long serialVersionUID = -146971081897573005L;

	  private Long id;
	  /**
	   * 所属门店
	   */
	  private Long storeId;
	  
	  private String storeCode;
	  
	  
	  /**
	   * 编码
	   */
	  private String code;
	  /**
	   * 名称
	   */
	  private String name;
	  /**
	   * 分钟
	   */
	  private Integer minutes;
	  /**
	   * 金额
	   */
	  private Double price;
	  /**
	   * 是否默认
	   */
	  private Boolean isDefault;

	  public static final String ID = "id";
	  public static final String STOREID = "storeId";
	  public static final String CODE = "code";
	  public static final String NAME = "name";
	  public static final String MINUTES = "minutes";
	  public static final String PRICE = "price";
	  public static final String ISDEFAULT = "isDefault";


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

	  public Integer getMinutes() {
	    return this.minutes;
	  }

	  public void setMinutes(Integer minutes) {
	    this.minutes = minutes;
	  }

	  public Double getPrice() {
	    return this.price;
	  }

	  public void setPrice(Double price) {
	    this.price = price;
	  }

	  public Boolean getIsDefault() {
	    return this.isDefault;
	  }

	  public void setIsDefault(Boolean isDefault) {
	    this.isDefault = isDefault;
	  }
	  
	  public String getStoreCode() {
			return storeCode;
		}

		public void setStoreCode(String storeCode) {
			this.storeCode = storeCode;
		}

		private String storeName;
		  public String getStoreName() {
			return storeName;
		}

		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
}
