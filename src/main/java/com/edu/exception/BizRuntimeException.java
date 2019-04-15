package com.edu.exception;
/**
 * 业务异常
 * @author Administrator
 */
public class BizRuntimeException extends RuntimeException
{
	private static final long serialVersionUID = 439936386847345501L;
 
	private Integer code;
 
	private String msg;
	
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
 
	public BizRuntimeException(Integer code, String msg) {
		super("code:".concat(code.toString()).concat("msg:").concat(msg));
		this.code = code;
		this.msg = msg;
	}
 
	public BizRuntimeException(Integer code, String msg, Throwable t) {
		super("code:".concat(code.toString()).concat("msg:").concat(msg), t);
		this.code = code;
		this.msg = msg;
	}
	
	
	public BizRuntimeException(ExceptionBean exceptionBean) {
		super("code:".concat(exceptionBean.getCode().toString()).concat("msg:").concat(exceptionBean.getMsg()));
		this.code = exceptionBean.getCode();
		this.msg = exceptionBean.getMsg();
	}
 
	public BizRuntimeException(ExceptionBean exceptionBean, Throwable t) {
		super("code:".concat(exceptionBean.getCode().toString()).concat("msg:").concat(exceptionBean.getMsg()),t);
		this.code = exceptionBean.getCode();
		this.msg = exceptionBean.getMsg();
	}
	
	public BizRuntimeException(ExceptionEnum exceptionEnum) {
		super("code:".concat(exceptionEnum.getCode().toString()).concat("msg:").concat(exceptionEnum.getMsg()));
		this.code = exceptionEnum.getCode();
		this.msg = exceptionEnum.getMsg();
	}
 
	public BizRuntimeException(ExceptionEnum exceptionEnum, Throwable t) {
		super("code:".concat(exceptionEnum.getCode().toString()).concat("msg:").concat(exceptionEnum.getMsg()),t);
		this.code = exceptionEnum.getCode();
		this.msg = exceptionEnum.getMsg();
	}
	

}
