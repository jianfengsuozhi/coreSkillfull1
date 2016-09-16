package com.exception;

import org.slf4j.Logger;

public class MyObjectNullException extends RuntimeException{
	private static final long serialVersionUID = -1982603538631129506L;
	
	public MyObjectNullException(){
		super("对象为null或集合为空异常");
	}
	
	public MyObjectNullException(String errorMsg){
		super(errorMsg);
	}
	
	public MyObjectNullException(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
	
	public static MyObjectNullException create(Logger logger,String errorMsg){
		logger.error(errorMsg);
		return new MyObjectNullException(errorMsg);
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
