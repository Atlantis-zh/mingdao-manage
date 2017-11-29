package com.mingdao.domain;

/**
 *
 * <code>WorkTimeClass<code> <strong></strong>
 * <p>
 * 说明：工时分类
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月22日 下午8:26:12
 * @author libinf
 */

public class WorkTimeClass extends SuperVO {

  private static final long serialVersionUID = -146971081897573005L;

  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
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
  
  private WorkTimeClassDTO dto;


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
  
  public WorkTimeClassDTO getDto() {
	return dto;
  }

  public void setDto(WorkTimeClassDTO dto) {
	this.dto = dto;
  }
  
  public WorkTimeClassDTO createDto() {
	  dto = new WorkTimeClassDTO();
	  dto.setId(this.getId());
	  dto.setCode(this.getCode());
	  dto.setName(this.getName());
	  dto.setStoreId(this.getStoreId());
	  dto.setIsDefault(this.getIsDefault());
	  dto.setMinutes(this.getMinutes());
	  dto.setPrice(this.getPrice());
	return dto;
 }

}
