package com.mingdao.domain;

/**
 *
 * <code>AttachProject<code> <strong></strong>
 * <p>
 * 说明：附加项目
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年11月18日 下午3:23:05
 * @author libin
 */

  public class AttachProject extends SuperVO {

  private static final long serialVersionUID = 3488754347753977156L;
  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 编码
   */
  private String code;
  /**
   * 名称
   */
  private String name;
  /**
   * 价格
   */
  private Double price;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Long getStoreId() {
    return this.storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }


}
