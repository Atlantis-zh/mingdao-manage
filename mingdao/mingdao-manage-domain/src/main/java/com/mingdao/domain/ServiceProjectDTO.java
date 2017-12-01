package com.mingdao.domain;

public class ServiceProjectDTO  extends SuperVO {

	  private static final long serialVersionUID = 5882267996069029800L;
	  private Long id;
	  /**
	   * 所属门店
	   */
	  private Long storeId;
	  
     private String storeCode;
	  


	 private String storeName;

	  /**
	   * 编码
	   */
	  private String code;
	  /**
	   * 名称
	   */
	  private String name;
	  /**
	   * 规格
	   */
	  private String spec;
	  /**
	   * 成本
	   */
	  private Double cost;
	  /**
	   * 工时数
	   */
	  private Integer workHours;
	  /**
	   * 销售价格
	   */
	  private Double salePrice;
	  /**
	   * 是否自助项目
	   */
	  private Boolean isSelfHelp;
	  /**
	   * 单位
	   */
	  private String unit;
	  /**
	   * 所属分类
	   */
	  private Long serProdClassId;
	  
	  private String serProdClassICode;
	  


	  public String getSerProdClassICode() {
		return serProdClassICode;
	}

	public void setSerProdClassICode(String serProdClassICode) {
		this.serProdClassICode = serProdClassICode;
	}

	public String getSerProdClassIName() {
		return serProdClassIName;
	}

	public void setSerProdClassIName(String serProdClassIName) {
		this.serProdClassIName = serProdClassIName;
	}

	private String serProdClassIName;

	  public static final String ID = "id";
	  public static final String STOREID = "storeId";
	  public static final String CODE = "code";
	  public static final String NAME = "name";
	  public static final String SPEC = "spec";
	  public static final String COST = "cost";
	  public static final String WORKHOURS = "workHours";
	  public static final String SALEPRICE = "salePrice";
	  public static final String ISSELFHELP = "isSelfHelp";
	  public static final String UNIT = "unit";
	  public static final String SERPRODCLASSID = "serProdClassId";


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

	  public String getSpec() {
	    return this.spec;
	  }

	  public void setSpec(String spec) {
	    this.spec = spec;
	  }

	  public Double getCost() {
	    return this.cost;
	  }

	  public void setCost(Double cost) {
	    this.cost = cost;
	  }

	  public Integer getWorkHours() {
	    return this.workHours;
	  }

	  public void setWorkHours(Integer workHours) {
	    this.workHours = workHours;
	  }

	  public Double getSalePrice() {
	    return this.salePrice;
	  }

	  public void setSalePrice(Double salePrice) {
	    this.salePrice = salePrice;
	  }

	  public Boolean getIsSelfHelp() {
	    return this.isSelfHelp;
	  }

	  public void setIsSelfHelp(Boolean isSelfHelp) {
	    this.isSelfHelp = isSelfHelp;
	  }

	  public Long getSerProdClassId() {
	    return this.serProdClassId;
	  }

	  public void setSerProdClassId(Long serProdClassId) {
	    this.serProdClassId = serProdClassId;
	  }

	  public String getUnit() {
	    return unit;
	  }

	  public void setUnit(String unit) {
	    this.unit = unit;
	  }
	  
	  public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	
	  public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
