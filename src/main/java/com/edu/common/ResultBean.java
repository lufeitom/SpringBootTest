package com.edu.common;

import org.apache.http.HttpStatus;

/**
 * 返回数据
 * 
 */
public class ResultBean {
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Object body;

	public ResultBean() {
		this.code = HttpStatus.SC_OK;
		this.msg = "success";
	}

	public static ResultBean error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}

	public static ResultBean error(String msg) {
		return error(0, msg);
	}

	public static ResultBean error(int code, String msg) {
		ResultBean r = new ResultBean();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}

	public static ResultBean ok(Object object) {
		ResultBean r = new ResultBean();
		r.setBody(object);
		return r;
	}

	public static ResultBean ok() {
		return new ResultBean();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
