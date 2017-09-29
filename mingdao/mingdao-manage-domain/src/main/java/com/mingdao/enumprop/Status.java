package com.mingdao.enumprop;

/**
 *
 * <code>Status<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午10:32:06
 * @author libinf
 */

public enum Status {
	ENABLE(1), DISABLE(2);

	private int value;

	private Status(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}
}
