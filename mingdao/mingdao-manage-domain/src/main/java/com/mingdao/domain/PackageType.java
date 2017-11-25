package com.mingdao.domain;

/**
 *
 * <code>PackageType<code> <strong></strong>
 * <p>
 * 说明：套餐类型
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午11:24:15
 * @author libinf
 */

public class PackageType extends SuperVO {

  private static final long serialVersionUID = 5093545743956651183L;
  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 套餐编码
   */
  private String code;
  /**
   * 套餐名称
   */
  private String name;
  /**
   * 套餐售价
   */
  private Double salePrice;
  /**
   * 总次数
   */
  private Integer totalCount;
  /**
   * 有效期
   */
  private Integer expire;
  /**
   * 有效期单位 年(1)， 月(2)， 日(3);
   */
  private Integer timeUnit;
  /**
   * 成本
   */
  private Double cost;
  /**
   * 共享到分店
   */
  private Boolean shareToBranch;
  /**
   * 来源 自有门店（1），总店共享（2）
   */
  private Integer source;
  /**
   * 状态 正常（1）、停用（2）
   */
  private Integer status;
  /**
   * 备注
   */
  private String memo;

  public static final String ID = "id";
  public static final String STOREID = "storeId";
  public static final String NAME = "name";
  public static final String SALEPRICE = "salePrice";
  public static final String COUNT = "count";
  public static final String EXPIRE = "expire";
  public static final String TIMEUNIT = "timeUnit";
  public static final String SHARETOBRANCH = "shareToBranch";
  public static final String SOURCE = "source";
  public static final String STATUS = "status";
  public static final String MEMO = "memo";

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

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSalePrice() {
    return this.salePrice;
  }

  public void setSalePrice(Double salePrice) {
    this.salePrice = salePrice;
  }


  public Integer getExpire() {
    return this.expire;
  }

  public void setExpire(Integer expire) {
    this.expire = expire;
  }

  public Integer getTimeUnit() {
    return this.timeUnit;
  }

  public void setTimeUnit(Integer timeUnit) {
    this.timeUnit = timeUnit;
  }

  public Boolean getShareToBranch() {
    return this.shareToBranch;
  }

  public void setShareToBranch(Boolean shareToBranch) {
    this.shareToBranch = shareToBranch;
  }

  public Integer getSource() {
    return this.source;
  }

  public void setSource(Integer source) {
    this.source = source;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Double getCost() {
    return this.cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getTotalCount() {
    return this.totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


}
