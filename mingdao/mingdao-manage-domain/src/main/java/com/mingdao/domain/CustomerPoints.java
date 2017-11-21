package com.mingdao.domain;

/**
 *
 * <code>CustomerPoints<code> <strong></strong>
 * <p>
 * 说明：客户积分
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月21日 下午10:53:53
 * @author libin
 */

public class CustomerPoints extends SuperVO {

  private static final long serialVersionUID = -2454761394557179365L;


  private Long id;
  /**
   * 客户
   */
  private Long customerId;
  /**
   * 门店
   */
  private Long storeId;
  /**
   * 积分
   */
  private Integer points;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getStoreId() {
    return this.storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public Integer getPoints() {
    return this.points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }



}
