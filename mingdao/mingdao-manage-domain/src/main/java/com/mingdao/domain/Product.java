package com.mingdao.domain;

import com.mingdao.enumprop.Status;

/**
 *
 * <code>Product<code> <strong></strong>
 * <p>
 * 说明：商品
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午8:54:38
 * @author libin
 */

public class Product extends SuperVO {

  private static final long serialVersionUID = 6689541682735208854L;

  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
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

  /**
   * 商品分类
   */
  private Long productClassId;

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
  
  private ProductDTO dto;

  public ProductDTO getDto() {
	return dto;
}

public void setDto(ProductDTO dto) {
	this.dto = dto;
}

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
  
  public ProductDTO createDto() {
	  dto = new ProductDTO();
	  dto.setId(this.getId());
	  dto.setCode(this.getCode());
	  dto.setName(this.getName());
	  dto.setStoreId(this.getStoreId());
	  dto.setMncode(this.getMncode());
	  dto.setAdapteCarType(this.getAdapteCarType());
	  dto.setMeasdocId(this.getMeasdocId());
	  dto.setMemo(this.getMemo());
	  dto.setProductClassId(this.getProductClassId());
	  dto.setSalePrice(this.getSalePrice());
	  dto.setShareToBranch(this.getShareToBranch());
	  dto.setSpec(this.getSpec());
	  dto.setStatus(this.getStatus());
	return dto;
 }



}
