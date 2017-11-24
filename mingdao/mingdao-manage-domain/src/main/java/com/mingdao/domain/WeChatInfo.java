package com.mingdao.domain;

/**
 *
 * <code>IWeChetInfoDao<code> <strong></strong>
 * <p>
 * 
 * <li>关注列表</li>
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
   * 关注状态
   */
  private Boolean followStatus;
  /**
   * 关注时间
   */
  private String followTime;
  /**
   * 关联客户
   */
  private Long customerId;


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

  public Boolean getFollowStatus() {
    return this.followStatus;
  }

  public void setFollowStatus(Boolean followStatus) {
    this.followStatus = followStatus;
  }

  public String getFollowTime() {
    return this.followTime;
  }

  public void setFollowTime(String followTime) {
    this.followTime = followTime;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }



}
