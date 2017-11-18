package com.mingdao.domain;

/**
 *
 * <code>MemShipCardDiscount<code> <strong></strong>
 * <p>
 * 说明：会员卡折扣设置
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午10:10:21
 * @author libin
 */

public class MemShipCardDiscount extends SuperVO {

  private static final long serialVersionUID = 4498336953011888750L;

  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 会员卡卡种
   */
  private Long memberShipCardId;
  /**
   * 服务项目
   */
  private Long serviceProjectId;
  /**
   * 折扣
   */
  private Double discount;
  /**
   * 会员价
   */
  private Double memberShipPrice;
  /**
   * 商品
   */
  private Long productId;
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

  public Long getMemberShipCardId() {
    return this.memberShipCardId;
  }

  public void setMemberShipCardId(Long memberShipCardId) {
    this.memberShipCardId = memberShipCardId;
  }

  public Long getServiceProjectId() {
    return this.serviceProjectId;
  }

  public void setServiceProjectId(Long serviceProjectId) {
    this.serviceProjectId = serviceProjectId;
  }

  public Double getDiscount() {
    return this.discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Double getMemberShipPrice() {
    return this.memberShipPrice;
  }

  public void setMemberShipPrice(Double memberShipPrice) {
    this.memberShipPrice = memberShipPrice;
  }

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }



}
