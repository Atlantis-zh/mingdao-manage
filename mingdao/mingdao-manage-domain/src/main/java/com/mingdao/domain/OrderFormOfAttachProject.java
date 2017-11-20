package com.mingdao.domain;

/**
 *
 * <code>OrderFormOfAttachProject<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午2:28:07
 * @author libin
 */

public class OrderFormOfAttachProject extends SuperVO {

  private static final long serialVersionUID = -6344252557203167134L;

  private Long id;
  /**
   * 订单
   */
  private Long orderFormId;

  /**
   * 服务项目
   */
  private Long attachProjectId;

  /**
   * 单价
   */
  private Double price;

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

  public Long getAttachProjectId() {
    return this.attachProjectId;
  }

  public void setAttachProjectId(Long attachProjectId) {
    this.attachProjectId = attachProjectId;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
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
