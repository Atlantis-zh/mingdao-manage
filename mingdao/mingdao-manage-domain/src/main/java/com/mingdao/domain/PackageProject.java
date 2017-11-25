package com.mingdao.domain;

/**
 *
 * <code>PackageProject<code> <strong></strong>
 * <p>
 * 说明：套餐项目，价格问题需要处理 一致性保障
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午1:58:07
 * @author libinf
 */

public class PackageProject extends SuperVO {

  private static final long serialVersionUID = 8282430932091772169L;
  private Long id;
  /**
   * 套餐类型
   */
  private Long pkgTypeId;
  /**
   * 套餐项目 参照服务项目
   */
  private Long serviceProjectId;

  /**
   * 服务次数
   */
  private Integer serviceCount;

  public static final String ID = "id";
  public static final String PKGTYPEID = "pkgTypeId";
  public static final String SERVICEID = "serviceid";
  public static final String PKGITEMID = "pkgItemId";
  public static final String SERVICECOUNT = "serviceCount";

  public static final String PRICE = "price";


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPkgTypeId() {
    return this.pkgTypeId;
  }

  public void setPkgTypeId(Long pkgTypeId) {
    this.pkgTypeId = pkgTypeId;
  }


  public Integer getServiceCount() {
    return this.serviceCount;
  }

  public void setServiceCount(Integer serviceCount) {
    this.serviceCount = serviceCount;
  }


  public Long getServiceProjectId() {
    return this.serviceProjectId;
  }

  public void setServiceProjectId(Long serviceProjectId) {
    this.serviceProjectId = serviceProjectId;
  }



}
