package com.exception;

import org.slf4j.Logger;

public class MyIllegalArgumentException extends IllegalArgumentException{
	private static final long serialVersionUID = -6549099593470269262L;
	
	public MyIllegalArgumentException(){
		super("不合法参数异常");
	}
	
	public MyIllegalArgumentException(String errorMsg){
		super(errorMsg);
	}
	
	public MyIllegalArgumentException(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
	
	public static MyIllegalArgumentException create(Logger logger,String errorMsg){
		logger.error(errorMsg);
		return new MyIllegalArgumentException(errorMsg);
	}
	
	public static void checkTrue(Boolean expression,Logger logger,String errorMsg){
		if(expression){
			throw create(logger, errorMsg);
		}
	}
	
	public static void checkNull(Object reference,Logger logger,String errorMsg){
		if(null == reference){
			throw create(logger, errorMsg);
		}
	}
}
