package com.mingdao.domain;

/**
 *
 * <code>ExchangeGift<code> <strong></strong>
 * <p>
 * 说明：积分兑换礼品设置
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月4日 上午9:53:01
 * @author libinf
 */

public class ExchangeGift extends SuperVO {

	private static final long serialVersionUID = -4392477803031062843L;
	private Long id;
	private Long storeId;
	private String name;
	private Integer points;
	
	public static final String ID ="id";
	public static final String  NAME="name";
	public static final String  STOREID="storeId";	
	public static final String  POINTS="points";

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

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}


}
