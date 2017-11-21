package com.mingdao.domain;

/**
 *
 * <code>MemberShipCard<code> <strong></strong>
 * <p>
 * 说明：会员卡卡种
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午10:08:08
 * @author libinf
 */

public class MemberShipCard extends SuperVO {

  private static final long serialVersionUID = 4880427304245376008L;

  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 卡名
   */
  private String name;
  /**
   * 编号
   */
  private String code;
  /**
   * 开卡充值
   */
  private Double cardRecharge;
  /**
   * 开卡赠送
   */
  private Double cardDonate;
  /**
   * 有效期
   */
  private Integer expire;
  /**
   * 有效期单位 1年 2月 3天
   */
  private Integer timeUnit;
  /**
   * 会员卡图片
   */
  private String cardPicture;
  /**
   * 共享到分店
   */
  private Boolean shareToBranch;
  /**
   * 来源
   */
  private Integer source;
  /**
   * 绑定套餐
   */
  private Long bindPackage;
  /**
   * 卡状态
   */
  private Integer cardStatus;
  /**
   * 备注
   */
  private String memo;

  public static final String ID = "id";
  public static final String STOREID = "storeId";
  public static final String NAME = "name";
  public static final String CARDRECHARGE = "cardRecharge";
  public static final String CARDDONATE = "cardDonate";
  public static final String EXPIRE = "expire";
  public static final String TIMEUNIT = "timeUnit";
  public static final String CARDPRICTURE = "cardPicture";
  public static final String SHARETOBRANCH = "shareToBranch";
  public static final String SOURCE = "source";
  public static final String BINIDPACKAGE = "bindPackage";
  public static final String STATUS = "status";
  public static final String MENO = "memo";


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

  public Double getCardRecharge() {
    return this.cardRecharge;
  }

  public void setCardRecharge(Double cardRecharge) {
    this.cardRecharge = cardRecharge;
  }

  public Double getCardDonate() {
    return this.cardDonate;
  }

  public void setCardDonate(Double cardDonate) {
    this.cardDonate = cardDonate;
  }

  public Integer getExpire() {
    return this.expire;
  }

  public void setExpire(Integer expire) {
    this.expire = expire;
  }

  public Integer getTimeUnit() {
    return this.timeUnit;
  }

  public void setTimeUnit(Integer timeUnit) {
    this.timeUnit = timeUnit;
  }

  public String getCardPicture() {
    return this.cardPicture;
  }

  public void setCardPicture(String cardPicture) {
    this.cardPicture = cardPicture;
  }

  public Boolean getShareToBranch() {
    return this.shareToBranch;
  }

  public void setShareToBranch(Boolean shareToBranch) {
    this.shareToBranch = shareToBranch;
  }

  public Integer getSource() {
    return this.source;
  }

  public void setSource(Integer source) {
    this.source = source;
  }

  public Long getBindPackage() {
    return this.bindPackage;
  }

  public void setBindPackage(Long bindPackage) {
    this.bindPackage = bindPackage;
  }


  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getCardStatus() {
    return this.cardStatus;
  }

  public void setCardStatus(Integer cardStatus) {
    this.cardStatus = cardStatus;
  }



}
