package com.mingdao.domain;

/**
 *
 * <code>CustSource<code> <strong></strong>
 * <p>
 * 说明：客户来源
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午4:55:39
 * @author libin
 */

public class CustSource extends SuperVO {

  private static final long serialVersionUID = -3751135103110655037L;

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



}
