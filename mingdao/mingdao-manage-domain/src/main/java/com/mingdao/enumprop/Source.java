package com.mingdao.enumprop;

/**
 * 来源类型，1：微信，2：电脑
 * 
 * @author wushzh
 *
 */
public enum Source {

	WEIXIN(1), PC(2);
	private int value;
	private Source(int value)
	{
		this.value = value;
	}
    public int getValue() {
        return value;
    }
}
