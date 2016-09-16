package com.exception;

public class MyException extends Exception{
	private static final long serialVersionUID = 2745296024272870958L;

	public MyException(){
		super("自定义异常");
	}
	
	public MyException(String errorMsg){
		super(errorMsg);
	}
	
	public MyException(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
}
