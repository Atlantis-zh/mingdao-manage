package com.mingdao.domain;

/**
 *
 * <code>IntegralRule<code> <strong></strong>
 * <p>
 * 说明：积分规则设置
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 上午9:13:38
 * @author libinf
 */

public class IntegralRule extends SuperVO {
	private static final long serialVersionUID = 8776442116494739038L;
	private Long id;
	private Long storeId;
	private Long cardTypeId;
	private Double consume;
	private String memo;

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

	public Long getCardTypeId() {
		return this.cardTypeId;
	}

	public void setCardTypeId(Long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public Double getConsume() {
		return this.consume;
	}

	public void setConsume(Double consume) {
		this.consume = consume;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
