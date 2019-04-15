package com.edu.exception;
/**
 * 报警时异常
 * @author Administrator
 */
public class AlarmRuntimeException extends RuntimeException
{
	private static final long serialVersionUID = -3208398073746622202L;
	
	private String msg;
 
	public AlarmRuntimeException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public AlarmRuntimeException(String msg,Throwable t) {
		super(msg,t);
		this.msg = msg;
	}
 
	public String getMsg() {
		return msg;
	}
 
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
