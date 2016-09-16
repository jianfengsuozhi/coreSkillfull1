package com.exception;

import org.slf4j.Logger;

public class MyObjectMultiple extends RuntimeException{
	private static final long serialVersionUID = -3204277957181103776L;
	
	public MyObjectMultiple(){
		super("对象存在多个异常");
	}
	
	public MyObjectMultiple(String errorMsg){
		super(errorMsg);
	}
	
	public MyObjectMultiple(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
	
	public static MyObjectMultiple create(Logger logger,String errorMsg){
		logger.error(errorMsg);
		return new MyObjectMultiple(errorMsg);
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
