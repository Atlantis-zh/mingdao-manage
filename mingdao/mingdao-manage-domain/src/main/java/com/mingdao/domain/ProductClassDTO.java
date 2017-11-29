package com.mingdao.domain;

public class ProductClassDTO extends SuperVO {

	  private static final long serialVersionUID = 5754691506842458211L;

	  private Long id;
	  /**
	   * 所属门店
	   */
	  private Long storeId;
	  
	  private String storeCode;
	  
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

	  /**
	   * 编码
	   */
	  private String code;
	  /**
	   * 名称
	   */
	  private String name;
	  /**
	   * 上级分类
	   */
	  private Long parentId;
	  
	  /**
	   * 编码
	   */
	  private String parentCode;
	  public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	   * 名称
	   */
	  private String parentName;

	  public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

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

	  public Long getParentId() {
	    return this.parentId;
	  }

	  public void setParentId(Long parentId) {
	    this.parentId = parentId;
	  }

	  public Long getStoreId() {
	    return this.storeId;
	  }

	  public void setStoreId(Long storeId) {
	    this.storeId = storeId;
	  }

}
