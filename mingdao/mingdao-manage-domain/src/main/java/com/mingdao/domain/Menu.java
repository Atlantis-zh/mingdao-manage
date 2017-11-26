package com.mingdao.domain;

/**
 *
 * <code>Menu<code> <strong></strong>
 * <p>
 * 说明：菜单注册
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月31日 上午11:20:01
 * @author libinf
 */

public class Menu extends SuperVO {

  private static final long serialVersionUID = -5977406820543630911L;
  /**
   * 主键
   */
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
   * 上级菜单
   */
  private Long parentId;
  /**
   * 是否末节菜单
   */
  private Boolean isLeafMenu;
  /**
   * 启用停用
   */
  private Integer status;

  public static final String ID = "id";
  public static final String CODE = "code";
  public static final String NAME = "name";
  public static final String PARENTID = "parentId";
  public static final String ISLEAFMENU = "isLeafMenu";
  public static final String STATUS = "status";

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

  public Boolean getIsLeafMenu() {
    return this.isLeafMenu;
  }

  public void setIsLeafMenu(Boolean isLeafMenu) {
    this.isLeafMenu = isLeafMenu;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Long getParentId() {
    return this.parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }
}
