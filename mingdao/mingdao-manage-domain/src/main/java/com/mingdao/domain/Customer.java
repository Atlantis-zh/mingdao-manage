package com.mingdao.domain;

import java.sql.Timestamp;

/**
 *
 * <code>Customer<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月26日 下午7:16:03
 * @author libinf
 */

public class Customer extends SuperVO {

	private static final long serialVersionUID = -4687082890840731804L;

	private Long id;
	private Long storeId;
	private String name;
	private String code;
	private String wxNickName;
	private Timestamp birthday;
	private String phone;
	private String identityId;
	private String custSource;
	private String custType;
	private Boolean lpr;
	private Sex sex;
	private String address;
	private String platNumber;
	private Double carPrice;
	private Timestamp annualExpiration;
	private String addressOfPerson;
	private Double nextServiceCyc;


}
