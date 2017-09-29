package com.mingdao.test;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * <code>TestDateTime<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月27日 上午10:40:44
 * @author libinf
 */

public class TestDateTime {

	/**
	 * <p>
	 * 说明：
	 * <li></li>
	 * </p>
	 * 
	 * @param args
	 * @date 2017年9月27日 上午10:40:44
	 * @since
	 */
	public static void main(String[] args) {
		Timestamp t = new Timestamp(new Date().getTime());
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		System.out.println(t.toString());
	}

}
