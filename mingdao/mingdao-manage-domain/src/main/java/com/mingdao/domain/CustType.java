package com.mingdao.domain;

/**
 *
 * <code>CustType<code> <strong></strong>
 * <p>
 * 说明：客户分类
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午10:51:23
 * @author libinf
 */

public class CustType extends SuperVO {

  private static final long serialVersionUID = -5101886125326986669L;

  private Long id;
  /**
   * 编码
   */
  private String code;
  /**
   * 名称
   */
  private String name;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 上级分类
   */
  private Long parentId;

  public static final String ID = "id";
  public static final String CODE = "code";
  public static final String NAME = "name";

  public static final String STOREID = "storeId";

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

  public Long getStoreId() {
    return this.storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public Long getParentId() {
    return this.parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

}
