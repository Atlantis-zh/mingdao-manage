package com.mingdao.domain;

import com.mingdao.enumprop.OrderStatus;
import com.mingdao.enumprop.Source;

/**
 *
 * <code>WeChatOrder<code> <strong></strong>
 * <p>
 * 
 * <li>预约管理</li>
 * </p>
 * 
 * @since
 * @version
 * @author libinf
 */
public class OrderProject extends SuperVO {

  private static final long serialVersionUID = -3005949063603134227L;
  private Long id;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 订单号
   */
  private String billno;
  /**
   * 预约员工
   */
  private Long orderUserId;
  /**
   * 预约项目
   */
  private Long serviceProjectId;
  /**
   * 预约时间
   */
  private String orderTime;
  /**
   * 车牌号
   */
  private String carNo;
  /**
   * 顾客姓名
   */
  private Long customerId;
  /**
   * 预约类型
   */
  private Source source;
  /**
   * 备注
   */
  private String meno;
  /**
   * 处理状态
   */
  private OrderStatus status;
  /**
   * 联系方式
   */
  private String linkTel;

  public static final String ID = "id";
  public static final String STOREID = "storeId";
  public static final String BILLNO = "billno";
  public static final String ORDERUSERID = "orderUserId";

  public static final String SERVICEPROJECTID = "serviceProjectId";
  public static final String ORDERTIME = "orderTime";
  public static final String CARNO = "carNo";
  public static final String CUSTOMERID = "customerId";
  public static final String SOURCE = "source";
  public static final String MEMO = "memo";
  public static final String STATUS = "status";
  public static final String LINKMANNAME = "linkmanName";
  public static final String LINKTEL = "linkTel";

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

  public String getBillno() {
    return this.billno;
  }

  public void setBillno(String billno) {
    this.billno = billno;
  }

  public Long getOrderUserId() {
    return this.orderUserId;
  }

  public void setOrderUserId(Long orderUserId) {
    this.orderUserId = orderUserId;
  }

  public Long getServiceProjectId() {
    return this.serviceProjectId;
  }

  public void setServiceProjectId(Long serviceProjectId) {
    this.serviceProjectId = serviceProjectId;
  }

  public String getOrderTime() {
    return this.orderTime;
  }

  public void setOrderTime(String orderTime) {
    this.orderTime = orderTime;
  }

  public String getCarNo() {
    return this.carNo;
  }

  public void setCarNo(String carNo) {
    this.carNo = carNo;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Source getSource() {
    return this.source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

  public String getMeno() {
    return meno;
  }

  public void setMeno(String meno) {
    this.meno = meno;
  }

  public OrderStatus getStatus() {
    return this.status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public String getLinkTel() {
    return this.linkTel;
  }

  public void setLinkTel(String linkTel) {
    this.linkTel = linkTel;
  }



}
