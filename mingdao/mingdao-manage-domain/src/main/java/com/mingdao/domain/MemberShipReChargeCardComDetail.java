package com.mingdao.domain;

/**
 *
 * <code>MemberShipReChargeCardComDetail<code> <strong></strong>
 * <p>
 * 说明：会员充值卡消费明细
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午1:18:52
 * @author libin
 */

public class MemberShipReChargeCardComDetail extends SuperVO {

  private static final long serialVersionUID = 8656417875578185149L;

  private Long id;


  /**
   * 会员卡
   */
  private Long memberShipId;
  /**
   * 订单
   */
  private Long orderFormId;

  /**
   * 消费金额
   */
  private Double cost;
  /**
   * 是否会员卡付款
   */
  private Boolean isMemCardPay;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMemberShipId() {
    return this.memberShipId;
  }

  public void setMemberShipId(Long memberShipId) {
    this.memberShipId = memberShipId;
  }

  public Long getOrderFormId() {
    return this.orderFormId;
  }

  public void setOrderFormId(Long orderFormId) {
    this.orderFormId = orderFormId;
  }

  public Double getCost() {
    return this.cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Boolean getIsMemCardPay() {
    return this.isMemCardPay;
  }

  public void setIsMemCardPay(Boolean isMemCardPay) {
    this.isMemCardPay = isMemCardPay;
  }



}
