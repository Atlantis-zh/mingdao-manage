package com.mingdao.domain;

/**
 *
 * <code>MemShipPackageItemDetail<code> <strong></strong>
 * <p>
 * 说明：会员套餐明细子表
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月19日 上午12:30:53
 * @author libin
 */

public class MemShipPackageProjectDetail extends SuperVO {

  private static final long serialVersionUID = 7821891399945819785L;
  private Long id;
  /**
   * 会员卡
   */
  private Long memberShipId;
  /**
   * 套餐项目
   */
  private Long packageProjectId;
  /**
   * 套餐类型
   */
  private Long packageTypeId;
  /**
   * 剩余服务次数
   */
  private Integer remainSerCount;

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

  public Long getPackageProjectId() {
    return this.packageProjectId;
  }

  public void setPackageProjectId(Long packageProjectId) {
    this.packageProjectId = packageProjectId;
  }

  public Long getPackageTypeId() {
    return this.packageTypeId;
  }

  public void setPackageTypeId(Long packageTypeId) {
    this.packageTypeId = packageTypeId;
  }

  public Integer getRemainSerCount() {
    return this.remainSerCount;
  }

  public void setRemainSerCount(Integer remainSerCount) {
    this.remainSerCount = remainSerCount;
  }



}
