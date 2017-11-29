package com.mingdao.domain;

/**
 *
 * <code>PackageProject<code> <strong></strong>
 * <p>
 * 说明：套餐项目，价格问题需要处理 一致性保障
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午1:58:07
 * @author libinf
 */

public class PackageProject extends SuperVO {

  private static final long serialVersionUID = 8282430932091772169L;
  private Long id;
  /**
   * 套餐项目 参照服务项目
   */
  private Long serviceProjectId;

  /**
   * 服务次数
   */
  private Integer serviceCount;

  public static final String ID = "id";
  public static final String PKGTYPEID = "pkgTypeId";
  public static final String SERVICEID = "serviceid";
  public static final String PKGITEMID = "pkgItemId";
  public static final String SERVICECOUNT = "serviceCount";

  public static final String PRICE = "price";


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getServiceCount() {
    return this.serviceCount;
  }

  public void setServiceCount(Integer serviceCount) {
    this.serviceCount = serviceCount;
  }


  public Long getServiceProjectId() {
    return this.serviceProjectId;
  }

  public void setServiceProjectId(Long serviceProjectId) {
    this.serviceProjectId = serviceProjectId;
  }

  /**
   * 卡号
   */
  private String cardNo;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 客户
   */
  private Long customerId;
  /**
   * 车辆信息
   */
  private Long carInfoId;
  /**
   * 会员卡种
   */
  private Long memberShipCardId;
  /**
   * 计次套餐
   */
  private Long packageTypeId;
  /**
   * 现金
   */
  private Double crash;
  /**
   * 积分
   */
  private Integer points;
  /**
   * 余额
   */
  private Double remaining;
  /**
   * 总剩余次数
   */
  private Integer totalRemainCount;
  /**
   * 提成人员
   */
  private Long percentagePsnId;
  /**
   * 备注
   */
  private String memo;


  public Long getStoreId() {
    return this.storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
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

  public Long getMemberShipCardId() {
    return this.memberShipCardId;
  }

  public void setMemberShipCardId(Long memberShipCardId) {
    this.memberShipCardId = memberShipCardId;
  }

  public Long getPackageTypeId() {
    return this.packageTypeId;
  }

  public void setPackageTypeId(Long packageTypeId) {
    this.packageTypeId = packageTypeId;
  }

  public Double getCrash() {
    return this.crash;
  }

  public void setCrash(Double crash) {
    this.crash = crash;
  }

  public Integer getPoints() {
    return this.points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public Double getRemaining() {
    return this.remaining;
  }

  public void setRemaining(Double remaining) {
    this.remaining = remaining;
  }

  public Integer getTotalRemainCount() {
    return this.totalRemainCount;
  }

  public void setTotalRemainCount(Integer totalRemainCount) {
    this.totalRemainCount = totalRemainCount;
  }

  public Long getPercentagePsnId() {
    return this.percentagePsnId;
  }

  public void setPercentagePsnId(Long percentagePsnId) {
    this.percentagePsnId = percentagePsnId;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getCardNo() {
    return this.cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
  }



}
