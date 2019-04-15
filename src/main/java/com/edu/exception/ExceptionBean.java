package com.edu.exception;

import java.io.Serializable;

public class ExceptionBean implements Serializable
{
	private static final long serialVersionUID = 3612529074138518136L;
 
	private Integer code;
 
	private String msg;
 
	public ExceptionBean() {
	}
 
	public ExceptionBean(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "code:".concat(code.toString()).concat("msg:").concat(msg);
	}
 
	public Integer getCode() {
		return code;
	}
 
	public void setCode(Integer code) {
		this.code = code;
	}
 
	public String getMsg() {
		return msg;
	}
 
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
