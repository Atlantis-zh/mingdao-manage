package com.mingdao.domain;

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
  private Long orderPsnId;
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
  private Long carInfoId;
  /**
   * 顾客姓名
   */
  private Long customerId;
  /**
   * 预约类型 1：微信，2：电脑
   */
  private Integer source;
  /**
   * 备注
   */
  private String meno;

  private String    serviceName;
  private String       carNo;
  private String customerName;
  /**
   * 0：未确认，1：处理中，2：已完成，3：驳回
   */
  private Integer status;

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

  public Long getOrderPsnId() {
    return this.orderPsnId;
  }

  public void setOrderPsnId(Long orderPsnId) {
    this.orderPsnId = orderPsnId;
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

  public Long getCarInfoId() {
    return this.carInfoId;
  }

  public void setCarInfoId(Long carInfoId) {
    this.carInfoId = carInfoId;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Integer getSource() {
    return this.source;
  }

  public void setSource(Integer source) {
    this.source = source;
  }

  public String getMeno() {
    return this.meno;
  }

  public void setMeno(String meno) {
    this.meno = meno;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getCarNo() {
    return carNo;
  }

  public void setCarNo(String carNo) {
    this.carNo = carNo;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
}
