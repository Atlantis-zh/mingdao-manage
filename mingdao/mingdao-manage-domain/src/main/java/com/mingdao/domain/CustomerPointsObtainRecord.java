package com.mingdao.domain;

/**
 *
 * <code>CustomerPointsObtainRecord<code> <strong></strong>
 * <p>
 * 说明：客户积分获取记录
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月21日 下午11:23:59
 * @author libin
 */

public class CustomerPointsObtainRecord extends SuperVO {

  private static final long serialVersionUID = 3176656236076676841L;

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
   * 积分
   */
  private Integer points;
  /**
   * 积分时间
   */
  private java.sql.Timestamp time;
  /**
   * 积分方式 1办卡赠送，2消费赠送，3签到赠送
   */
  private Integer ponitsMethod;
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

  public Integer getPoints() {
    return this.points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public java.sql.Timestamp getTime() {
    return this.time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }

  public Integer getPonitsMethod() {
    return this.ponitsMethod;
  }

  public void setPonitsMethod(Integer ponitsMethod) {
    this.ponitsMethod = ponitsMethod;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }



}
