package com.mingdao.domain;

import java.sql.Timestamp;

import com.mingdao.enumprop.MemberShipSource;
import com.mingdao.enumprop.Status;
import com.mingdao.enumprop.TimeUnit;

/**
 *
 * <code>MemberShipCard<code> <strong></strong>
 * <p>
 * 说明：会员卡实体
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
	private Long storeId;
	private String name;
	private Double cardRecharge;
	private Double cardDonate;
	private Integer expire;
	private TimeUnit timeUnit;
	private String cardPicture;
	private Boolean shareToBranch;
	private MemberShipSource source;
	private Long bindPackage;
	private Status status;
	private String memo;
	
	public static final String ID ="id";
	public static final String  STOREID="storeId";
	public static final String  NAME="name";
	public static final String  CARDRECHARGE="cardRecharge";
	public static final String  CARDDONATE="cardDonate";
	public static final String  EXPIRE="expire";
	public static final String  TIMEUNIT="timeUnit";
	public static final String  CARDPRICTURE="cardPicture";
	public static final String  SHARETOBRANCH="shareToBranch";
	public static final String  SOURCE="source";
	public static final String  BINIDPACKAGE="bindPackage";
	public static final String  STATUS="status";
	public static final String  MENO="memo";


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

	public TimeUnit getTimeUnit() {
		return this.timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
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

	public MemberShipSource getSource() {
		return this.source;
	}

	public void setSource(MemberShipSource source) {
		this.source = source;
	}

	public Long getBindPackage() {
		return this.bindPackage;
	}

	public void setBindPackage(Long bindPackage) {
		this.bindPackage = bindPackage;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}



}
