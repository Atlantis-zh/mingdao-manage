package com.mingdao.domain;

/**
 *
 * <code>Store<code> <strong></strong>
 * <p>
 * 说明：门店实体
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午10:57:03
 * @author libinf
 */

public class Store extends SuperVO {

  private static final long serialVersionUID = 2155405917909038177L;

  private Long id;
  /**
   * 门店编码
   */
  private String code;
  /**
   * 门店名称
   */
  private String name;
  /**
   * 电话1
   */
  private String tel1;
  /**
   * 电话2
   */
  private String tel2;
  /**
   * 电话3
   */
  private String tel3;
  /**
   * 地址
   */
  private String address;
  /**
   * 微信上显示门店
   */
  private Boolean isWxShow;
  /**
   * 是否微信默认门店
   */
  private Boolean isWxDefault;

  /**
   * 是否总店
   */
  private Boolean isHeadStore;

  /**
   * 微信公众号id
   */
  private String wxPubAccId;

  public static final String ID = "id";
  public static final String CODE = "code";
  public static final String NAME = "name";
  public static final String TEL1 = "tel1";
  public static final String TEL2 = "tel2";
  public static final String TEL3 = "tel3";
  public static final String ADDRESS = "address";
  public static final String ISWXSHOW = "isWxShow";

  public static final String ISWXDEFAULT = "isWxDefault";
  public static final String ISHEADSTORE = "isHeadStore";


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

  public String getTel1() {
    return this.tel1;
  }

  public void setTel1(String tel1) {
    this.tel1 = tel1;
  }

  public String getTel2() {
    return this.tel2;
  }

  public void setTel2(String tel2) {
    this.tel2 = tel2;
  }

  public String getTel3() {
    return this.tel3;
  }

  public void setTel3(String tel3) {
    this.tel3 = tel3;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Boolean getIsWxShow() {
    return this.isWxShow;
  }

  public void setIsWxShow(Boolean isWxShow) {
    this.isWxShow = isWxShow;
  }

  public Boolean getIsWxDefault() {
    return this.isWxDefault;
  }

  public void setIsWxDefault(Boolean isWxDefault) {
    this.isWxDefault = isWxDefault;
  }

  public Boolean getIsHeadStore() {
    return this.isHeadStore;
  }

  public void setIsHeadStore(Boolean isHeadStore) {
    this.isHeadStore = isHeadStore;
  }

  public String getWxPubAccId() {
    return this.wxPubAccId;
  }

  public void setWxPubAccId(String wxPubAccId) {
    this.wxPubAccId = wxPubAccId;
  }



}
