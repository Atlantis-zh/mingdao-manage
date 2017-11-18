package com.mingdao.domain;

import com.mingdao.enumprop.MemberShipSource;
import com.mingdao.enumprop.Status;
import com.mingdao.enumprop.TimeUnit;

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
   * 套餐次数
   */
  private Integer count;
  /**
   * 有效期
   */
  private Integer expire;
  /**
   * 有效期单位
   */
  private TimeUnit timeUnit;
  /**
   * 成本
   */
  private Double cost;
  /**
   * 共享到分店
   */
  private Boolean shareToBranch;
  /**
   * 来源
   */
  private MemberShipSource source;
  /**
   * 状态
   */
  private Status status;
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

  public Integer getCount() {
    return this.count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getExpire() {
    return this.expire;
  }

  public void setExpire(Integer expire) {
    this.expire = expire;
  }

  public TimeUnit getTimeUnit() {
    return this.timeUnit;
  }

  public void setTimeUnit(TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
  }

  public Boolean getShareToBranch() {
    return this.shareToBranch;
  }

  public void setShareToBranch(Boolean shareToBranch) {
    this.shareToBranch = shareToBranch;
  }

  public MemberShipSource getSource() {
    return this.source;
  }

  public void setSource(MemberShipSource source) {
    this.source = source;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }


}
