package com.mingdao.enumprop;

/**
 * 预约来源类型，1：微信，2：电脑
 * @author wushzh
 *
 */
public enum OrderResource {

	WECHET(1), STORE(2);
	private int value;
	private OrderResource(int value)
	{
		this.value = value;
	}
    public int getValue() {
        return value;
    }
}
