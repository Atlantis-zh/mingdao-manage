package com.mingdao.domain;

/**
 *
 * <code>Sex<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午7:42:25
 * @author libinf
 */

public enum Sex {
	MEN(1), WOMEN(2);

	private int value;

	private Sex(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }
}
