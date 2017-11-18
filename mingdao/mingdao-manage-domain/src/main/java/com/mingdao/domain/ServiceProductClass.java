package com.mingdao.domain;

/**
 *
 * <code>ServiceProductClass<code> <strong></strong>
 * <p>
 * 说明：服务分类
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 下午1:13:30
 * @author libinf
 */

public class ServiceProductClass extends SuperVO {

  private static final long serialVersionUID = -861453484901531638L;

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
   * 所属门店
   */
  private Long workTimeClassId;
  /**
   * 上级分类
   */
  private Long parentId;

  public static final String ID = "id";
  public static final String STOREID = "storeId";
  public static final String CODE = "code";
  public static final String NAME = "name";
  public static final String WORKTIMECLASSID = "workTimeClassId";

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

  public Long getWorkTimeClassId() {
    return this.workTimeClassId;
  }

  public void setWorkTimeClassId(Long workTimeClassId) {
    this.workTimeClassId = workTimeClassId;
  }

  public Long getParentId() {
    return this.parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }


}
