package com.mingdao.enumprop;

/**
 * 来源类型，1：微信，2：电脑
 * 
 * @author wushzh
 *
 */
public enum Source {

	WECHET(1), STORE(2);
	private int value;
	private Source(int value)
	{
		this.value = value;
	}
    public int getValue() {
        return value;
    }
}
