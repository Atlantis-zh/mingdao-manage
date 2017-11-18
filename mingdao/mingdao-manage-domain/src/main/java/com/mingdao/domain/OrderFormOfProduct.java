package com.mingdao.domain;

/**
 *
 * <code>OrderFormOfProduct<code> <strong></strong>
 * <p>
 * 说明：商品订单
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午1:55:57
 * @author libin
 */

public class OrderFormOfProduct extends SuperVO {

  private static final long serialVersionUID = 4703597540765826848L;

  private Long id;
  /**
   * 订单
   */
  private Long orderFormId;
  /**
   * 商品
   */
  private Long productId;

  /**
   * 数量
   */
  private Integer num;
  /**
   * 折扣
   */
  private Double discount;
  /**
   * 金额
   */
  private Double cost;
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

  public Long getOrderFormId() {
    return this.orderFormId;
  }

  public void setOrderFormId(Long orderFormId) {
    this.orderFormId = orderFormId;
  }

  public Long getProductId() {
    return this.productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }


  public Integer getNum() {
    return this.num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public Double getDiscount() {
    return this.discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Double getCost() {
    return this.cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }



}
