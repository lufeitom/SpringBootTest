package com.edu.exception;

import java.text.MessageFormat;
import java.util.Collection;

public enum ExceptionEnum
{
	SYSTEM_ERROR(001,"系统错误，请再试一次"),
	PARAM_EMPTY(002,"参数{0}不能为空"),
	PARAM_ERROR(003,"参数{0}不可用");

	private static final String EMPTY = "";
 
	private Integer code;
 
	private String msg;
 
	private ExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
 
	public ExceptionBean addPams(Object... objs) {
		if (objs == null || objs.length <= 0) {
			return new ExceptionBean(getCode(), EMPTY);
		}
		return new ExceptionBean(getCode(), MessageFormat.format(getMsg(), objs));
	}
 
	public ExceptionBean addPams(Collection<?> coll) {
		if (coll == null || coll.size() <= 0) {
			return new ExceptionBean(getCode(), EMPTY);
		}
		return addPams(coll.toArray());
	}
 
	public ExceptionBean appendMsg(String app) {
		return new ExceptionBean(getCode(), getMsg().concat(app));
	}
 
	@Override
	public String toString() {
		return "code:".concat(getCode().toString()).concat("msg:").concat(getMsg());
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
