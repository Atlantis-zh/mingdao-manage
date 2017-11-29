package com.mingdao.domain;

public class ServiceProductClassDTO extends SuperVO {

	  private static final long serialVersionUID = -861453484901531638L;

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
	   * 所属工时分类
	   */
	  private Long workTimeClassId;
	  
	  private String workTimeClassName;
	  
	  private String workTimeClassCode;
	  /**
	   * 上级分类
	   */
	  private Long parentId;
	  
	  private String parentName;
	  
	  public String getWorkTimeClassName() {
		return workTimeClassName;
	}

	public void setWorkTimeClassName(String workTimeClassName) {
		this.workTimeClassName = workTimeClassName;
	}

	public String getWorkTimeClassCode() {
		return workTimeClassCode;
	}

	public void setWorkTimeClassCode(String workTimeClassCode) {
		this.workTimeClassCode = workTimeClassCode;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}


	private String parentCode;

	  public static final String ID = "id";
	  public static final String STOREID = "storeId";
	  public static final String CODE = "code";
	  public static final String NAME = "name";
	  public static final String WORKTIMECLASSID = "workTimeClassId";

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

	  public Long getWorkTimeClassId() {
	    return this.workTimeClassId;
	  }

	  public void setWorkTimeClassId(Long workTimeClassId) {
	    this.workTimeClassId = workTimeClassId;
	  }

	  public Long getParentId() {
	    return this.parentId;
	  }

	  public void setParentId(Long parentId) {
	    this.parentId = parentId;
	  }

}
