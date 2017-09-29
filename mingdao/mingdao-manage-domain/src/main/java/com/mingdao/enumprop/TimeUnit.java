package com.mingdao.enumprop;

/**
 *
 * <code>TimeUnit<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午10:27:49
 * @author libinf
 */

public enum TimeUnit {
	YEAR(1), MONTH(2), DAY(3);

	private int value;

	private TimeUnit(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
