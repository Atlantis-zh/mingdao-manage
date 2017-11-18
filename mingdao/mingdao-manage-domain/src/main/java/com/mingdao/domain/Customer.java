package com.mingdao.domain;

import com.mingdao.enumprop.Sex;

/**
 *
 * <code>Customer<code> <strong></strong>
 * <p>
 * 说明：客户信息
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午7:16:03
 * @author libinf
 */

public class Customer extends SuperVO {

  private static final long serialVersionUID = -4687082890840731804L;

  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 姓名
   */
  private String name;
  /**
   * 编码
   */
  private String code;
  /**
   * 微信昵称
   */
  private String wxNickName;
  /**
   * 生日
   */
  private String birthday;
  /**
   * 手机
   */
  private String phone;
  /**
   * 身份证
   */
  private String identityId;
  /**
   * 客户来源
   */
  private Long custSourceId;
  /**
   * 客户类型
   */
  private Long custTypeId;
  /**
   * 车牌识别
   */
  private Boolean lpr;
  /**
   * 性别
   */
  private Sex sex;
  /**
   * 地址
   */
  private String address;

  public static final String ID = "id";
  public static final String STOREID = "storeId";
  public static final String NAME = "name";
  public static final String CODE = "code";
  public static final String WXNICKNAME = "wxNickName";
  public static final String BIRTHDAY = "birthday";
  public static final String PHONE = "phone";
  public static final String IDENTITYID = "identityId";
  public static final String CUSTSOURCE = "custSource";
  public static final String CUSTTYPEID = "custTypeId";
  public static final String LPR = "lpr";
  public static final String SEX = "sex";
  public static final String ADDRESS = "address";
  public static final String SYSTEMTIME = "systemTime";

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

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getWxNickName() {
    return this.wxNickName;
  }

  public void setWxNickName(String wxNickName) {
    this.wxNickName = wxNickName;
  }

  public String getBirthday() {
    return this.birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getIdentityId() {
    return this.identityId;
  }

  public void setIdentityId(String identityId) {
    this.identityId = identityId;
  }

  public Long getCustTypeId() {
    return this.custTypeId;
  }

  public void setCustTypeId(Long custTypeId) {
    this.custTypeId = custTypeId;
  }

  public Boolean getLpr() {
    return this.lpr;
  }

  public void setLpr(Boolean lpr) {
    this.lpr = lpr;
  }

  public Sex getSex() {
    return this.sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getCustSourceId() {
    return this.custSourceId;
  }

  public void setCustSourceId(Long custSourceId) {
    this.custSourceId = custSourceId;
  }

}
