package com.mingdao.domain;

/**
 * 订单状态，0：未确认，1：处理中，2：已完成，3：驳回
 * @author wushzh
 *
 */
public enum OrderStatus {

	UNCOMFORM(0), AUDITINDG(1), FINISHED(2), REJECT(3);
	private int value;
	private OrderStatus(int value)
	{
		this.value = value;
	}
    public int getValue() {
        return value;
    }
    
}
