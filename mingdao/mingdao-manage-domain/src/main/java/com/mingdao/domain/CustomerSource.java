package com.mingdao.domain;

/**
 *
 * <code>CustomerSou<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午10:42:09
 * @author libinf
 */

public enum CustomerSource {
	WEIXIN(1), STORE(2);
	private int value;
	private CustomerSource(int value)
	{
		this.value = value;
	}
    public int getValue() {
        return value;
    }
}
