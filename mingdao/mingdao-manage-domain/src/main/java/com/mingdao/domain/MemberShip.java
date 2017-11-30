package com.mingdao.domain;

/**
 *
 * <code>MemberShip<code> <strong></strong>
 * <p>
 * 说明：会员信息
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 下午3:00:30
 * @author libinf
 */

public class MemberShip extends SuperVO {

  private static final long serialVersionUID = -4889307883072203606L;

  private Long id;
  /**
   * 卡号
   */
  private String cardNo;
  /**
   * 所属门店
   */
  private Long storeId;
  /**
   * 客户
   */
  private Long customerId;
  /**
   * 车辆信息
   */
  private Long carInfoId;
  /**
   * 会员卡种
   */
  private Long memberShipCardId;
  /**
   * 计次套餐
   */
  private Long packageTypeId;
  /**
   * 现金
   */
  private Double crash;
  /**
   * 积分
   */
  private Integer points;
  /**
   * 余额
   */
  private Double remaining;
  /**
   * 总剩余次数
   */
  private Integer totalRemainCount;
  /**
   * 提成人员
   */
  private Long percentagePsnId;
  /**
   * 备注
   */
  private String memo;
  
  private MemberShipRefDTO dto;
  
  private CarInfo carinfo;
  
  public CarInfo getCarinfo() {
	return carinfo;
}

public void setCarinfo(CarInfo carinfo) {
	if(dto==null){
		dto=createDTO();
	}
	if(carinfo==null){
		this.carinfo=null;
	}
	dto.setPlatNumber(carinfo.getPlatNumber());
	this.carinfo = carinfo;
}

public MemberShipRefDTO getDto() {
	  if(dto==null){
		  dto=createDTO();
	  }
	return dto;
}

public void setDto(MemberShipRefDTO dto) {
	this.dto = dto;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	if(dto==null){
		  dto=createDTO();
	  }
	dto.setCustName(customer.getCode());
	dto.setCustPhone(customer.getPhone());
	this.customer = customer;
}

private Customer customer;

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

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getCarInfoId() {
    return this.carInfoId;
  }

  public void setCarInfoId(Long carInfoId) {
    this.carInfoId = carInfoId;
  }

  public Long getMemberShipCardId() {
    return this.memberShipCardId;
  }

  public void setMemberShipCardId(Long memberShipCardId) {
    this.memberShipCardId = memberShipCardId;
  }

  public Long getPackageTypeId() {
    return this.packageTypeId;
  }

  public void setPackageTypeId(Long packageTypeId) {
    this.packageTypeId = packageTypeId;
  }

  public Double getCrash() {
    return this.crash;
  }

  public void setCrash(Double crash) {
    this.crash = crash;
  }

  public Integer getPoints() {
    return this.points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public Double getRemaining() {
    return this.remaining;
  }

  public void setRemaining(Double remaining) {
    this.remaining = remaining;
  }

  public Integer getTotalRemainCount() {
    return this.totalRemainCount;
  }

  public void setTotalRemainCount(Integer totalRemainCount) {
    this.totalRemainCount = totalRemainCount;
  }

  public Long getPercentagePsnId() {
    return this.percentagePsnId;
  }

  public void setPercentagePsnId(Long percentagePsnId) {
    this.percentagePsnId = percentagePsnId;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getCardNo() {
    return this.cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
  }
  
  private MemberShipRefDTO createDTO(){
	  MemberShipRefDTO dto = new MemberShipRefDTO();
	  dto.setCardNo(this.getCardNo());
	  dto.setCarInfoId(this.getCarInfoId());
	  dto.setCustomerId(this.getCustomerId());
	  dto.setId(this.getId());
	  dto.setCrash(this.getCrash());
	  dto.setPackageTypeId(this.getPackageTypeId());
	  dto.setMemberShipCardId(this.getMemberShipCardId());
	  dto.setPercentagePsnId(this.getPercentagePsnId());
	  dto.setStoreId(this.getStoreId());
	  return dto;
	  
  }



}
