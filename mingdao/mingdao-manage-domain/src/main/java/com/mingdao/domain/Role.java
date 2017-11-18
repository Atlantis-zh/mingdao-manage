package com.mingdao.domain;

/**
 * 
 *
 * <code>Role<code> <strong></strong>
 * <p>
 * 说明：角色
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午4:42:02
 * @author libin
 */

public class Role extends SuperVO {

  /**
   *
   */
  private static final long serialVersionUID = -8945192045194575929L;

  private Long id;
  /**
   * 角色编码
   */
  private String roleCode;
  /**
   * 角色名称
   */
  private String roleName;
  /**
   * 备注
   */
  private String roleMemo;


  public static final String ID = "id";
  public static final String ROLECODE = "roleCode";
  public static final String ROLENAME = "roleName";
  public static final String ROLEMEMO = "roleMemo";
  public static final String CREATOR = "creator";
  public static final String CREATETIME = "createTime";
  public static final String MODIFIER = "modifier";
  public static final String MODIFIEDTIME = "modifiedTime";

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleMemo() {
    return roleMemo;
  }

  public void setRoleMemo(String roleMemo) {
    this.roleMemo = roleMemo;
  }

}
