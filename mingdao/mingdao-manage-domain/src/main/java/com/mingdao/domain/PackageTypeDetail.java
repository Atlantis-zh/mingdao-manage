package com.mingdao.domain;

public class PackageTypeDetail extends SuperVO {

	  private static final long serialVersionUID = 8282430932091772169L;
	  private Long id;
	  /**
	   * 套餐类型
	   */
	  private Long pkgTypeId;
	  /**
	   * 套餐项目 参照服务项目
	   */
	  private Long serviceProjectId;
	  
	  private String serviceProjectName;
	  
	  private String serviceProjectCode;

	  /**
	   * 服务次数
	   */
	  private Integer serviceCount;
	  
	  private Double salePrice;
	  
	  public String getServiceProjectName() {
		return serviceProjectName;
	}

	public void setServiceProjectName(String serviceProjectName) {
		this.serviceProjectName = serviceProjectName;
	}

	public String getServiceProjectCode() {
		return serviceProjectCode;
	}

	public void setServiceProjectCode(String serviceProjectCode) {
		this.serviceProjectCode = serviceProjectCode;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	private Double total;

	  public static final String ID = "id";
	  public static final String PKGTYPEID = "pkgTypeId";
	  public static final String SERVICEID = "serviceid";
	  public static final String PKGITEMID = "pkgItemId";
	  public static final String SERVICECOUNT = "serviceCount";

	  public static final String PRICE = "price";


	  public Long getId() {
	    return this.id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public Long getPkgTypeId() {
	    return this.pkgTypeId;
	  }

	  public void setPkgTypeId(Long pkgTypeId) {
	    this.pkgTypeId = pkgTypeId;
	  }


	  public Integer getServiceCount() {
	    return this.serviceCount;
	  }

	  public void setServiceCount(Integer serviceCount) {
	    this.serviceCount = serviceCount;
	  }


	  public Long getServiceProjectId() {
	    return this.serviceProjectId;
	  }

	  public void setServiceProjectId(Long serviceProjectId) {
	    this.serviceProjectId = serviceProjectId;
	  }

}
