package com.mingdao.domain;

/**
 *
 * <code>ProductClass<code> <strong></strong>
 * <p>
 * 说明：商品分类
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午6:25:51
 * @author libin
 */

public class ProductClass extends SuperVO {

  private static final long serialVersionUID = 5754691506842458211L;

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
   * 上级分类
   */
  private Long parentId;
  
  private ProductClassDTO dto;

  public ProductClassDTO getDto() {
	return dto;
}

public void setDto(ProductClassDTO dto) {
	this.dto = dto;
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
  
  public ProductClassDTO createDto() {
	  dto = new ProductClassDTO();
	  dto.setId(this.getId());
	  dto.setCode(this.getCode());
	  dto.setName(this.getName());
	  dto.setStoreId(this.getStoreId());
	  dto.setParentId(this.getParentId());
	return dto;
 }


}
