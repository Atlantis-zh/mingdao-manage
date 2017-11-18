package com.mingdao.domain;

/**
 *
 * <code>MemShipPackageConsumerDetail<code> <strong></strong>
 * <p>
 * 说明：会员套餐消费明细表
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午1:01:02
 * @author libin
 */

public class MemShipPackageConsumerDetail extends SuperVO {

  private static final long serialVersionUID = 7712880554267538540L;

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
   * 是否套餐付款
   */
  private Boolean isPackagePay;
  /**
   * 服务类型：维修项目=1,微信配件=2，附加项目=3
   */
  private Integer serviceType;

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

  public Boolean getIsPackagePay() {
    return this.isPackagePay;
  }

  public void setIsPackagePay(Boolean isPackagePay) {
    this.isPackagePay = isPackagePay;
  }

  public Integer getServiceType() {
    return this.serviceType;
  }

  public void setServiceType(Integer serviceType) {
    this.serviceType = serviceType;
  }



}
