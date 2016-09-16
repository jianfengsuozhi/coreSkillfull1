package com.exception;

import org.slf4j.Logger;

public class MyDBFailException extends RuntimeException{
	private static final long serialVersionUID = 2257456418084726193L;
	public MyDBFailException(){
		super("数据库连接失败异常");
	}
	
	public MyDBFailException(String errorMsg){
		super(errorMsg);
	}
	
	public MyDBFailException(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
	
	public static MyDBFailException create(Logger logger,String errorMsg){
		logger.error(errorMsg);
		return new MyDBFailException(errorMsg);
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
