package com.mingdao.domain;

import com.mingdao.enumprop.Sex;

/**
 *
 * <code>IWeChetInfoDao<code> <strong></strong>
 * <p>
 * 
 * <li>微信关注列表</li>
 * </p>
 * 
 * @since
 * @version
 * @author wushzh
 */

public class WeChatInfo extends SuperVO {

  private static final long serialVersionUID = -5101886125326986669L;

  private Long id;
  /**
   * 微信昵称
   */
  private String wxNickName;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 手机号
   */
  private String phone;
  /**
   * 地址
   */
  private String address;
  /**
   * 关注状态
   */
  private boolean followStatus;
  /**
   * 关注时间
   */
  private String followTime;
  /**
   * 关联客户
   */
  private String relationCustId;
  /**
   * 性别
   */
  private Sex sex;

  public static final String ID = "id";
  public static final String CODE = "code";
  public static final String MNNAME = "mnname";
  public static final String STOREID = "storeId";
  public static final String TEL = "tel";
  public static final String ADDRESS = "address";
  public static final String STATUS = "status";
  public static final String RELATIONCUST = "relationcust";
  public static final String SEX = "sex";

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getWxNickName() {
    return this.wxNickName;
  }

  public void setWxNickName(String wxNickName) {
    this.wxNickName = wxNickName;
  }

  public Long getStoreId() {
    return this.storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isFollowStatus() {
    return this.followStatus;
  }

  public void setFollowStatus(boolean followStatus) {
    this.followStatus = followStatus;
  }

  public String getFollowTime() {
    return this.followTime;
  }

  public void setFollowTime(String followTime) {
    this.followTime = followTime;
  }

  public String getRelationCustId() {
    return this.relationCustId;
  }

  public void setRelationCustId(String relationCustId) {
    this.relationCustId = relationCustId;
  }

  public Sex getSex() {
    return this.sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }



}
