package com.mingdao.domain;

import com.mingdao.enumprop.Status;

public class ProductDTO extends SuperVO {

	  private static final long serialVersionUID = 6689541682735208854L;

	  private Long id;
	  /**
	   * 所属门店
	   */
	  private Long storeId;
	  
     private String storeCode;
	  
	
	  /**
	   * 商品编码
	   */
	  private String code;
	  /**
	   * 商品名称
	   */
	  private String name;
	  /**
	   * 助记码
	   */
	  private String mncode;
	  /**
	   * 规格型号
	   */
	  private String spec;

	  /**
	   * 销售价格
	   */
	  private Double salePrice;

	  /**
	   * 计量单位
	   */
	  private Long measdocId;
	  
	  private String measdocName;
	  
	  private String measdocCode;
	  
	  public String getMeasdocName() {
		return measdocName;
	}

	public void setMeasdocName(String measdocName) {
		this.measdocName = measdocName;
	}

	public String getMeasdocCode() {
		return measdocCode;
	}

	public void setMeasdocCode(String measdocCode) {
		this.measdocCode = measdocCode;
	}

	/**
	   * 商品分类
	   */
	  private Long productClassId;
	  
	  /**
	   * 编码
	   */
	  private String productClassCode;
	  public String getProductClassCode() {
		return productClassCode;
	}

	public void setProductClassCode(String productClassCode) {
		this.productClassCode = productClassCode;
	}

	/**
	   * 名称
	   */
	  private String productClassName;

	  public String getProductClassName() {
		return productClassName;
	}

	public void setProductClassName(String productClassName) {
		this.productClassName = productClassName;
	}

	  /**
	   * 适用车型
	   */
	  private String adapteCarType;

	  /**
	   * 是否共享
	   */
	  private Boolean shareToBranch;

	  /**
	   * 备注
	   */
	  private String memo;

	  /**
	   * 状态 1启用 2停用 0未启用
	   */
	  private Status status;

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

	  public String getMncode() {
	    return this.mncode;
	  }

	  public void setMncode(String mncode) {
	    this.mncode = mncode;
	  }

	  public String getSpec() {
	    return this.spec;
	  }

	  public void setSpec(String spec) {
	    this.spec = spec;
	  }

	  public Double getSalePrice() {
	    return this.salePrice;
	  }

	  public void setSalePrice(Double salePrice) {
	    this.salePrice = salePrice;
	  }

	  public Long getMeasdocId() {
	    return this.measdocId;
	  }

	  public void setMeasdocId(Long measdocId) {
	    this.measdocId = measdocId;
	  }

	  public Long getProductClassId() {
	    return this.productClassId;
	  }

	  public void setProductClassId(Long productClassId) {
	    this.productClassId = productClassId;
	  }

	  public String getAdapteCarType() {
	    return this.adapteCarType;
	  }

	  public void setAdapteCarType(String adapteCarType) {
	    this.adapteCarType = adapteCarType;
	  }

	  public Boolean getShareToBranch() {
	    return this.shareToBranch;
	  }

	  public void setShareToBranch(Boolean shareToBranch) {
	    this.shareToBranch = shareToBranch;
	  }

	  public String getMemo() {
	    return this.memo;
	  }

	  public void setMemo(String memo) {
	    this.memo = memo;
	  }

	  public Status getStatus() {
	    return this.status;
	  }

	  public void setStatus(Status status) {
	    this.status = status;
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
