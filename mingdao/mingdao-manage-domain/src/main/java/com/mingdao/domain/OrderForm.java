package com.mingdao.domain;

/**
 *
 * <code>OrderForm<code> <strong></strong>
 * <p>
 * 说明：订单管理
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午10:08:35
 * @author libin
 */

public class OrderForm extends SuperVO {

  private static final long serialVersionUID = -1120052443970480562L;

  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 单据号
   */
  private String billNo;
  /**
   * 客户
   */
  private Long customerId;
  /**
   * 车辆信息
   */
  private Long carInfoId;
  /**
   * 维护顾问
   */
  private Long maintenancePsnId;
  /**
   * 合计金额
   */
  private Double totalMount;
  /**
   * 是否使用消费卡
   */
  private Boolean isUserCosumerCard;

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

  public String getBillNo() {
    return this.billNo;
  }

  public void setBillNo(String billNo) {
    this.billNo = billNo;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getCarInfoId() {
    return this.carInfoId;
  }

  public void setCarInfoId(Long carInfoId) {
    this.carInfoId = carInfoId;
  }

  public Long getMaintenancePsnId() {
    return this.maintenancePsnId;
  }

  public void setMaintenancePsnId(Long maintenancePsnId) {
    this.maintenancePsnId = maintenancePsnId;
  }

  public Double getTotalMount() {
    return this.totalMount;
  }

  public void setTotalMount(Double totalMount) {
    this.totalMount = totalMount;
  }

  public Boolean getIsUserCosumerCard() {
    return this.isUserCosumerCard;
  }

  public void setIsUserCosumerCard(Boolean isUserCosumerCard) {
    this.isUserCosumerCard = isUserCosumerCard;
  }



}
