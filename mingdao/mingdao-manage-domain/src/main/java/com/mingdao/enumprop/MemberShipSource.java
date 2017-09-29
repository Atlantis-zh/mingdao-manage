package com.mingdao.enumprop;

/**
 *
 * <code>MemberShipSource<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午10:30:09
 * @author libinf
 */

public enum MemberShipSource {
	OWNSHOP(1), SHARE(2);
	private int value;

	private MemberShipSource(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
