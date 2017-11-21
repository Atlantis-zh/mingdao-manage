package com.mingdao.domain;

/**
 *
 * <code>CustomerPointsExchangeRecord<code> <strong></strong>
 * <p>
 * 说明：客户积分兑换记录
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月21日 下午11:44:18
 * @author libin
 */

public class CustomerPointsExchangeRecord extends SuperVO {

  private static final long serialVersionUID = -5830371498611635938L;


  private Long id;
  /**
   * 客户积分主键
   */
  private Long custPointsId;
  /**
   * 会员卡
   */
  private Long memberShipId;
  /**
   * 兑换礼品
   */
  private Long exchangeGiftId;
  /**
   * 消耗积分
   */
  private Integer exchangePoints;
  /**
   * 兑换状态
   */
  private Integer status;
  /**
   * 兑换时间
   */
  private java.sql.Timestamp time;
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

  public Long getCustPointsId() {
    return this.custPointsId;
  }

  public void setCustPointsId(Long custPointsId) {
    this.custPointsId = custPointsId;
  }

  public Long getMemberShipId() {
    return this.memberShipId;
  }

  public void setMemberShipId(Long memberShipId) {
    this.memberShipId = memberShipId;
  }

  public Long getExchangeGiftId() {
    return this.exchangeGiftId;
  }

  public void setExchangeGiftId(Long exchangeGiftId) {
    this.exchangeGiftId = exchangeGiftId;
  }

  public Integer getExchangePoints() {
    return this.exchangePoints;
  }

  public void setExchangePoints(Integer exchangePoints) {
    this.exchangePoints = exchangePoints;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public java.sql.Timestamp getTime() {
    return this.time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }



}
