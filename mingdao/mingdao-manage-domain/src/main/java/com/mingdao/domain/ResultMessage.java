package com.mingdao.domain;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * <code>ResultMessage<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2016年8月4日 上午9:15:45
 * @author libinf
 */

public class ResultMessage extends JSONObject {

	private static final long serialVersionUID = -5870675404293317660L;

	public static final String SUCCESS = "success";
	public static final String CODE = "code";
	public static final String RESULTMSG = "resultMsg";
	public static final String RESULT = "result";

	public ResultMessage() {
		super();
		this.put(SUCCESS, true);
	}

	public void setSuccess(Boolean success) {
		this.put(SUCCESS, success);
	}

	/**
	 * 
	 * <p>
	 * 说明：判断是否成功，默认是失败
	 * <li></li>
	 * </p>
	 * 
	 * @return
	 * @date 2017年4月5日 下午1:58:54
	 * @since
	 */
	public Boolean isSuccess() {
		if (this.containsKey(SUCCESS)) {
			return this.getBoolean(SUCCESS);
		}
		return false;
	}

	public String getResultMsg() {
		if (this.containsKey(RESULTMSG)) {
			return this.getString(RESULTMSG);
		}
		return null;
	}

	public void setResultMsg(String resultMessage) {
		this.put(RESULTMSG, resultMessage);
	}

	public String getCode() {
		if (this.containsKey(CODE)) {
			return this.getString(CODE);
		}
		return null;
	}

	public void setCode(String code) {
		this.put(CODE, code);
	}

	public Object getResult() {
		if (this.containsKey(RESULT)) {
			return this.get(RESULT);
		}
		return null;
	}

	public void setResult(Object obj) {
		this.put(RESULT, obj);
	}

}
